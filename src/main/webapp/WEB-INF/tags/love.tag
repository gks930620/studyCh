<%@ tag language="java" body-content="empty" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="count" required="true" type="java.lang.Integer"  %>
<%@ attribute name="name" required="false" type="java.lang.String"  %>

<c:if test="${empty name}">
	<c:set var="name" value="milkis" />
</c:if>

<c:forEach begin="1" end="${count}" var="i">
	${i} 사랑해요 ${name} !! <br>
</c:forEach>

<%-- 
  java 식으로 하지 마시고 jstl 형식으로 해 주세요 
	String names = "";
	if(name != null){
		names = "밀키스";
	}else{
		names = name;
	}
				
	for(int i = 0; i < count; i++){
			out.print("사랑해요 " + names + "~~ <br>");
	}
--%>




