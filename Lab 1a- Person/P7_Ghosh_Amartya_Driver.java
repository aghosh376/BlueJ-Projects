public class P7_Ghosh_Amartya_Driver {
    public static void main(String[] args) {
        
        P7_Ghosh_Amartya_Person joe = new P7_Ghosh_Amartya_Person(14, 0.12, false, "HappySparky", 314, "Green", false);
        
        String answer = joe.getName();
        System.out.println( "!Hola! Me llamo " + answer );
        System.out.println( "Mi color favorito es " + joe.getFavoriteColor());
        System.out.println( "Yo tengo " + joe.ageInDogYears() + "  anos en anos de perro!");
        System.out.println("... fast forward 15 years ...");
        joe.increaseAge(15);
        System.out.println("Ahora, tengo " + joe.ageInDogYears() + "  anos en anos de perro!");
        joe.printSleepState();
        joe.sleep();
        joe.printSleepState();
    }
}
