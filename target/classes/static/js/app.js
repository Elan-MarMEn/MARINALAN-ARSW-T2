app= (function(){

    function getWeatherByCity() {

        api.getWeatherByCity($("#city").val(),showinfo);
    }

    function showinfo(stats) {
    
        $("#coord").text("Coord lat"+stats.coord.lat+" ln"+stats.coord.lon);
        $("#weather").text("Weather "+stats.weather.description);
        $("#main").text("Temperature "+stats.main.temp+" pressure "+stats.main.pressure)
        $("#visibility").text("Visibility "+stats.visibility);
        $("#id").text("id "+stats.id+" humidity "+stats.main.humidity);
    }

    return{
        getWeatherByCity: getWeatherByCity
    }
})();