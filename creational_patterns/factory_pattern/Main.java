package creational_patterns.factory_pattern;

public class Main {
    public static void main(String[] args) {
        PersonFactory personFactory =  new PersonFactory();
        PersonInterface malePerson =  personFactory.getPerson(Male.class);
        PersonInterface femalePerson = personFactory.getPerson(Female.class);
        malePerson.call();
        femalePerson.call();
    }
}
