api= (function(){
    function getWeatherByCity(city,callback){
        $.ajax ({
            dataType: "json",
            url: "https://marin-arsw-t2.herokuapp.com/weather/"+city,
            success: function(data){
            callback(data)
            }
        });
    }

return{
    getWeatherByCity:getWeatherByCity
}


})();