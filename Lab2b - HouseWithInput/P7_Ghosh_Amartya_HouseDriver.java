import java.util.Scanner;

public class P7_Ghosh_Amartya_HouseDriver {
    public static void main(String[] args) {
        P7_Ghosh_Amartya_House yum;
        P7_Ghosh_Amartya_House house;
        
        yum = new P7_Ghosh_Amartya_House();
        Scanner input;
        
        input = new Scanner(System.in);
        int doors;
        int windows;
        int bedrooms;
        int price;
        
        System.out.println(yum.toString());
        
        System.out.print("Doors: " + yum.getDoors() + " ");
        System.out.print("Windows: " + yum.getWindows() + " ");
        System.out.print("Bedrooms: " + yum.getBedrooms() + " ");
        System.out.print("Doors: " + yum.getDoors() + " ");
        System.out.println("");
        
        System.out.print("How many doors do you want? ");
        doors = input.nextInt();
        System.out.print("How many windows do you want? ");
        windows = input.nextInt();
        System.out.print("How many bedrooms do you want? ");
        bedrooms = input.nextInt();
        System.out.print("What is your asking price? ");
        price = input.nextInt();
        
        house= new P7_Ghosh_Amartya_House(doors, windows, bedrooms, price);
        System.out.println(house.toString());
        
        if (house.isBelowMarketValue()) {
            System.out.println("The asking price is below market value.");
        } else {
            System.out.println("The asking price is above market value.");
        }
        
        house.addBedrooms(1);
        
        System.out.print("What is your new asking price? ");
        price = input.nextInt();
        house.setPrice(price);
        
        System.out.println("After adding a bedroom:");
        System.out.println(house.toString());
        
        if (house.isBelowMarketValue()) {
            System.out.println("The asking price is below market value.");
        } else {
            System.out.println("The asking price is above market value.");
        }
    }
}
