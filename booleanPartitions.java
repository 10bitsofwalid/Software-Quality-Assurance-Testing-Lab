public class booleanPartitions {
    public static String checkSubscription(boolean isSubscribed){
        if(isSubscribed){
            return "access granted";
        }else{
            return "access denied";
        }
    }

    public static void main(String[] args) {
        System.out.println(checkSubscription(true));
    }
}
