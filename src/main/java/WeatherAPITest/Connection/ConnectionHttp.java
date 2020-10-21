package WeatherAPITest.Connection;

import WeatherAPITest.model.Stats;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConnectionHttp implements ConnectionHttpInterface {


    @Override
    public Stats getWeatherbyCity(String ciudad) throws Exception {

        Request request = request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/weather?q="+ciudad+"&appid=d729e17844904bad642984f1d42ef559")
                .get()
                .build();

        OkHttpClient cliente = new OkHttpClient();
        String respuestaApi = null;
        Response respuesta = null;

        try {
            respuesta = cliente.newCall(request).execute();
            if (respuesta.isSuccessful()) {
                respuestaApi = respuesta.body().string();
            }
        } catch (IOException e) {
            throw new Exception("Not Service Found ");
        }

        Gson gson = new Gson();
        Stats stats = new Stats();
        stats = gson.fromJson(respuestaApi,Stats.class);


        return stats;
//        Data stats = new Data();
    }


}
