<%--
  Created by IntelliJ IDEA.
  User: wanxp
  Date: 18-2-6
  Time: 下午6:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--[if lt IE 9]>
<script src="//cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
<script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<!--[if lt IE 8]>
<div class="browsehappy" role="dialog">
当前网页 <strong>不支持</strong> 你正在使用的浏览器. 为了正常的访问, 请 <a href="http://browsehappy.com/" target="_blank">升级你的浏览器</a>。
</div>
<![endif]-->
<header id="header" class="header bg-white">
    <div class="navbar-container">
        <a href="${site_url()}" class="navbar-logo">
            <c:if test="${logo_url  == ''}">
                <img src="${theme_url('/static/img/logo.png')}" alt="${site_title()}"/>
            </c:if>
            <c:if test="${logo_url ==''}">
                <img src="${theme_option('logo_url')}" alt="${site_title()}"/>
            </c:if>
        </a>
        <div class="navbar-menu">
            <a href="${site_url('/archives')}">归档</a>
            <a href="${site_url('/links')}">友链</a>
            <a href="${site_url('/about')}">关于</a>
        </div>
        <div class="navbar-search" onclick="">
            <span class="icon-search"></span>
            <form role="search" onsubmit="return false;">
                <span class="search-box">
                    <input type="text" id="search-inp" class="input" placeholder="搜索..." maxlength="30"
                           autocomplete="off">
                </span>
            </form>
        </div>
        <div class="navbar-mobile-menu" onclick="">
            <span class="icon-menu cross"><span class="middle"></span></span>
            <ul>
                <li><a href="${site_url('/archives')}">归档</a></li>
                <li><a href="${site_url('/links')}">友链</a></li>
                <li><a href="${site_url('/about')}">关于</a></li>
            </ul>
        </div>
    </div>
</header>