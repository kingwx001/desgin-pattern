package creational_patterns.abstract_factory_pattern;

/**
 * 抽象工厂
 */
public abstract class AbstractFactory{
    public abstract PersonInterface getPerson(Class<? extends PersonInterface> cls);
    
    public abstract HeightInterface getHeight(Class<? extends HeightInterface> cls);

     
}