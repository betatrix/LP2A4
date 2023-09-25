<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Formulário de cadastro!</h1>
<form action="/login" method="POST">
    <div>
        <label>E-mail:</label>
        <input type="email" name="mail" required/>
    </div>
    <div>
        <label>Idade:</label>
        <input type="password" name="password" required/>
    </div>
    <br>
    <div class="button">
        <button type="submit" value="Login">Fazer login</button>
    </div>
</form>
</body>
</html>