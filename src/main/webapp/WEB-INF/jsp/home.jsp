<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>First JSP</title></head>
<body>
  <%
    double num = Math.random();
    if (num > 0.95) {
  %>
      <h2>You'll have a luck day!</h2><p>(<%= num %>)</p>
  <%
    } else {
  %>
      <h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
  <%
    }
  %>
  <form action="addAlien">
    <label>Aid  :</label><br>
    <input type="text"  name="aid"><br>
    <label>Aname:</label><br>
    <input type="text" name="aname"><br><br>
    <input type="submit">
  </form>
  <form action="showData">
      <label>Aid  :</label><br>
      <input type="text"  name="aid"><br>
      <input type="submit">
    </form>

</body>
</html>