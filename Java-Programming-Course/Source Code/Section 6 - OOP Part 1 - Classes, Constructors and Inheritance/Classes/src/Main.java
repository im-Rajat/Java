public class Main {

    public static void main(String[] args)
    {
        SimpleCalculator simpleCalculator = new SimpleCalculator();
        simpleCalculator.setFirstNumber(20.0);
        simpleCalculator.setSecondNumber(50.0);
        System.out.println(simpleCalculator.getFirstNumber());
        System.out.println(simpleCalculator.getSecondNumber());
        System.out.println(simpleCalculator.getAdditionResult());
        System.out.println(simpleCalculator.getSubtractionResult());
        System.out.println(simpleCalculator.getMultiplicationResult());
        System.out.println(simpleCalculator.getDivisionResult());

        System.out.println();

        Person person = new Person();
        person.setFirstName("Rajat");
        person.setLastName("Kumar");
        person.setAge(22);
        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());
        System.out.println(person.getAge());
        System.out.println(person.getFullName());
        System.out.println(person.isTeen());

    }

}
