package org.autumn.revolution.web.redis;

import java.util.Map;

/**
 * Created by guofeng.
 */
public interface IRedisService {

	public void del(String key);

	public void set(String key, String value);
    
	public void put(String key1, String key2, Object value);

	public String get(String key);
	
	public Object get(String key1, String key2);

	public boolean exists(String key);

	void expire(String key, long liveTime);

	void hashPutAll(String key, Map<String, String> map);

	String getRedisLock(String lockKey, final int lockExpireTime);

	void releaseRedisLock(String lockKey, String lockValue);
}
