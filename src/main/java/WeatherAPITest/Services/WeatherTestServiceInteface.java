package WeatherAPITest.Services;

import WeatherAPITest.model.Stats;

import java.util.List;

public interface WeatherTestServiceInteface {

    public Stats getWeatherbyCity(String city) throws Exception;

}
