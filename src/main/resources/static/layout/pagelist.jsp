<%--
  Created by IntelliJ IDEA.
  User: wanxp
  Date: 18-2-9
  Time: 下午2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="main-content index-page clearfix">
    <div class="post-lists">
        <div class="post-lists-body">
            <c:forEach items="contentList" begin="0" end="11" var="content" >
                <div class="post-list-item">
                    <div class="post-list-item-container">
                        <div class="item-thumb bg-deepgrey" style="background-image:url(${content.pictureUrl});"></div>
                        <a href="${content.url}">
                            <div class="item-desc">
                                <p>${content.shortContent}...</p>
                            </div>
                        </a>
                        <div class="item-slant reverse-slant bg-deepgrey"></div>
                        <div class="item-slant"></div>
                        <div class="item-label">
                            <div class="item-title"><a href="${content.url}">${content.title}</a>
                            </div>
                            <div class="item-meta clearfix">
                                <div class="item-meta-ico ${show_icon()}"
                                     style="background: url(/templates/themes/default/static/img/bg-ico.png) no-repeat;background-size: 40px auto;"></div>
                                <div class="item-meta-cat">
                                        ${show_categories()}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

</div>
