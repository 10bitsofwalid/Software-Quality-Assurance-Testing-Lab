public class openAndClosedInterval {

    // closed interval - [10 - 20] includes 10 & 20
    //open interval - (10 - 20) excludes 10 & 20
    
    public static boolean isClosedRanged(int num){
        return num >= 10 && num <= 20;
    }

    public static boolean isOpenRange(int num){
        return num > 10 && num < 20;
    }

    public static void main(String[] args) {
        System.out.println(isClosedRanged(10));
        System.out.println(isOpenRange(10));
    }

}
