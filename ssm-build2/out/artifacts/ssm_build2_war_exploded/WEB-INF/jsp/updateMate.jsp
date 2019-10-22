<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
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
                    <small>修改学生信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/mate/updateMate" method="post">
        <!-- 加入 Id 隐藏域，就可以通过 Id 更新用户了 -->
        <input type="hidden" name="id" value="${mate.getId()}" />
        学生姓名：<input type="text" name="name" value="${mate.getName()}"/><br><br><br>
        学生年龄：<input type="text" name="age" value="${mate.getAge()}"/><br><br><br>
        学生性别：<input type="text" name="sex" value="${mate.getSex()}"/><br><br><br>
        学生爱好：<input type="text" name="hobby" value="${mate.getHobby() }"/><br><br><br>
        <input type="submit" value="提交"/>
    </form>

</div>