package creational_patterns.factory_pattern;

public class Main {
    public static void main(String[] args) {
        PersonFactory personFactory =  new PersonFactory();
        Person malePerson =  personFactory.getPerson(Male.class);
        Person femalePerson = personFactory.getPerson(Female.class);
        malePerson.call();
        femalePerson.call();
    }
}
