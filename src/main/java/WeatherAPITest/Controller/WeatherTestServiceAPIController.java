package WeatherAPITest.Controller;

import WeatherAPITest.Services.WeatherTestServiceInteface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/weather")
public class WeatherTestServiceAPIController {

    @Autowired
    @Qualifier("weather")
    WeatherTestServiceInteface weatherTestService;

    @RequestMapping(value = "/{city}",method = RequestMethod.GET)
    public ResponseEntity<?> getAllContries(@PathVariable String city){
        try {
            //obtener datos que se enviarán a través del API
            return new ResponseEntity<>(weatherTestService.getWeatherbyCity(city), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(WeatherTestServiceAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
