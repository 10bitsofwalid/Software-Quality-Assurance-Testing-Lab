package sqatlabpractice;

import java.util.Scanner;

// Question 05

public class marksPortal {

    public static void callWelcome(){
        System.out.println("welcome");
    }

    public static void getMarks(double[] marks){
        for(double mark : marks){
            System.out.println(mark);
        }
    }

    public static double getAvg(double[] marks){
        double sum = 0;

        for(double mark : marks){
            sum += mark;
        }

        return (double) sum / marks.length;
    }

    public static void main(String[] args) {
        marksPortal welcome = new marksPortal();
        welcome.callWelcome();

        double[] marks = {2, 3, 5.5};
        getMarks(marks);

        double average = getAvg(marks);
        System.out.println("\nAverage: "+average);

        if(average >= 80){
            System.out.println("Grade: A");
        }else if(average >= 60){
            System.out.println("Grade: B");
        }else{
            System.out.println("Grade: C");
        }

        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                getMarks(marks);
                break;
            case 2:
                System.out.println(average);
                break;
            case 3:
                System.out.println("Exit");
                break;
            default:
                break;
        }

    sc.close();

    }
}
