package structural_patterns.proxy_pattern;


//抽象主题
interface Subject{
    void show();
}

//真实主题
class RealSubject implements Subject{

    @Override
    public void show() {
        System.out.println("---我是真实类---");
    }

}

/**
 * 静态代理
 */
public class StaticProxy implements Subject{

    private Subject subject;


    @Override
    public void show() {
        if(subject == null)
            subject = new RealSubject();
        System.out.println("---真实类调用之前---");
        subject.show();
        System.out.println("---真实类调用之后---");
    }
    
}

class Test{
    public static void main(String[] args) {
        StaticProxy proxy = new StaticProxy();
        proxy.show();
    }
}
