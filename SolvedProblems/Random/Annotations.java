import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

@FunctionalInterface
interface Abc {
    public void print(); // It'll give me error if I mistakenly declare another method in this
                         // FunctionalInterface
}

class AClass {

    @Deprecated // Telling others that this method exist but deprecated
    public void show() {
        System.out.println("in A");
    }
}

class BClass extends AClass {

    @Override // Gives error if I'm not overriding
    @SuppressWarnings("unchecked") // Supressing the warning of myList ArrayList
    public void show() {
        System.out.println("in B");
        ArrayList myList = new ArrayList(); // Gives warning because type is not mentioned
        myList.add(5);
        myList.add(6);
        myList.add("String value");
    }
}

// Creating my own Annotation
@Inherited // If any class NokiaZSeries extends the NokiaPhone class then we can say the
           // annotation is also going to be used there so we specify @Inherited annotation
           // there
@Documented // Document the created annotation when we document the software
// Mentioning the meta annotations
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface SmartPhone {
    /*
     * Annotation with no values = Marker annotation
     * Annotation with 1 value = Single value annoation
     * Annotation with multiple values = Multi value annotation
     */
    
    String os() default "Android";

    double version() default 1.0;
}

@SmartPhone(os = "Android", version = 2.0)
class NokiaPhone {
    int size;
    String model;

    public NokiaPhone(String model, int size) {
        this.size = size;
        this.model = model;
    }
}

public class Annotations {
    public static void main(String[] args) {
        /*
         * Using annotation to understand code better and find mistakes in the runtime
         * itself
         */

        AClass AObj = new AClass();
        AObj.show(); // This line now will show that the show() is deprecated

        BClass BObj = new BClass();
        BObj.show();

        NokiaPhone obj = new NokiaPhone("Fire", 5);

        Class c = obj.getClass();
        Annotation an = c.getAnnotation(SmartPhone.class);
        SmartPhone s = (SmartPhone) an;
        System.out.println(s.os());

    }
}
