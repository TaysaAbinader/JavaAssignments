package Chapter_2_1;
import Chapter_2_1.CoffeeMaker;


public class CoffeeMakerDriver {

    public CoffeeMakerDriver() {}

    public static void main(String[] args) {

        CoffeeMaker nespresso = new CoffeeMaker();

        nespresso.switchOnOff();
        if (nespresso.isOn()){
            System.out.println("Coffee maker is on");
        } else {
            System.out.println("Coffee maker is off");
        }

        nespresso.setType(CoffeeMaker.CoffeeType.ESPRESSO);
        CoffeeMaker.CoffeeType type = nespresso.getCoffeeType();
        if (type == CoffeeMaker.CoffeeType.ESPRESSO) {
            System.out.println("Coffee type is espresso");
        } else {
            System.out.println("Coffee type is normal");
        }

        nespresso.setAmount(50);
        int amount = nespresso.getCoffeeAmount();
        System.out.println("Coffee amount is " + amount + " ml");

        nespresso.switchOnOff();
        if (nespresso.isOn()){
            System.out.println("Coffee maker is on");
        } else {
            System.out.println("Coffee maker is off");
        }
    }

}
