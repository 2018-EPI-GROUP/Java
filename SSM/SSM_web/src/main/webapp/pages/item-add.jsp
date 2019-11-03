<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>增加商品</title>
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-reboot.min.css">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div style="margin: 150px 600px">
    <form action="${pageContext.request.contextPath}/item/save.do" method="post">
        <div class="form-group">
            <label for="itemName">商品名称</label>
            <input type="text" class="form-control" id="itemName" name="itemName" required>
        </div>
        <div class="form-group">
            <label for="itemPrice">商品价格</label>
            <input type="text" class="form-control" id="itemPrice" name="itemPrice" required>
        </div>
        <div class="form-group">
            <label for="itemSales">商品销量</label>
            <input type="number" class="form-control" id="itemSales" name="itemSales" required>
        </div>
        <div class="form-group">
            <label for="itemComment">商品评价</label>
            <input type="text" class="form-control" id="itemComment" name="itemComment" required>
        </div>
        <div class="form-group">
            <label for="itemDetail">商品详情</label>
            <input type="text" class="form-control" id="itemDetail" name="itemDetail" required>
        </div>
        <button type="submit" class="btn btn-primary">提交</button>
    </form>
</div>
</body>
</html>
