public class MethodOverloading{
    void add(int a,int b){
        System.out.println("Sum is : "+(a+b));
    }
    void add(int a,int b,int c){
        System.out.println("Sum is : "+(a+b+c));
    }
    void add(double a,double b){
        System.out.println("Sum is : "+(a+b));
    }
    public static void main(String[] args){
        MethodOverloading demo=new MethodOverloading();
        demo.add(1,2);
        demo.add(1,2,3);
        demo.add(1.5,2.5);
    }
}