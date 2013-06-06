<%@ page import="com.grailsinaction.Profile" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
    <meta name="layout" content="main"/>
</head>
<body>
<formset>
    <legend>Search for Friends</legend>
    <g:form action="results">

        <label for="fullname">Name</label>
        <g:textField name="fullname" />

        <label for="email">e-Mail</label>
        <g:textField name="email" />

        <g:submitButton name="search" value="Search"/>
    </g:form>
</formset>
</body>
</html>