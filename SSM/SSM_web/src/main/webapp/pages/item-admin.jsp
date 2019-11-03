<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商品管理</title>
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-reboot.min.css">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container" style="margin-top: 150px; max-width: 90%">
    <div class="table-responsive">
        <table class="table">
            <thead>
            <tr>
                <th>商品id</th>
                <th>名称</th>
                <th>价格</th>
                <th>销量</th>
                <th>评价</th>
                <th>详情</th>
                <th>管理</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${itemList}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.itemName}</td>
                    <td>${item.itemPrice}</td>
                    <td>${item.itemSales}</td>
                    <td>${item.itemComment}</td>
                    <td>${item.itemDetail}</td>
                    <td>
                        <div class="btn-group btn-group-sm">
                            <a href="${pageContext.request.contextPath}/item/findItem/${item.id}.do">
                                <button type="button" class="btn btn-primary">查看</button>
                            </a>
                            <a href="${pageContext.request.contextPath}/item/alter/${item.id}.do">
                                <button type="button" class="btn btn-warning">修改</button>
                            </a>
                            <a href="${pageContext.request.contextPath}/item/delete/${item.id}.do">
                                <button type="button" class="btn btn-danger">删除</button>
                            </a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div style="margin: 0 auto; text-align: center">
        <a href="${pageContext.request.contextPath}/pages/item-add.jsp">
            <button type="button" class="btn btn-primary">添加商品</button>
        </a>
    </div>
</div>
</body>
</html>
