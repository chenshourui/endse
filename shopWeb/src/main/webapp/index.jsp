<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <script type="text/javascript" src="script/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="tool/submit.js"></script>
    <script type="text/javascript" src="tool/common.js"></script>

</head>
<body>
    <h2>Hello World! cao ni ma！！</h2>
    <input type="button" value="靠你妹的" onclick="onClick()" />
</body>
</html>

<script>
    function  onClick() {
        var url = basePath+"userController/say";
        alert(basePath);

        ajaxSubmit(url,"",function (result) {
            alert(result.msg);
        })
    }


</script>
