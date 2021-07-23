<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Awesome App</title>
</head>
<body>
<h1><%= "Important Form" %>
</h1>
<br/>
<form method="post" action="myServlet" autocomplete="off">
    <label for="name">What's your name?</label><br>
    <input type="text" id="name" name="name"><br>
    <label for="favFruit">What's your favorite fruit?</label><br>
    <input type="text" id="favFruit" name="favFruit"><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>