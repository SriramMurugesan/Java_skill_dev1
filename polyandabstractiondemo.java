public class polyandabstractiondemo{
    public static void main(String[] args) {
            Dog dog=new Dog();
            dog.eat();
    }
}
//abstract class
abstract class Animal{
    void sleep(){
        System.out.println("sleeping");
    }
    abstract void eat();
}
class Dog extends Animal{
    void eat(){
        System.out.println("eating");
    }
}
//interface
interface Vehicle{
    void start();
    void stop();
}
interface ElectricVehicle{
    void charge();
}
class Bike implements Vehicle{
    public void start(){
        System.out.println("bike started");
    }
    public void stop(){
        System.out.println("bike stopped");
    }
}
class ElectricBike implements Vehicle,ElectricVehicle{
    public void start(){
        System.out.println("electric bike started");
    }
    public void stop(){
        System.out.println("electric bike stopped");
    }
    public void charge(){
        System.out.println("electric bike charging");
    }
}

  
    