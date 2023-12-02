package Random;

interface XYZ {
    public void show();
}

// Method 1
class B implements XYZ {
    public void show(){
        System.out.println("Hello");
    }
}

public class LambdaExpression {
    public static void main(String[] args) {
        
        // Method 1 : Long way method
        XYZ Method1Obj = new B();
        Method1Obj.show();

        // Method 2 : Adding a inner anonymous class instead of the class B
        XYZ Method2Obj = new XYZ(){
            public void show(){
                System.out.println("Hello");
            }
        };
        Method2Obj.show();

        // Method 3 : Removing Boiler codes from method 2 and Lambda expression
        XYZ Method3Obj = () -> System.out.println("Hello");
        Method3Obj.show();

    }
}
