public class ObjectCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        A obj = new A();
        obj.i = 5;
        obj.j = 6;
        A obj1 = (A) obj.clone();
        System.out.println(obj1);
    }
}

class A implements Cloneable {

    int i, j;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}