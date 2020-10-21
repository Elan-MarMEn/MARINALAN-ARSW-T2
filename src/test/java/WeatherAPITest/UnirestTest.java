package WeatherAPITest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.apache.http.HttpStatus;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Test;


public class UnirestTest {

	@Test
	public void shouldReturnAllCases() throws UnirestException {
		HttpResponse<JsonNode> response = Unirest
				.get("http://api.openweathermap.org/data/2.5/weather?q=Bogota&appid=d729e17844904bad642984f1d42ef559")
				.asJson();

		assertNotNull(response.getBody());
		assertEquals((int)HttpStatus.SC_OK,response.getStatus());
	}
	
	@Test
	public void shouldReturnCaseByCountry() throws UnirestException {
		HttpResponse<JsonNode> response = Unirest
				.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=d729e17844904bad642984f1d42ef559")
				.asJson();

		assertNotNull(response.getBody());
		assertEquals((int)HttpStatus.SC_OK,response.getStatus());
	}
}
