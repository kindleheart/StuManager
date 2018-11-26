$(function () {
    $(".choose").click(function () {
        var flag = confirm("确定选择此课？");
        if(flag) {
            var number;
            number = this.getAttribute("number");
            $.post("SelectServlet",
                {
                    number:number
                },
                function(data,status){
                    $("#error").remove();
                    $("#success").remove();
                    if(data == 1) {
                        $("#p").after("<div id='success'>You have successfully chosen this course!</div>");
                    } else if(data == 0) {
                        $("#p").after("<div id='error'>You have chosen the course, so you can't do it again!</div>");
                    }});
        }
    });
});