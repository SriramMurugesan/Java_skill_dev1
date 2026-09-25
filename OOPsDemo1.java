// public class OOPsDemo{
//         //encapsulation
//         private int id;
//         public String department;  
//         //getters and setters
//             public void setId(int id){
//                 this.id=id;
//             }
//             public int getId(){
//                 return id;
//             } }
//inhertance 
            class Animal{
                void eat(){
                    System.out.println("eating");
                }
            }
            class Dog extends Animal{
                void bark(){
                    System.out.println("barking");
                }
            }
            class Cat extends Animal{
                void meow(){
                    System.out.println("meowing");
                }
            }
            //multilevelinhertance
            class Grandparent{
                void grandparent(){
                    System.out.println("grandparent");
                }
            }
            class Parent extends Grandparent{
                void parent(){
                    System.out.println("parent");
                }
            }
            class Child extends Parent{
                void child(){
                    System.out.println("child");
                }
            }
public class OOPsDemo1{
    public static void main(String[] args) {
        Dog dog=new Dog();
        Cat cat=new Cat();
        dog.eat();
        dog.bark();
        cat.eat();
        cat.meow();
    }
}
//     public static void main(String[] args) {
//         OOPsDemo oop=new OOPsDemo();
//         oop.setId(1);
//         oop.department="computer science";
//         System.out.println(oop.getId());
//         System.out.println(oop.department);
//     }
// }