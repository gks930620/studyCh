<%@ tag language="java" body-content="empty" pageEncoding="UTF-8" %>
<%@ tag trimDirectiveWhitespaces="true"  %>        
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- tags/pagination.tag  --%>

<%@ attribute name="pageObject" required="true" type="com.study.common.vo.PagingVO"  %>
<%@ attribute name="linkPage" type="java.lang.String" %>

<!-- START : 페이지네이션  --> 
<nav class="text-center">
  <ul class="pagination" >
  	<c:if test="${pageObject.firstPage > 1}">
	    <li>
	      <a href="${linkPage}?curPage=${pageObject.firstPage - 1}" data-page="${pageObject.firstPage - 1}"  aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
   	</c:if>
    
    <c:forEach begin="${pageObject.firstPage}" end="${pageObject.lastPage}" var="i">
    	<c:if test="${i != pageObject.curPage}">
    		<li ><a href="${linkPage}?curPage=${i}" data-page="${i}"   >${i}</a></li>
    	</c:if>
    	<c:if test="${i == pageObject.curPage}">
    		<li class="active" ><a>${i}</a></li>
    	</c:if>
    </c:forEach>
    
    <c:if test="${pageObject.lastPage < pageObject.totalPageCount}">	    
	    <li>
	      <a href="${linkPage}?curPage=${pageObject.lastPage + 1}" data-page="${pageObject.lastPage + 1}"  aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
    </c:if>
  </ul>
</nav>
<!-- END : 페이지네이션  --> 	
