<%-- 
    Document   : products
    Created on : Jul 14, 2024, 8:17:01 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-primary mt-1">QUẢN LÝ SẢN PHẨM</h1>
<c:url value="/products" var="action" />
<c:if test="${errMsg != null}">
    <div class="alert alert-danger" >${errMsg}</div>
</c:if>

<form:form method="post" enctype="multipart/form-data" modelAttribute="product" action="${action}">
    <form:errors path="*" element="div" cssClass="alert alert-danger" />
    <div class="mb-3 mt-3">
        <label for="name" class="form-label">Tên sản phẩm:</label>
        <form:input path="name" type="text" class="form-control" id="name" placeholder="Tên sản phẩm..." name="name" />
        <form:errors path="*" element="div" cssClass="alert alert-danger" />
    </div>
    <div class="mb-3 mt-3">
        <label for="price" class="form-label">Giá sản phẩm:</label>
        <form:input path="price" type="text" class="form-control" id="price" placeholder="Giá sản phẩm..." name="name" />
    </div>
    <div class="mb-3 mt-3">
        <label for="file" class="form-label">Ảnh sản phẩm:</label>
        <form:input path="file" type="file" accept=".jpg,.png,.bmp" class="form-control" id="file" name="name" />
    </div>
    <div class="mb-3 mt-3">
        <label for="browser" class="form-label">Danh mục:</label>
        <form:select class="form-select" path="categoryId">
            <c:forEach items="${categories}" var="c">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="mb-3 mt-3">
        <button class="btn btn-success" type="submit">Thêm sản phẩm</button>
    </div>
</form:form>

