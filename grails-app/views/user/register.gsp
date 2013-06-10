<%--
  Created by IntelliJ IDEA.
  User: purnachandrarao
  Date: 6/6/13
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register New User</title>
    <meta name="layout" content="main"/>
</head>
<body>
<h1>Register New User</h1>
<g:hasErrors>
    <div class="errors">
        <g:renderErrors bean="${user}" as="list" />
    </div>
</g:hasErrors>
<g:form action="register">
    <dl>
        <dt>User name</dt>
        <dd><g:textField name="username"
                         value="${user?.username}"/></dd>
        <dt>Password</dt>
        <dd><g:passwordField name="password"
                             value="${user?.password}"/></dd>
        <dt>Full Name</dt>
        <dd><g:textField name="profile.fullName"
                         value="${user?.profile?.fullName}"/></dd>
        <dt>Bio</dt>
        <dd><g:textArea name="profile.bio"
                        value="${user?.profile?.bio}"/></dd>
        <dt>Email</dt>
        <dd><g:textField name="profile.email"
                         value="${user?.profile?.email}"/></dd>
        <dt><g:submitButton name="register" value="Register"/></dt>
    </dl>
</g:form>
</body>
</html>