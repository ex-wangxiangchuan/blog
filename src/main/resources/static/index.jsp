<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
    function nextPage() {
    }
</script>

<%@include file="layout/header.jsp"%>
<div class="contentPage">
    <%@include file="layout/pagelist.jsp"%>
</div>
<div class="lists-navigator clearfix">
    <a href="${pageContext.request.contextPath}/contentController/pagePre"><-</a>
    <a href="${pageContext.request.contextPath}/contentController/page">1</a>
    <a href="javascript:void(0);" onclick="nextPage()">-></a>
</div>
<%@include file="layout/footer.jsp"%>
