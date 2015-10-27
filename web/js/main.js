
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

$( document ).ready(function() {
    $("#button1").on("click",button1Clicked);
    $("#button2").on("click",button2Clicked);
    $("#button3").on("click",button3Clicked);
});
