package creational_patterns.factory_pattern;


/**
 * if逻辑判断，静态生成对象，缺点是工厂添加新类时每次都要加if逻辑
 */

/* 
public class PersonFactory {
    public Person getPerson(String gender){
        if("female".equalsIgnoreCase(gender)){
            return new Female();
        }else if("male".equalsIgnoreCase(gender)){
            return new Male();
        }
        return null;
    }
} */


 /**
  * 传入类名，使用反射动态生成对象
 * 
  */

public class PersonFactory{

    
    public PersonInterface getPerson(Class<? extends PersonInterface> cls) {
        PersonInterface person = null;
        try {
            person = (PersonInterface) Class.forName(cls.getName()).newInstance();
            System.out.println(cls.getName());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }

    
    


    
}

