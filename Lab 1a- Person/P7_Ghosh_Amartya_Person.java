public class P7_Ghosh_Amartya_Person {
    int myAge;          // Age in years
    double myHeight;    // Height in meters
    boolean isFemale;   // True if female, false if male
    String myName;// Person's name
    int myFavoriteNumber;
    String myFavoriteColor;
    boolean isSleeping;
    
    // Default constructor - no parameters ()
    public P7_Ghosh_Amartya_Person() {
        myAge = 17;
        myHeight = 1.53;
        isFemale = false;
        myName = "Joe";
        myFavoriteNumber = 7;
        myFavoriteColor = "Green";
        isSleeping = false;
    }
    // parameterized constructor - with parameters (a, b, c, ...)
    public P7_Ghosh_Amartya_Person(int age, double height, boolean female, String name, 
    int favNum,String favColor, boolean asleep) {
        myAge = age;
        myHeight = height;
        isFemale = female;
        myName = name;
        myFavoriteNumber = favNum;
        myFavoriteColor = favColor;
        isSleeping = asleep;
    }

    public double heightToInches() {
        double answer = myHeight * 39.97;
        return answer;
    }
    
    public String getName() {
        return myName;
    }
    
    public void printInfo() {
        String response;
        response = "Hello, my name is " + myName;
        response = response + " and I'm " + myAge + " years old!";
        System.out.println(response);
    }
    
    public void increaseAge(int amount) {
        myAge = myAge + amount;
    }
    
    public int ageInDogYears () {
        int dogYears = myAge * 7;
        return dogYears;
    }
    // Returns this Person's favorite color
    public String getFavoriteColor() {
        return myFavoriteColor;
    }
    // Prints this Person's name, age, and favorite color
    public void printInfo2() {
        System.out.println(myName);
        System.out.println(myAge);
        System.out.println(myFavoriteColor);
    }
    // Changes the state of this P7_Ghosh_Amartya_Person to sleeping
    public void sleep() {
        isSleeping = true;
    }
    // Changes the state of this P7_Ghosh_Amartya_Person to awake
    public void wakeUp() {
        isSleeping = false;
    }
    // Prints the sleep state of this P7_Ghosh_Amartya_Person
    public void printSleepState() {
        if (isSleeping == true)
            System.out.println("I am sleeping....zzzz....");
        else
            System.out.println("I am awake!");
    }

}
