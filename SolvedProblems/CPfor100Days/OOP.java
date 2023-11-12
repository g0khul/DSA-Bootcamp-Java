package CPfor100Days;

class Cosmetics {
    protected String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void apply() {
        System.out.println("Applying " + brand + " " + this.getClass().getSimpleName());
    }
}

public class OOP {
    public static void main(String[] args) {
        B obj = new B();
        obj.add();
    }
}

class A {
    void add() {
        System.out.println("I'm in A");
    }
}

class B extends A {
    @Override
    void add() {
        System.out.println("I'm in B");
    }
}