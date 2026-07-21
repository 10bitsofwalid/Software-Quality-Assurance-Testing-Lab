import java.util.Scanner;

public class atmVerification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int target = 9500;
        int validAttempts = 0;
        boolean isSuccess = false;

        while(validAttempts < 3){
            System.out.println("Enter ATM Verification Code (4 characters): ");
            String input = sc.nextLine();

            if(input.length() != 4){
                System.out.println("Invalid Verification Code");
                continue;
            }

            validAttempts++;
            char char1 = input.charAt(0);
            char char2 = input.charAt(1);
            char char3 = input.charAt(2);
            char char4 = input.charAt(3);
            int verificationNumber = ((int) char1 + (int) char4) * (int) char2 - (int) char3;

            if(verificationNumber == target){
                System.out.println("Approved");
                isSuccess = true;
                break;
            }else{
                System.out.println("Invalid Code");
            }
        }

        if(!isSuccess){
            System.out.println("Card Blocked");
        }

        sc.close();
    }
}