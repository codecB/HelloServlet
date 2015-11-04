
function button1Clicked(){
    $.ajax({
        url: "/HelloServlet/hello",
        type:"GET",
        success: function(result){
            $("#response").html("My name is "+result.name + " and I was born in "+ result.birthday);
        },
        error:function(e){
            console.log(e);
        }
    });
}

function button2Clicked(){
    $.ajax({
        url: "/HelloServlet/time",
        type:"GET",
        success: function(result){
            $("#response").html("The current time is: "+result.time);
        },
        error:function(e){
            console.log(e);
        }
    });
}

function button3Clicked(){
    $("#response").empty();
}

function button4Clicked(){
    getSolarInfo();
}

function getSolarInfo(){
    $.ajax({
        url: "http://api.sunrise-sunset.org/json?lat=39.40083333&lng=-76.95138889&date=today&formatted=0",
        type:"GET",
        success: function(response){
            if(response.status == "OK"){
                var sunrise = new Date(response.results.sunrise).toLocaleTimeString();
                var sunset = new Date(response.results.sunset).toLocaleTimeString();
                var noon =new Date(response.results.solar_noon).toLocaleTimeString();
                $("#response").html("Today sun rise: " + sunrise +", sun set: "+ sunset + ", noon: "+noon);
            }
        },
        error:function(e){
            console.log(e);
        }
    });
}

$( document ).ready(function() {
    $("#button1").on("click",button1Clicked);
    $("#button2").on("click",button2Clicked);
    $("#button3").on("click",button3Clicked);
    $("#button4").on("click",button4Clicked);
});
