<%@ tag language="java" pageEncoding="UTF-8"  %>
<%@ tag trimDirectiveWhitespaces="true"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="name" required="true" type="java.lang.String" %>
<%@ attribute name="items" required="true" type="java.util.Collection" %>
<%@ attribute name="itemLabel" required="true" type="java.lang.String" %>
<%@ attribute name="itemValue" required="true" type="java.lang.String" %>
<%@ attribute name="value" type="java.lang.String" %>
<%@ tag dynamic-attributes="baboMap" %>
<c:set var="otherAttr" value="" />
<c:forEach items="${baboMap}" var="m">
	<c:set var="otherAttr" value="${otherAttr += m.key += '=\"' +=  m.value += '\" '}" />
</c:forEach>

<select name="${name}" ${otherAttr} >
		<jsp:doBody />
		<c:forEach items="${items}" var="code">
			<option value="${code[itemValue]}" ${code[itemValue] eq value ? "selected='selected'" : ""} >
				${code[itemLabel]}
			</option>
		</c:forEach>
</select>



