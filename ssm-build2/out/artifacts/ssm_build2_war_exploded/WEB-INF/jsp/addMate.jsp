<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增学生</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增学生</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/mate/addMate" method="post">
        学生编号：<input type="text" name="id"><br><br><br>
        学生姓名：<input type="text" name="name"><br><br><br>
        学生年龄：<input type="text" name="age"><br><br><br>
        学生性别：<input type="text" name="sex"><br><br><br>
        学生爱好：<input type="text" name="hobby"><br><br><br>
        <input type="submit" value="添加">
    </form>

</div>