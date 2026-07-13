package sqatlabpractice;

// Question 04: Create a void method named displayMarks() that traverses the array and prints all the marks.

public class printMarks {

    public static void getMarks(double[] marks){
        for(double mark : marks){
            System.out.println(mark);
        }
    }

    public static void main(String[] args) {
        double[] marks = {2, 3, 5.5};
        getMarks(marks);
    }
}
