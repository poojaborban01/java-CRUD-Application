<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Add Medicine</title>
</head>
<body>

<h2>Add Medicine</h2>

<form action="/Java-CRUD-Application/medi" method="post">
    Name: <input type="text" name="name"><br><br>
    Price: <input type="text" name="price"><br><br>
    Quantity: <input type="text" name="quantity"><br><br>

    <input type="submit" value="Add Medicine">
</form>

</body>
</html>