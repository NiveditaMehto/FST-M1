package activities;

public class Car {

     String color;
     String transmission;
     Integer make ,tyres ,door;

    Car( Integer tyres , Integer door ,Integer make , String color , String transmission){
        this.tyres=tyres;
        this.door=door;
        this.make =make;
        this.color=color;
        this.transmission=transmission;
    }

    public void displayCharacteristics(){
        System.out.println( "1.Color-" + color + "\n" + "2.transmission-" + transmission + "\n"+ "3.Make-" + make + "\n"+ "4.tyres-" + tyres + "\n" + "5.door-" + door);
    }
    public void accelerate(){
System.out.println("Cra is moving forward");
    }
    public void brake(){
System.out.println("Car has stopped");
    }
}
