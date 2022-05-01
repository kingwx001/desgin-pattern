package creational_patterns.builder_pattern;

public class Product {
    private String A;
    private String B;
    private String C;

    public Product(){

    }
    
    public String getA() {
        return A;
    }
    public void setA(String a) {
        A = a;
    }
    public String getB() {
        return B;
    }
    public void setB(String b) {
        B = b;
    }
    public String getC() {
        return C;
    }
    public void setC(String c) {
        this.C = c;
    }

    @Override
    public String toString() {
        return "Product [A=" + A + ", B=" + B + ", C=" + C + "]";
    }

}
