<%--
  Created by IntelliJ IDEA.
  User: purnachandrarao
  Date: 6/7/13
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
</head>
<body>

<g:hasErrors bean="${orderDetails}">
    <div class="errors">
        <g:renderErrors bean="${orderDetails}"/>
    </div>
</g:hasErrors>

<g:form action="order">
    Shirts: <g:textField name="numShirts" value="0"/>
    Hats: <g:textField name="numHats" value="0"/>
    <g:submitButton name="next" value="Next"/>
    <g:submitButton name="cancel" value="Finished Shopping"/>
</g:form>
</body>
</html>