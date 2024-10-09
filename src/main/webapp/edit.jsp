<%@page import="org.apache.commons.codec.binary.Base64"%>

<%@page import="movie.demo.Movies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Movies movie=(Movies) request.getAttribute("Movie"); %>
<div>
<h1>Update Movie</h1>
<form action="updateMovie" method="post" enctype="multipart/form-data">
<%-- <input type="text" name="id" value="<%=movie.getId()%>">  --%>
<!-- if we use this then the id can be changed so we will not use this one and we can carry -->

<%-- <input type="text"  name="id" disabled="disabled" value="<%= movie.getId()%>"> --%>
<!-- if we use disabled then user cant change the value but this will not be carried -->

<input type="hidden" name="id" value="<%= movie.getId()%>">  
 <!-- if we use hidden then value is not visible and we can carry also -->


<br>
<label for="name">Name:</label>
<input type="text" id="name" name="name" value="<%=movie.getMname() %>"><br><br>

<label for="desc">Description:</label>
<input type="text" id="desc" name="desc" value="<%=movie.getDescription() %>"><br><br>

<label for="poster">Poster:</label>
<input type="file" id="poster" name="poster" >
<img height="100px" width="100px" alt="<%=movie.getPoster()%>" src="data:image/png;base64,<%=Base64.encodeBase64String(movie.getPoster())%>">
<br><br>

<label for="language">Language:</label>
<select name="lang"> 
<option>Kannada</option>
<option>Hindi</option>
<option>English</option>
<option>Tamil</option>
</select>
<br><br>

<label for="Genre">Genre:</label>
<input type="checkbox" name="genre" value="comedy" >comedy
<input type="checkbox" name="genre" value="tragedy">tragedy
<input type="checkbox" name="genre" value="horror">Horror
<input type="checkbox" name="genre" value="romantic">Romantic
<input type="checkbox" name="genre" value="scifi">Scientific<br><br>


<label for="rateing" >Rating: </label>
<input type="number" id="rateing" name="rateing" value="<%=movie.getRateing()%>"><br><br>

<button >Update</button>

</form>
</div>


</body>
</html>