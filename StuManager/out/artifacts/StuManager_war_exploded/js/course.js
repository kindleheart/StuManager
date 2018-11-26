$(function () {
    $(".delete").click(function () {
        var flag = confirm("确定删除此课？");
        if(flag) {
            var number;
            number = this.getAttribute("number");
            location.href = "DeleteServlet?number=" + number;
        }
    });
});