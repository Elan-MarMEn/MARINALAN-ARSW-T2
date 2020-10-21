package WeatherAPITest.WeatherCache;

import WeatherAPITest.model.Stats;

public interface WeatherCacheInterface {

    public void addCache(Stats stats);

    public Stats getCache();

    public void resetCache();

}
