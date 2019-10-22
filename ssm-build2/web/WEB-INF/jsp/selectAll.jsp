<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
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
                    <small>学生列表 —— 显示所有学生信息</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/mate/toAddPaper">新增学生</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/mate/allMates">显示全部学生信息</a>
        </div>
        <div class="col-md-4 column">
            <form action="${pageContext.request.contextPath}/mate/fuzzyQuery" method="post" >
                <input type="text" placeholder="请输入学生名字的关键字" class="form-control" name="queryMates">
                <input type="submit" value="查询" class="btn btn-primary">
            </form>
        </div>



    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>学生编号</th>
                    <th>学生姓名</th>
                    <th>学生年龄</th>
                    <th>学生性别</th>
                    <th>学生爱好</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="mate" items="${requestScope.get('mates')}">
                    <tr>
                        <td>${mate.getId()}</td>
                        <td>${mate.getName()}</td>
                        <td>${mate.getAge()}</td>
                        <td>${mate.getSex()}</td>
                        <td>${mate.getHobby()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/mate/toUpdatePaper?id=${mate.getId()}">更改</a> |
                            <a href="${pageContext.request.contextPath}/mate/del?id=${mate.getId()}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>