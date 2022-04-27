package creational_patterns.factory_pattern;


/**
 * if逻辑判断，静态生成对象，缺点是工厂添加新类时每次都要加if逻辑
 */

/* 
public class PersonFactory {
    public Person getPerson(String gender){
        if("female".equals(gender)){
            return new Female();
        }else if("male".equals(gender)){
            return new Male();
        }
        return null;
    }
}
 */

 /**
  * 传入类名，使用反射动态生成对象
  */

public class PersonFactory {
    public Person getPerson(Class<? extends Person> clazz){
        Person person = null;
        try {
            person = (Person)Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return (Person) person;
    }
}

