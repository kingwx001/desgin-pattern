package creational_patterns.prototype_pattern;

/**
 * 重写Object.clone()方法
 * clone()方法只实现浅拷贝
 * 若成员变量为自定义对象，自定义对象也需要重写clone()方法
 *
 */

public class ProtoType implements Cloneable{

    private String name = "";
    private Integer age; 

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    @Override
    public String toString() {
        return "ProtoType [age=" + age + ", name=" + name + "]";
    }

    public static void main(String[] args) {
        ProtoType protoType = new ProtoType();
        try {
            System.out.println(protoType.equals(protoType.clone()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProtoType other = (ProtoType) obj;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
