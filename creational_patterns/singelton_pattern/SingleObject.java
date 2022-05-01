package creational_patterns.singelton_pattern;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;



/**
 * 饿汉式，线程安全
 * 缺点，obj对象在类加载时期就已经导入内存，要是该类很久未使用，也会一直占内存
 * 解决方法:懒加载，用时创建对象
 */

/* public class SingleObject {
    private static SingleObject obj = new SingleObject();

    private SingleObject() {
        
    }

    public static SingleObject getInstance(){
        return obj;
    }

    public void show(){
        System.out.println("--singleton--");
    }
    
    public static void main(String[] args) {
        SingleObject obj1 = SingleObject.getInstance();
        SingleObject obj2 = SingleObject.getInstance();
        System.out.println(obj1 == obj2);
        obj1.show();
        obj2.show();

    }
} */

/**
 * 懒汉式，用时创建,
 * 缺点：多线程下不安全，
 * 原因：当线程1和线程2都执行到if(obj == null)语句时
 * 此时obj为空，线程1和2都会执行obj = new SingleObject()，创建了多个对象
 */

 /* 
public class SingleObject {
    private static SingleObject obj = null;

    private SingleObject() {
        
    }

    public static SingleObject getInstance(){

        if(obj == null){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            obj = new SingleObject();
        }
        return obj;
    }

    
    // 单线程情况
    public static void singleThread(){
        System.out.println("--进入单线程测试点--");
        SingleObject obj1 = SingleObject.getInstance();
        SingleObject obj2 = SingleObject.getInstance();
        System.out.println(obj1 == obj2);//true
    }


    //多线程
    public static void multipleThread() {
        System.out.println("--进入多线程测试点runnable实现--");
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingleObject obj = SingleObject.getInstance();
                    System.out.println(obj);//2线程打印不同对象
             
                }
                
            }).start();
        }
     }

    public static void multipleThreadUsingCallable(){
        System.out.println("--进入多线程测试点callable实现--");
         SingleObject[] singleObjectsArray = new SingleObject[2];
        for (int i = 0; i < 2; i++) {
            FutureTask<SingleObject> futureTask = new FutureTask<SingleObject>(new Callable<SingleObject>(){

                @Override
                public SingleObject call() throws Exception {
                    SingleObject obj = SingleObject.getInstance();
                    System.out.println("runnable实现   " + obj);//2线程打印不同对象
                    return obj;
                }

            });

            new Thread(futureTask).start();

            try {
                singleObjectsArray[i] = futureTask.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("两对象是否相等：" + (singleObjectsArray[0] == singleObjectsArray[1]));
     }
     
     //主程序
     public static void main(String[] args) {
            SingleObject.multipleThread();
            SingleObject.obj = null;//以防不同测试受到干扰
            SingleObject.singleThread();
            SingleObject.obj = null;//以防不同测试受到干扰
            SingleObject.multipleThreadUsingCallable();
         
     }
}
 */

 
/**
 * 懒汉式+多线程
 */



/* public class SingleObject {
    private static SingleObject obj = null;

    private SingleObject() {
        
    }


    public synchronized static SingleObject getInstance() {
        if(obj == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            obj = new SingleObject();
        }

        return obj;
    }

    public static void multipleThread(){
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingleObject obj = SingleObject.getInstance();
                    System.out.println(obj);//2线程打印不同对象
             
                }
                
            }).start();
        }
    }
    //主程序
    public static void main(String[] args) {
        SingleObject.multipleThread();
    }
} */


/**
 * 线程安全
 * 懒汉式+双重锁
 */


/* public class SingleObject {
    private static SingleObject obj = null;

    private SingleObject() {
        
    }


    public static SingleObject getInstance() {
        if(obj == null){
            synchronized(SingleObject.class){
                if(obj == null){
                    obj = new SingleObject();
                }
            }
        }
        return obj;
    }

    public static void multipleThread(){
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingleObject obj = SingleObject.getInstance();
                    System.out.println(obj);//2线程打印不同对象
             
                }
                
            }).start();
        }
    }
    //主程序
    public static void main(String[] args) {
        SingleObject.multipleThread();
    }
}  */


/**
 * 登记式/静态内部类
 * 线程安全+懒汉式
 */

/* public class SingleObject {

    private static class SingletonHolder {  
        private static final SingleObject INSTANCE = new SingleObject();  
    }  

    private SingleObject (){}  

    public static final SingleObject getInstance() {  
        return SingletonHolder.INSTANCE;  
    } 

    public static void multipleThread(){
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingleObject obj = SingleObject.getInstance();
                    System.out.println(obj);//2线程打印不同对象
             
                }
                
            }).start();
        }
    }
    //主程序
    public static void main(String[] args) {
        SingleObject.multipleThread();
    }
} */ 

/**
 * 枚举
 * 线程安全+懒汉式
 * 
 * PS：枚举和私有静态内部类都是依靠java特性完成，交给java虚拟机操作来保证同步
 */


 public enum SingleObject{
    INSTANCE;
    
    private SingleObject() {
        System.out.println("--init--");
    }

    public static void main(String[] args) {
        System.out.println(SingleObject.INSTANCE.hashCode());
        System.out.println(SingleObject.INSTANCE.name());
        System.out.println(SingleObject.INSTANCE.ordinal());
        System.out.println(SingleObject.values());
        System.out.println(SingleObject.valueOf("INSTANCE"));
        System.out.println(SingleObject.INSTANCE.getDeclaringClass());
        System.out.println(SingleObject.INSTANCE.getClass());
    }
 }












