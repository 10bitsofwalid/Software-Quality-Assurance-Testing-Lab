public class labClass1 {
    void showmessage(String message) {
        System.out.println(message);
    }

    public double calcAverage(int a, int b) {
        return (a + b) / 2.0;
    }

    public static void main(String[] args) {
        
        labClass1 newMessage = new labClass1();
        newMessage.showmessage("hello by java");


        labClass1 getAvg = new labClass1();
        double average = getAvg.calcAverage(10, 20);
        System.out.println("average: " + average);
    }
}
