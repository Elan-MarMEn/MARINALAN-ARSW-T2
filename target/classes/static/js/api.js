api= (function(){
    function getWeatherByCity(city,callback){
        $.ajax ({
            dataType: "json",
            url: "http://localhost:8080/weather/"+city,
            success: function(data){
            callback(data)
            }
        });
    }

return{
    getWeatherByCity:getWeatherByCity
   
}


})();