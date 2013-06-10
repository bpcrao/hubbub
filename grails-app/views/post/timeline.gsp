<html>
<head>
    <title>
        Timeline for ${user.profile==null?user.username:user.profile.fullName }
    </title>
    <meta name="layout" content="main"/>
    <g:if test="${user.profile?.skin}">
        <link rel="stylesheet" href="
        <g:createLinkTo dir='css'
                        file='${user.profile?.skin}.css'/>
        "/>
    </g:if>
</head>
<body>
<div id="newPost">
    <h3>
        What is ${user.profile?.fullName} working on right now?
    </h3>
    <p>
        <g:form action="addPost" id="${user.username}">
            <g:textArea id='postContent' name="content"
                        rows="20" cols="100"/><br/>
            <g:submitButton name="post" value="Post"/>
        </g:form>
    </p>
</div>

<g:if test="${flash.message}">
    <div class="flash">
        ${flash.message}
    </div>
</g:if>

<h1>Timeline for ${user.profile?.fullName}</h1>
<br>
<div class="allPosts">
    <g:each in ="${user.posts}" var="post">
        <div class="postEntry">
            <div class="postText">
                ${post.content}
            </div>
            <div class="postDate">
                <small>posted on ${post.dateCreated}</small>
            </div>
            <div class="postTag">[
                <g:each in="${post.tags}" var="tag">
                  <strong>   ${tag.name}  </strong>
                </g:each>
                ]
            </div>
        </div>
        <br>
        <br>
    </g:each>
</div>
</body>
</html>