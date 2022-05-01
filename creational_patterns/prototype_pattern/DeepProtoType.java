package creational_patterns.prototype_pattern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepProtoType implements Serializable,Cloneable {

    private final static long serialVersionUID = 1;
    private Integer id;
    private Sheep sheep;
    
    public DeepProtoType() {
        
    }

    public DeepProtoType(Integer id, Sheep sheep) {
        this.id = id;
        this.sheep = sheep;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sheep getSheep() {
        return sheep;
    }
    
    public void setSheep(Sheep sheep) {
        this.sheep = sheep;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((sheep == null) ? 0 : sheep.hashCode());
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
        DeepProtoType other = (DeepProtoType) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (sheep == null) {
            if (other.sheep != null)
                return false;
        } else if (!sheep.equals(other.sheep))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DeepProtoType [id=" + id + ", sheep=" + sheep + "]";
    }

    @Override
    protected DeepProtoType clone() throws CloneNotSupportedException {
        ByteArrayInputStream bis = null;
        ByteArrayOutputStream bos = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        //序列化
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return (DeepProtoType) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return (DeepProtoType) super.clone();
    }

    
}

/**
 * 类Sheep也要加序列号
 */
class Sheep implements Serializable{
    private final static long serialVersionUID = 2;
    private String name;
    private Integer age;
    public Sheep() {

    }
    public Sheep(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
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
        Sheep other = (Sheep) obj;
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
    @Override
    public String toString() {
        return "Sheep [age=" + age + ", name=" + name + "]";
    }
}
class Test{
    public static void main(String[] args) {
        try {
            DeepProtoType deepProtoType1 = new DeepProtoType(1,new Sheep("sheepA",10));
            DeepProtoType deepProtoType2 = deepProtoType1.clone();
            System.out.println(deepProtoType1);
            System.out.println(deepProtoType2);
            System.out.println(deepProtoType1 == deepProtoType2);
            System.out.println(deepProtoType1.equals(deepProtoType2));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}