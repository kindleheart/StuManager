$(function () {
    //使用jquery Ajax实现用户名检查
    $("#captcha").click(function() {
        $(this).attr("src", "CaptchaServlet?xxx=" + new Date().getTime());
    }).mouseover(function () {
        $(this).css("cursor", "pointer");
    });
});