package WeatherAPITest.Connection;

import WeatherAPITest.model.Stats;

public interface ConnectionHttpInterface {

    public Stats getWeatherbyCity(String ciudad) throws Exception;
}
