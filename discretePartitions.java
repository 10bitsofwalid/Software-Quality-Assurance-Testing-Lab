public class discretePartitions {
    public static boolean isValidGender(String gender){
        switch (gender) {
            case "Male":
            case "Female":
            case "Others":
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidGender("Male"));
        System.out.println("Female");
        System.out.println("prefer not to say");
    }
}
