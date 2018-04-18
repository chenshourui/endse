<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <script type="text/javascript" src="script/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="tool/submit.js"></script>
    <script type="text/javascript" src="tool/common.js"></script>

</head>
<body>
    <input type="button" value="靠" onclick="onClick()" />
</body>
</html>

<script>
    function  onClick() {
        var url = basePath+"userController/say";

        var data={
            name:"chensr",
            say:"曹尼玛的联通"
        }

        ajaxSubmit(url,data,function (result) {
            alert(result.msg);
        })
    }


</script>
