<!DOCTYPE html>

<%@page import="org.apache.commons.codec.binary.Base64"%>

<%@page import="java.util.Arrays"%>
<%@page import="movie.demo.Movies"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.classfile.attribute.ModuleTargetAttribute"%>
<html>
<head>

<meta charset="UTF-8">
<title>fetch.jsp</title>
</head>
<body>
<%List<Movies> movie=(List<Movies>)request.getAttribute("Movies");%>

<div align="center">
<table border=1>
<tr>
<th>Name</th>
<th>Description</th>
<th>Poster</th>
<th>Language</th>
<th>Genre</th>
<th>Rating</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<%for(Movies m:movie){ %>

<tr>
<th><%=m.getMname()%></th>
<th><%=m.getDescription()%></th>
<%-- <th><%=m.getPoster() %></th>--%>
<th><img  height="100px" width="100px" alt="<%=m.getMname()%>" src="data:image/png;base64,<%=Base64.encodeBase64String(m.getPoster())%>"></th>
<th><%=m.getLanguage()%></th>


<th><%=Arrays.toString(m.getGenre())%></th>
<th><%=m.getRateing() %></th>
<th><a href="edit?id=<%=m.getId() %>"><button>Edit</button></a></th>
<th><a href="delete?id=<%=m.getId()%>"><button>Delete</button></a></th>


<%} %>
</tr>

</table>
</div>
</body>
</html>