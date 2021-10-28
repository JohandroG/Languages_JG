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
<link rel="stylesheet" href="./css/info.css"/>
</head>
<body>
    <main>
        <nav>
            <a href="/">Dashboard</a>
        </nav>
        <div class="info">
                <div>
                    <p>
                        <c:out value = "${language.getName()}" > </c:out>
                    </p>
                    <p>
                        <c:out value = "${language.getCreator()}" > </c:out>
                    </p>
                    <p>
                        <c:out value = "${language.getCurrentVersion()}" > </c:out>
                    </p>
                </div>
                <div class="options">
                    <form id="delete-form" action="/delete/${language.getIdentifier()}" method="POST">
                        <input type="hidden" name="_method" value="DELETE">
                        <input class="btn btn-danger" type="submit" value="DELETE">
                    </form>
					<a href="/edit/${language.getIdentifier()}">Edit</a>
                </div>
        </div>
    </main>
</body>
</html>