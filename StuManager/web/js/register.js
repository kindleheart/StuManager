$(function () {
    //使用jquery Ajax实现用户名检查
    $("#scode").blur(function() {
        var scode = $(this).val();
        $.post("CheckScodeServlet",
            {
                scode:scode
            },
            function(data,status){
                $("#error").remove();
                if(data == 1) {
                    $("#center").after("<div id='error'>Scode has been registered!</div>");
                }
            });
    });
    $("#captcha").click(function() {
        $(this).attr("src", "CaptchaServlet?xxx=" + new Date().getTime());
    }).mouseover(function () {
        $(this).css("cursor", "pointer");
    });
});