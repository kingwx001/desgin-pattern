package creational_patterns.builder_pattern;

public class Director {

    public Product create(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        return builder.getProduct();
    }


}
