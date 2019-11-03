<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商品详情</title>
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-reboot.min.css">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<div style="margin: 150px auto; width: 990px; min-height: 600px">
    <h1 style="margin: 0 auto; text-align: center">${it.itemName}</h1>
    <br>
    <br>
    <br>
    <br>
    <h2>商品价格：${it.itemPrice}</h2>
    <br>
    <h2>商品销量：${it.itemSales}</h2>
    <br>
    <h2>商品评价：${it.itemComment}</h2>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <hr>
    <h2>商品详情：${it.itemDetail}</h2>
    <br>


</div>
</body>
</html>
