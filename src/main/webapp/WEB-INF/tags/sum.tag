<%@ tag language="java" body-content="scriptless" pageEncoding="UTF-8"%>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="begin" required="true" type="java.lang.Integer" %>
<%@ attribute name="end" required="true" type="java.lang.Integer" %>
<%@ attribute name="var" required="true" rtexprvalue="false" type="java.lang.String" %>
<%@ variable alias="meat" name-from-attribute="var"  scope="NESTED" %>
<c:set var="meat" value="0" />
<c:forEach begin="${begin}" end="${end}" var="i">
		<c:set var="meat" value="${meat + i}" />
		${i}번째 <jsp:doBody /> <br>
</c:forEach>

