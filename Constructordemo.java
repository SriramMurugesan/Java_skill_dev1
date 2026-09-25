public class Constructordemo{
    int x,y;
    Constructordemo(int x,int y){
        this.x=x;
        this.y=y;
    }
    void add(){
        System.out.println("Sum is : "+(this.x+this.y));
    }
    public static void main(String[] args){
        Constructordemo demo=new Constructordemo(10,20);
        Constructordemo demo2=new Constructordemo(30,40);
        System.out.println(demo.x+" "+demo.y);
        System.out.println(demo2.x+" "+demo2.y);
    }
}