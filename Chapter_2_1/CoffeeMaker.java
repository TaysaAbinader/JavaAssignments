package Chapter_2_1;

public class CoffeeMaker {
    public enum CoffeeType { NORMAL, ESPRESSO };
    private boolean isOn = false;
    private CoffeeType coffeeType = CoffeeType.NORMAL;
    private int coffeeAmount = 10;

    public CoffeeMaker(){}

    //getter
    public boolean isOn(){
        return this.isOn;
    }

    //setter
    public void switchOnOff(){
        this.isOn = !this.isOn;
    }

    //getter
    public CoffeeType getCoffeeType(){
        return this.coffeeType;
    }

    //setter
    public void setType(CoffeeType coffeeType){
        if (this.isOn){
            this.coffeeType = coffeeType;
        }
    }

    //getter
    public int getCoffeeAmount(){
        return this.coffeeAmount;
    }

    //setter
    public void setAmount(int coffeeAmount){
        if (this.isOn){
            this.coffeeAmount = Math.max(Math.min(coffeeAmount, 80), 10);
        }
    }
}
