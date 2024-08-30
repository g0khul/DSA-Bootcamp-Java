import java.util.Arrays;

public class ConvertTheTemperature {
    public static void main(String[] args) {
        double celsius = 36.50;
        System.out.println(Arrays.toString(convertTemperature(celsius)));
    }

    public static double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double farenheit = celsius * 1.80 + 32.00;
        return new double[] { kelvin, farenheit };
    }
}
