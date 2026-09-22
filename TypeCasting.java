public class TypeCasting{
    public static void main(String[] args){
        //Narrowing conversion
        int a=10;
        double b=a;
        System.out.println(b);
        //widening conversion
        double c=10.5;
        int d=(int)c;
        System.out.println(d);
        //implicit type casting
        int x=10;
        x=(int)b;
        System.out.println(x);
        //explicit type casting
        int y = 5;
        int z = 10;
        System.out.println("x/z"+((float)x/z));
        
        
    }
}
