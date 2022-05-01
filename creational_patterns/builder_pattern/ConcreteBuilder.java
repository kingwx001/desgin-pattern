package creational_patterns.builder_pattern;

public class ConcreteBuilder extends Builder{

    private Product product;

    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    public void buildA() {
        product.setA("a");
    }

    @Override
    public void buildB() {
        product.setB("b"); 
    }

    @Override
    public void buildC() {
        product.setC("c");
    }

    @Override
    public Product getProduct() {
        return product;
    }
    
}
