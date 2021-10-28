<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="./css/index.css"/>
	</head>
	<body>
		<main>
			
			<h1>
				List of hobbies
			</h1>

			<table id="table">
				<tr id="head">
					<td>Name</td>
					<td>Creator</td>
					<td>Version</td>
					<td>action</td>
				</tr>
				<c:forEach var = "language" items = "${langList}">
					<tr id="data">
						<td>
							<a href="/info/${language.getIdentifier()}">
							<c:out value = "${language.getName()}" > 
							</a>
						</c:out></td>
						<td><c:out value = "${language.getCreator()}" > </c:out></td>
						<td><c:out value = "${language.getCurrentVersion()}" > </c:out></td>
						<td>
							<form id="delete-form" action="/delete/${language.getIdentifier()}" method="POST">
								<input type="hidden" name="_method" value="DELETE">
								<input class="btn btn-danger" type="submit" value="DELETE">
							</form>
							<a href="/edit/${language.getIdentifier()}">Edit</a>
						</td>
					</tr>
				</c:forEach>

			</table>
			
			<form method="POST" action="/create" id="form">
				<div class="div">
					<label for="name">Name</label>
					<input name="name" id="name" type="text"/>
				</div>
				<div class="div">
					<label for="creator">Creator</label>
					<input name="creator" id="creator" type="text"/>
				</div>
				<div class="div">
					<label for="version">Version</label>
					<input name="version" id="version" type="text"/>
				</div>

				<button type="submit">Submit</button>
			</form>
		</main>
	</body>
</html>