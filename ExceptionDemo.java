import java.util.InputMismatchException;
import java.util.Scanner;

class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String msg){
        super(msg);
    }
}
public class ExceptionDemo {
    static int withdraw (int balance, int withdrawAmount) throws InsufficientBalanceException{
        if(balance<withdrawAmount){
            throw new InsufficientBalanceException("insufficient balance");
        }
        return balance-withdrawAmount;
    }
    public static void main(String[] args) {
        int withdrawAmount = 2000;
        int balance=10000;
        try{
            balance=withdraw(balance,withdrawAmount);
            System.out.println("balance:"+balance);
        }catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("transaction completed");
        }
    }
    
    }
//   public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // try {
    //   System.out.println("enter a: ");
    //   int a = sc.nextInt();
    //   System.out.println("enter b: ");
    //   int b = sc.nextInt();
    //   int c = a/b;
    //   System.out.println(c);
    // } catch (InputMismatchException e) {
    //   System.out.println("enter valid number");
    // } catch (ArithmeticException e) {
    //   System.out.println(e.getMessage());
    // } catch (Exception e) {
    //   System.out.println(e.getMessage());
    // } finally {
    //   sc.close();
    // } 
    //throw and throws
//     checkAge(10);
//   }
//   static void checkAge(int age) throws ArithmeticException{
//     if(age<18){
//       throw new ArithmeticException("age is less than 18");
//     }
//     System.out.println("age is greater than or equal to 18");

    //custom exception
    
//   }
// }
