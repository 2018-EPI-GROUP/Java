<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商品列表</title>
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-reboot.min.css">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container" style="margin-top: 120px">

    <c:forEach var="item" items="${itemList}">

        <div class="card" style="width:25%; margin: 30px 30px 50px 50px">
            <img class="card-img-top" src="https://static.runoob.com/images/mix/img_avatar.png" alt="Card image"
                 style="width:100%">
            <div class="card-body">
                <h4 class="card-title">${item.itemName}</h4>
                <c:if test="${item.itemDetail.length() > 10}">
                    <p class="card-text">${item.itemDetail.substring(0, 10)}...</p>
                </c:if>
                <c:if test="${item.itemDetail.length() <=10}">
                    <p class="card-text">${item.itemDetail}</p>
                </c:if>
                <a href="${pageContext.request.contextPath}/item/findItem/${item.id}.do"
                   class="btn btn-primary">查看详情</a>
            </div>
        </div>
    </c:forEach>

</div>
</body>
</html>
