<%--
  Created by IntelliJ IDEA.
  User: purnachandrarao
  Date: 6/6/13
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
    <meta name="layout" content="main"/>

</head>
<body>
<g:uploadForm action="upload">
    Photo: <input name="photo" type="file" />
    <g:submitButton name="upload" value="Upload"/>
</g:uploadForm>
</body>
</html>