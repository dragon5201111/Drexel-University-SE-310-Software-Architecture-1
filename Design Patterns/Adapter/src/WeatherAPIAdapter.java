public class WeatherAPIAdapter extends WeatherAPI {

    public double getTemperatureFarenheit(){
        return this.celsiusToFahrenheit(this.getTemperatureCelsius());
    }

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
