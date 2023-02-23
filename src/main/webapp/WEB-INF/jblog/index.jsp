<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="./layout/header.jsp"%>

<%-- content --%>
<div class="container mt-3">
   <c:if test="${!empty postList}">

        <div class="card">
            <c:forEach var="post" items="${postList.content}">
            <div class="card-body">
                <h4 class="card-title">${post.title}</h4>
                <a href="#" class="btn btn-secondary">상세보기</a>
            </div>
            </c:forEach>
        </div>

           <ul class="pagination justify-content-between" >
               <li class="page-item">
                   <a class="page-link" href="?page=${postList.number - 1}">이전</a>
               </li>
               <li class="page-item">
                   <a class="page-link" href="?page=${postList.number + 1}">다음</a>
               </li>
           </ul>

   </c:if>
</div>
<%-- //content --%>

<%@ include file="./layout/footer.jsp"%>

