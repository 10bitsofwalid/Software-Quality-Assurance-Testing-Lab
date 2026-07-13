package sqatlabpractice;

// Question 02: Create a non-void method named calculateAverage() that takes three integer marks as parameters and returns their average.


public class calcAverage {

    public static double getAvg(double a, double b, double c){
    return (a+b+c)/3;
}

    public static void main(String[] args) {
        double average = getAvg(2, 4, 5.5);
        System.out.println("average: " +average);
    }
}
