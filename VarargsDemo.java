public class VarargsDemo{
    void add(int...a){
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        System.out.println("Sum is : "+sum);
    }
    public static void main(String[] args){
        VarargsDemo demo=new VarargsDemo();
        demo.add(1,2,3,4,5);
        demo.add(1,2,3,4,5,6,7,8,9,10);
    }
}