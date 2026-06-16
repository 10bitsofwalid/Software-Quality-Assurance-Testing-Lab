public class labClass2 {
    static final int TEMP_MIN  = -10;
    static final int TEMP_MAX  =  50;
    static final int HUM_MIN   =   0;
    static final int HUM_MAX   = 100;

    // ── Validation helpers ───────────────────────────────────────────────────────

    /** Returns true when temperature is within the valid range. */
    static boolean isValidTemperature(double temp) {
        return temp >= TEMP_MIN && temp <= TEMP_MAX;
    }

    /** Returns true when humidity is within the valid range. */
    static boolean isValidHumidity(double humidity) {
        return humidity >= HUM_MIN && humidity <= HUM_MAX;
    }

    /** Validates both parameters together. */
    static String validate(double temp, double humidity) {
        boolean tempOk = isValidTemperature(temp);
        boolean humOk  = isValidHumidity(humidity);

        if (tempOk && humOk) {
            return "VALID   -> Temp=" + temp + "°C  |  Humidity=" + humidity + "%";
        }
        StringBuilder msg = new StringBuilder("INVALID -> Temp=" + temp + "°C  |  Humidity=" + humidity + "%  |  Reason: ");
        if (!tempOk)  msg.append("Temperature out of range [").append(TEMP_MIN).append(",").append(TEMP_MAX).append("] ");
        if (!humOk)   msg.append("Humidity out of range [").append(HUM_MIN).append(",").append(HUM_MAX).append("]");
        return msg.toString();
    }

    static void boundaryValueCheck() {
        System.out.println(" 1. BOUNDARY VALUE CHECK (BVC)");

        double nominalTemp = (TEMP_MIN + TEMP_MAX) / 2.0;
        double nominalHum  = (HUM_MIN  + HUM_MAX)  / 2.0;

        System.out.println("Temperature boundary (Humidity fixed at " + nominalHum + "%)");
        double[] tempBVA = { TEMP_MIN, TEMP_MIN + 1, nominalTemp, TEMP_MAX - 1, TEMP_MAX };
        for (double t : tempBVA) {
            System.out.println("  " + validate(t, nominalHum));
        }

        System.out.println("Humidity boundary (Temperature fixed at " + nominalTemp + "°C)");
        double[] humBVA = { HUM_MIN, HUM_MIN + 1, nominalHum, HUM_MAX - 1, HUM_MAX };
        for (double h : humBVA) {
            System.out.println("  " + validate(nominalTemp, h));
        }
    }

    static void robustnessTesting() {
        System.out.println(" 2. ROBUSTNESS TESTING");

        double nominalTemp = (TEMP_MIN + TEMP_MAX) / 2.0;
        double nominalHum  = (HUM_MIN  + HUM_MAX)  / 2.0;

        System.out.println("Temperature robustness (Humidity fixed at " + nominalHum + "%)");
        double[] tempRobust = { TEMP_MIN - 1, TEMP_MIN, TEMP_MAX, TEMP_MAX + 1 };
        for (double t : tempRobust) {
            System.out.println("  " + validate(t, nominalHum));
        }

        System.out.println("Humidity robustness (Temperature fixed at " + nominalTemp + "°C)");
        double[] humRobust = { HUM_MIN - 1, HUM_MIN, HUM_MAX, HUM_MAX + 1 };
        for (double h : humRobust) {
            System.out.println("  " + validate(nominalTemp, h));
        }

        System.out.println("Extreme out-of-range values");
        System.out.println("  " + validate(-999, 50));
        System.out.println("  " + validate(999,  50));
        System.out.println("  " + validate(20,  -999));
        System.out.println("  " + validate(20,   999));
    }

    static void worstCaseTesting() {
        System.out.println(" 3. WORST-CASE TESTING");

        double nominalTemp = (TEMP_MIN + TEMP_MAX) / 2.0;
        double nominalHum  = (HUM_MIN  + HUM_MAX)  / 2.0;

        double[] tempValues = { TEMP_MIN - 1, TEMP_MIN, nominalTemp, TEMP_MAX, TEMP_MAX + 1 };
        double[] humValues  = { HUM_MIN  - 1, HUM_MIN,  nominalHum,  HUM_MAX,  HUM_MAX  + 1 };

        System.out.printf("  %-6s %-12s %-14s %s%n", "Case", "Temp (°C)", "Humidity (%)", "Result");
        System.out.println("  " + "-".repeat(65));

        int caseNum = 1;
        for (double t : tempValues) {
            for (double h : humValues) {
                String result = (isValidTemperature(t) && isValidHumidity(h)) ? "VALID" : "INVALID";
                System.out.printf("  %-6d %-12.1f %-14.1f %s%n", caseNum++, t, h, result);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("LAB ENVIRONMENT VALIDATOR");
        System.out.println("Temp : -10°C  to  50°C");
        System.out.println("Humidity:  0%  to 100%");

        boundaryValueCheck();
        robustnessTesting();
        worstCaseTesting();

        System.out.println("\n=== Testing Complete ===");
    }
}
