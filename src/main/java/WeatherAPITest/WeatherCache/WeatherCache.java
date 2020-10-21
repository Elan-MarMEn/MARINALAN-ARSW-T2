package WeatherAPITest.WeatherCache;

import WeatherAPITest.model.Stats;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("cache")
public class WeatherCache implements WeatherCacheInterface{
    private int stateCache;
    private Stats stats;

    public WeatherCache() {
        this.stateCache = 0;
        this.stats = null;

    }

    @Override
    public void addCache(Stats stats){
        this.stateCache= 1;
        this.stats= stats;
    }

    @Override
    public Stats getCache(){
        return this.stats;
    }

    @Override
    public void resetCache(){
        this.stateCache = 0;
        this.stats = null;
    }
}
