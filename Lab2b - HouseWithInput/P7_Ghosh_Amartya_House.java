//Amartya Raybo Ghosh 
//Intro Java
//Lab2b - HouseWithInput
//Period 7
//20 Jan 2022
public class P7_Ghosh_Amartya_House {
    int numDoors;
    int numWindows;
    int numBedrooms;
    double askingPrice;
    
    public P7_Ghosh_Amartya_House() {
        numDoors = 10;
        numWindows = 8;
        numBedrooms = 3;
        askingPrice = 435000;
    }
    
    public P7_Ghosh_Amartya_House(int doors, int windows, int bedrooms, double price) {
        numDoors = doors;
        numWindows = windows;
        numBedrooms = bedrooms;
        askingPrice = price;
    }
    
    public int getDoors() {
        return this.numDoors;
    }
    public int getWindows() {
        return this.numWindows;
    }
    public int getBedrooms() {
        return this.numBedrooms;
    }
    public double getPrice() {
        return this.askingPrice;
    }
    
    public void setPrice(double price) {
        askingPrice = price;
    }
    
        /** Calculate and return the market value for this house
        Market value is $300,000 plus $55,000 per bedroom
        plus $3,000 per window */
    public double calculateMarketValue() {
        double marketValue;
        marketValue = 300000;
        marketValue += 55000*this.numBedrooms;
        marketValue += 3000*this.numWindows;
        return marketValue;
    }
    // Adds more windows to the house
    public void addWindows(int num) {
        numWindows += num;
    }
    // Adds more doors to the house
    public void addDoors(int num) {
        numDoors += num;
    }
    /** Adds more bedrooms to the house
        Each new bedroom adds one new door and one new window */
    public void addBedrooms(int num) {
        numBedrooms += num;
        numWindows += num;
        numDoors += num;
    }
    /** returns true if the asking price is less than the
        calculated market value and false otherwise */
    public boolean isBelowMarketValue() {
        if (this.calculateMarketValue() < this.askingPrice) {
            return false;
        }
        return true;
    }
    /** returns a String specifying this house's
         - number of bedrooms
         - market value
         - asking price */
    public String toString() {
        String desc = ("A " + numBedrooms + " bedroom house with a market value of $" + this.calculateMarketValue() + " is for sale with asking price $" + askingPrice);
        return desc;
    }
}