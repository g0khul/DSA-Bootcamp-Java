import java.util.*;

class Variables {
    static int choice = 5;
    static ArrayList<String> numberList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
}

class ContactList extends Variables {

    protected boolean isContactsEmpty(ArrayList<String> numberList) {
        return numberList.isEmpty();
    }

    protected boolean isNumberValid(String number) {
        // Just checking if the number starts from 6 7 8 or 9
        return ((number.charAt(0) >= 6 && number.charAt(0) <= 9) && (number.length() == 9)) ? true : false;
    }

    protected boolean isNumberExist(String number) {
        return numberList.contains(number);
    }

    protected void showContacts() {
        if (isContactsEmpty(numberList))
            System.out.println("Contact list is empty");
        else
            System.out.println(numberList);
    }

    protected void addNumber(String number) {
        numberList.add(number);
        System.out.println("Number " + number + " added successfully");
    }

    protected ArrayList<String> deleteContact(int position) {
        numberList.remove(position + 1);
        return numberList;
    }

    protected void modifyContactList() {
        System.out.println("modifyContactList works fine");
        choice = 5;
        while (choice != 0) {
            switch (choice) {
                case 1 -> {
                    showContacts();
                    choice = 5;
                }
                case 2 -> {
                    System.out.println("Enter a number to be stored in the contact list\n");
                    String number = sc.next();
                    if (isNumberValid(number)) {
                        addNumber(number);
                        choice = 5;
                    } else {
                        System.out.println("The given number is not valid.\nPlease enter again...\n");
                        choice = 5;
                    }
                }
                case 3 -> {
                    System.out.println("Enter a number:\n");
                    String number = sc.nextLine();
                    if (isNumberExist(number)) {
                        System.out.println("The given number " + number + " exist");
                        addNumber(number);
                        choice = 5;
                    } else {
                        System.out.println("The given number " + number + " does not exist.\nTry again");
                        choice = 5;
                    }
                }
                case 4 -> {
                    showContacts();
                    System.out.println("Enter the position of the number in the list to be modified\n");
                    int numberPosition = sc.nextInt();
                    System.out.println("Enter the new number to be updated\n");
                    String newNumber = sc.next();
                    numberList.add(numberPosition, newNumber);
                    System.out.println("New number updated successfullly\nThe updated list is" + numberList);
                    choice = 5;
                }
                case 5 -> {
                    System.out.println("Enter the number to choose a option\n");
                    System.out.println("1. Show contact list");
                    System.out.println("2. Add a number");
                    System.out.println("3. Delete a number");
                    System.out.println("4. Modify a number");
                    choice = sc.nextInt();
                }
                default -> {
                    System.out.println("********Invalid input********");
                    System.out.println("Please enter again");
                    choice = 5;
                }
            }
        }
    }
}

public class Payment extends Variables {

    public static void sendMoney() {
        System.out.println("sendMoney works fine");
        choice = 5;
    }

    public static void requestMoney() {
        System.out.println("requestMoney works fine");
        choice = 5;
    }

    public static void main(String[] args) {

        ContactList conList = new ContactList();
        while (choice != 0) {
            switch (choice) {
                case 1 -> conList.modifyContactList();
                case 2 -> sendMoney();
                case 3 -> requestMoney();
                case 4 -> {
                    System.out.println("**********EXITING**********");
                    choice = 0;
                }
                case 5 -> {
                    System.out.println("Enter the number to choose a option\n");
                    System.out.println("1. Add, delete or modify contact list using mobile number");
                    System.out.println("2. Send some money");
                    System.out.println("3. Request some money");
                    System.out.println("4. Exit");
                    choice = sc.nextInt();
                }
                default -> {
                    System.out.println("********Invalid input********");
                    System.out.println("Please enter again");
                    choice = 5;
                }
            }
        }
    }
}