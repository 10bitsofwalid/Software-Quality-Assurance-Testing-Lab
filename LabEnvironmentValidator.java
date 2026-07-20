public class LabEnvironmentValidator {

    public static boolean isValidTemp(int temp){
        return temp >= 10 && temp <= 50;
    }

    public static boolean isValidHumidity(int humidity){
        return humidity >= 0 && humidity <= 100;
    }

    public static boolean isValidEnvironment(int temp, int humidity){
        return isValidTemp(temp) && isValidHumidity(humidity);
    }

    public static void main(String[] args) {
        
        //bvc
        System.out.println("temperature 10:" +isValidTemp(10));
        System.out.println("temperature 11: " +isValidTemp(11));
        System.out.println("temperature 49: " +isValidTemp(49));
        System.out.println("temperature 50: " +isValidTemp(50));

        System.out.println("humidity 0: " +isValidHumidity(0));
        System.out.println("humidity 1: " +isValidHumidity(1));
        System.out.println("humidity 99: " +isValidHumidity(99));
        System.out.println("humidity 100: " +isValidHumidity(100));

        //robustness 
        System.out.println("temperature 9: " +isValidTemp(9));
        System.out.println("temperature 51: " +isValidTemp(51));
        System.out.println("humidity -1: " +isValidHumidity(-1));
        System.out.println("humidity 101: " +isValidHumidity(101));

        //worst case
        int [] envTemp = {1, 11, 49, 50};
        int [] envHumidity = {0, 1, 99, 100};

        for(int temperature : envTemp){
            for(int humidity : envHumidity){
                System.out.println("temperature: " +isValidTemp(temperature)+ "humidity:  "+isValidHumidity(humidity)+ " " +isValidEnvironment(temperature, humidity));
            }
        }
    }
}
