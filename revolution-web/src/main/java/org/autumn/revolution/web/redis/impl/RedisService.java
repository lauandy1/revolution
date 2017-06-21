package org.autumn.revolution.web.redis.impl;


import org.autumn.revolution.web.redis.IRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by guofeng.
 */
public class RedisService implements IRedisService {

	private static Logger LOGGER = LoggerFactory.getLogger(RedisService.class);

	private int liveTime;

	@Resource
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public void del(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value, liveTime, TimeUnit.MINUTES);
	}
	
	@Override
	public void put(String key1, String key2, Object value) {
		redisTemplate.opsForHash().put(key1, key2, value);
	}

	@Override
	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	
	@Override
	public Object get(String key1, String key2) {
		return redisTemplate.opsForHash().get(key1, key2);
	}

	@Override
	public boolean exists(String key) {
		return redisTemplate.hasKey(key);
	}

	@Override
	public void expire(String key, long liveTime) {
		redisTemplate.expire(key, liveTime, TimeUnit.SECONDS);
	}

	@Override
	public void hashPutAll(String key, Map<String, String> map) {
		redisTemplate.opsForHash().putAll(key, map);
	}

	public void setLiveTime(int liveTime) {
		this.liveTime = liveTime;
	}

	public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public String getRedisLock(String lockKey, final int lockExpireTime) {
		final RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
		// if fail to get lock, exit current job
		final byte[] lockKeyBytes = redisSerializer.serialize(lockKey);
		final String value = UUID.randomUUID().toString();
		// get redis lock
		boolean isLocked = false;
		int num = 0;
		while(num < lockExpireTime - 10){
			num ++;
			isLocked = redisTemplate.execute(new RedisCallback<Boolean>() {
				@Override
				public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
					boolean flag = connection.setNX(lockKeyBytes, redisSerializer.serialize(value));
					return flag;
				}
			});
			// get the lock, break the loop
			if(isLocked){
				// set expired time for lock
				redisTemplate.execute(new RedisCallback<Boolean>() {
					@Override
					public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
						return connection.expire(lockKeyBytes, lockExpireTime);
					}
				});
				break;
			}else{
				// get the lock key expired time, if -1, set to 30sec
				long lockKeyExpiredTime = redisTemplate.getExpire(lockKey);
				// if unable to set expired time
				if(lockKeyExpiredTime == -1){
					LOGGER.info("Previous ops fail to set expired time , so reset the expired time for lock key.");
					// set expired time for lock
					redisTemplate.execute(new RedisCallback<Boolean>() {
						@Override
						public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
							return connection.expire(lockKeyBytes, lockExpireTime);
						}
					});
					break;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(isLocked){
			return value;
		}
		return null;
	}

	@Override
	public void releaseRedisLock(String lockKey, String lockValue){
		if(!redisTemplate.hasKey(lockKey)){
			LOGGER.info("lockKey has expired");
			return;
		}
		final RedisSerializer<String> redisSerializer = redisTemplate.getStringSerializer();
		// if fail to get lock, exit current job
		final byte[] lockKeyBytes = redisSerializer.serialize(lockKey);
		byte[] valueArray = redisTemplate.execute(new RedisCallback<byte[]>() {
			@Override
			public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.get(lockKeyBytes);
			}
		});
		String lockValueTmp = new String(valueArray, Charset.forName("UTF-8"));
		LOGGER.info("lockValue:{}", lockValue);
		if(lockValue.equals(lockValueTmp)){
			redisTemplate.execute(new RedisCallback<Object>() {
				@Override
				public Object doInRedis(RedisConnection connection) throws DataAccessException {
					return connection.del(lockKeyBytes);
				}
			});
			LOGGER.info("current job delete lock");
		}else {
			LOGGER.info("current job has not lock");
		}
	}

}
