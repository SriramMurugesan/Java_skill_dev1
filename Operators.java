public class Operators{
    public static void main(String[] args){
        int a=1;
        int b=2;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);
        //relational operators
        System.out.println(a>b);
        System.out.println(a<b);
        System.out.println(a==b);
        System.out.println(a!=b);
        System.out.println(a>=b);
        System.out.println(a<=b);
        //ternary 
        System.out.println(a>b ? "a is greater" : "b is greater");
        // bitwise operators
        int c=1;
        int d=0;
        System.out.println(c&d);
        System.out.println(c|d);
        System.out.println(~c);
        //logical operators
        boolean e=true;
        boolean f=false;
        System.out.println(e&&f);
        System.out.println(e||f);
        System.out.println(!e);
        //assignment operators
        a+=b;
        a-=b;
        a*=b;
        a/=b;
        a%=b;
        System.out.println(a);
        System.out.println(b);
        //increment and decrement operators
        System.out.println(++a);
        System.out.println(--a);
      
        
        
    }
}