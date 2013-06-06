<%--
  Created by IntelliJ IDEA.
  User: purnachandrarao
  Date: 6/5/13
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search Results</title>
    <meta name="layout" content="main"/>
</head>
<body>
<h1>Results</h1>
<p>Searched ${com.grailsinaction.Profile.count()} records

Found <strong>${profiles.size()}</strong> hits.
</p>
<ul>
    <g:each var="profile" in="${profiles}">
        <li>${profile.fullName}</li>
    </g:each>
</ul>
<g:link action='search'>Search Again</g:link>
</body>
</html>