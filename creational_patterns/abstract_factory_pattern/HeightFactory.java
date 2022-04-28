package creational_patterns.abstract_factory_pattern;



public class HeightFactory extends AbstractFactory{


    @Override
    public PersonInterface getPerson(Class<? extends PersonInterface> cls) {
        return null;
    }

    @Override
    public HeightInterface getHeight(Class<? extends HeightInterface> cls) {
        Object obj = null;
        
        try {
            obj = Class.forName(cls.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (HeightInterface) obj;
    }
}
