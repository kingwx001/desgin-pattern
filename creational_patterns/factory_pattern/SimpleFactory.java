package creational_patterns.factory_pattern;

public class SimpleFactory {
    public static void main(String[] args) {
       Animal dog = factory("Dog");      
           assert dog != null;      
           dog.run();      
           Animal cat = factory("Cat");      
           assert cat != null;      
           cat.run();   
     }
 
    public static Animal factory(String simpleName){
       //获取枚举类中对应的全类名      
       simpleName = AnimalEnum.getName(simpleName);      
       if(simpleName == null || simpleName.length() <= 0){
          return null;      
       }
       try {
          return (Animal) Class.forName(simpleName).getConstructor().newInstance();      
       } catch (Exception e) {
          e.printStackTrace();      
       }
       return null;   
    }
 }
 //动物接口
 interface Animal{
     void run();
 }
 //狗实现类
 class Dog implements Animal{
     public Dog() {}
     @Override   
     public void run() {
       System.out.println("小狗跑");   
     }
 }
 //猫实现类
 class Cat implements Animal{
     public Cat() {}
     @Override   
     public void run() {
       System.out.println("小猫跑");   
     }
 }
 //动物枚举
 enum AnimalEnum{   
     DOG("Dog",Dog.class.getName()),   
     CAT("Cat",Cat.class.getName());   
     private final String simpleName;   
     private final String name;   
     AnimalEnum(String simpleName, String name) {      
       this.simpleName = simpleName;      
       this.name = name;   
     }   
     public String getSimpleName() {      
       return simpleName;   
     }   
     public String getName() {      
       return name;   }   
     //获通过动物简易名获取动物全类名   
     public static String getName(String simpleName){      
        for( AnimalEnum animalEnum : AnimalEnum.values()){         
           if(animalEnum.getSimpleName().equalsIgnoreCase(simpleName)){            
              return animalEnum.getName();         
           }      
         }      
         return null;   
      }
 }
