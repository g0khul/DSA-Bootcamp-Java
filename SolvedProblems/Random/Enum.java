package SolvedProblems.Random;

enum DaysOfTheWeek{
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);              // Semicolon is optional

    final int day;
    DaysOfTheWeek(int day){
        this.day = day;
    }

}

public class Enum {
    public static void main(String[] args) {
        DaysOfTheWeek myday[] = DaysOfTheWeek.values(); // Just fetching all the constants in an array

        for(DaysOfTheWeek MyDay : DaysOfTheWeek.values())
            System.out.println(MyDay);                    // Printing all the constants

        // DaysOfTheWeek.FRIDAY = 3;                    // Can't change the day because the day is created as final

        if(DaysOfTheWeek.FRIDAY == DaysOfTheWeek.MONDAY)
            System.out.println("Day matched");
        else
            System.out.println("Day not matched");

    }    
}

// The enum used here is similar to
// class DaysOfTheWeek{
//     static final DaysOfTheWeek MONDAY = new DaysOfTheWeek();
//     static final DaysOfTheWeek TUESDAY = new DaysOfTheWeek();
//     static final DaysOfTheWeek WEDNESDAY = new DaysOfTheWeek();
//     static final DaysOfTheWeek THURSDAY = new DaysOfTheWeek();
//     static final DaysOfTheWeek FRIDAY = new DaysOfTheWeek();
//     static final DaysOfTheWeek SATURDAY = new DaysOfTheWeek();
//     static final DaysOfTheWeek SUNDAY = new DaysOfTheWeek();
// }