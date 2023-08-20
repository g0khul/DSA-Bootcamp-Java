package SolvedProblems.Random.Oops;

public class AbstractClass {
    public static void main(String[] args) {
        Honda bike = new Honda("Shine");
        bike.run();
    }
}

abstract class Bike {
    private String brandName;

    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    abstract void run();
}

class Honda extends Bike {

    Honda(String bikeName){
        setBrandName(bikeName);
    }

    @Override
    void run() {
        System.out.println(Honda.class + " " + getBrandName() + " is running");
    }    

}
