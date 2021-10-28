<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/edit.css"/>
</head>

<body>

    <main>
        <nav id="nav">
            <form id="delete-form" action="/delete/${language.getIdentifier()}" method="POST">
                <input type="hidden" name="_method" value="DELETE">
                <input class="btn btn-danger" type="submit" value="DELETE">
            </form>
            <a href="/">Dashboard</a>
        </nav>
        
        <form method="POST" action="/update">
            <div class="div">
                <input type="hidden" value="${language.getIdentifier()}" id="id" name="id"/>
                <label for="name">Name</label>
                <input name="name" value="${language.getName()}" id="name" type="text"/>
            </div>
            <div class="div">
                <label for="creator">Creator</label>
                <input name="creator" value="${language.getCreator()}" id="creator" type="text"/>
            </div>
            <div class="div">
                <label for="version">Version</label>
                <input name="version" value="${language.getCurrentVersion()}" id="version" type="text"/>
            </div>
        
            <button class="div" type="submit">Submit</button>
        </form>
    </main>

</body>
</html>