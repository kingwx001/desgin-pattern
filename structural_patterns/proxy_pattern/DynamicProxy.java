package structural_patterns.proxy_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;



public class DynamicProxy implements InvocationHandler{

    private Subject subject;

    public Subject newInstanceProxy(Subject subject){
        this.subject = subject;
        return (Subject)Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--动态代理前逻辑--");
        Object result = method.invoke(this.subject, args);
        System.out.println("--动态代理后逻辑--");
        return result;
    }
    
}



class Test1{
    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy();
        Subject newInstanceProxy = dynamicProxy.newInstanceProxy(new RealSubject());
        newInstanceProxy.show();
    }
}
