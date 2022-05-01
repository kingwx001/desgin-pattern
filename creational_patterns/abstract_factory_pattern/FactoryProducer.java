package creational_patterns.abstract_factory_pattern;


public class FactoryProducer {

    public static AbstractFactory getFactory(String factoryType){
       
        AbstractFactory obj = null;
        try {
            
            obj = (AbstractFactory) Class.forName(FactoryProducer.class.getPackage().getName() + "." + factoryType + "Factory").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args) {
        AbstractFactory personFactory = FactoryProducer.getFactory("Person");
        AbstractFactory heightFactory = FactoryProducer.getFactory("Height");
        PersonInterface female = personFactory.getPerson(Female.class);
        PersonInterface male = personFactory.getPerson(Male.class);
        HeightInterface short_ = heightFactory.getHeight(Short.class);
        HeightInterface tall = heightFactory.getHeight(Tall.class);
        female.call();
        male.call();
        tall.show();
        short_.show();
    }
}
