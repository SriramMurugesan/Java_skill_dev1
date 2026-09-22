public class ControlStructures{
    public static void main(String[] args){
    int a=10;
    int b=20;
    if(a>b){
        System.out.println("a is greater");
    }
    else{
        System.out.println("b is greater");
    }
    char Grade;
    int score=90;
    
    if(score>=90){
        Grade='A';
    }
    else if(score>=80){
        Grade='B';
    }
    else if(score>=70){
        Grade='C';
    }
    else{
        Grade='F';
    }
    int choice=2;
    switch(choice){
        case 1:
            System.out.println("one");
            break;
        case 2:
            System.out.println("two");
            break;
        case 3:
            System.out.println("three");
            break;
        default:
            System.out.println("other");
            break;
    }
    for (int i=1;i<=5;i++){
        System.out.println("hello");
    }
    for (int i=1;i<=10;i++){
        if(i==5){
            continue;
        }
        System.out.println(i);
    }
    for (int i=1;i<=10;i++){
        if(i==5){
            break;
        }
        System.out.println(i);
    }
    int i=1;
    while(i<=10){
        System.out.println(i);
        i++;
    }
    int j=1;
    do{
        System.out.println(j);
        j++;
    }
    while(j<=10);
    }
}