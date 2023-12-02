package Random.Oops;

public class Child extends Parent{
    void method(){
        System.out.println("In Child class");
    }
    public static void main(String[] args) {
        Parent obj = new Child();

        obj.method();
        System.out.println(obj.getClass());
    }
}
