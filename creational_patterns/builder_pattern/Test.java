package creational_patterns.builder_pattern;

public class Test {
    public static void main(String[] args) {
        Director director = new Director();
        Product product =  director.create(new ConcreteBuilder());

        System.out.println(product);
    }
}
