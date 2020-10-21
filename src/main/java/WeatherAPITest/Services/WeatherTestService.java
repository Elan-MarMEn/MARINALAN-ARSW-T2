package WeatherAPITest.Services;

import WeatherAPITest.Connection.ConnectionHttpInterface;
import WeatherAPITest.WeatherCache.WeatherCacheInterface;
import WeatherAPITest.model.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("weather")
public class WeatherTestService implements WeatherTestServiceInteface{
    @Autowired
    ConnectionHttpInterface connectionHttpInterface;

    @Autowired
    @Qualifier("cache")
    WeatherCacheInterface weatherCacheService;

    public Stats getWeatherbyCity(String city) throws Exception{
        Stats stats = new Stats();
        Stats cachestat =weatherCacheService.getCache();
        if(cachestat==null){
            stats = connectionHttpInterface.getWeatherbyCity(city);
            weatherCacheService.addCache(stats);
        }else {
            if (cachestat.getName()==city){
                stats = cachestat;
            }
        }
        return stats;
    }



}
