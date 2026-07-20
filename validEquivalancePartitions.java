public class validEquivalancePartitions {

    public static boolean isValidAge(int age){
        return age >= 18 && age <= 60;
    }

    public static void main(String[] args) {
        System.out.println(isValidAge(25));
    }

}
