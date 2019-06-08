package org.autumn.revolution.j2se.demo.javaagent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class FirstAgent implements ClassFileTransformer {
    public final String injectedClassName = "com.xueyou.agentdemo.App";
    public final String methodName = "hello";

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        className = className.replace("/", ".");
        if (className.equals(injectedClassName)) {
            CtClass ctclass = null;
            try {
                // 使用全称,用于取得字节码类<使用javassist>
                ctclass = ClassPool.getDefault().get(className);
                // 得到这方法实例
                CtMethod ctmethod = ctclass.getDeclaredMethod(methodName);
                ctmethod.insertBefore("System.out.println(11111111);");
                return ctclass.toBytecode();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return null;
    }
}

