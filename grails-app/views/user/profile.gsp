<%--
  Created by IntelliJ IDEA.
  User: purnachandrarao
  Date: 6/6/13
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
</head>
<body>
<div class="profilePic">
    <%  def profile = user.profile %>
    <g:if test="${profile.photo}">
        <img src=" <g:createLink controller='image'
              action='renderImage' id="${user.userId}"/>
        "/>
    </g:if>
    <p>Profile for <strong>${profile.fullName}</strong></p>
    <p>Bio: ${profile.bio}</p>
</div>
</body>
</html>