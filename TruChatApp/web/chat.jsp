<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jensm
  Date: 14/03/2020
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Home" />
    </jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>


<h2>Friends</h2>
<ul id="friendlist">

</ul>

<h2>Status</h2>
<p id="currentStatus"></p>

<%--<c:if test="${status ne null}">
    <p>${status}</p>
</c:if>--%>


<label for="status">Custom status</label>
<input id="status" name="status" type="text">
<input type="button" id="statusSubmit" value="button">

<label for="friends">Add Friend</label>
<input id="friends" name="friends" type="text">
<input type="button" id="addFriendSubmit" value="button">

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
</body>
<script src="status.js"></script>
<script src="friends.js"></script>
</html>
