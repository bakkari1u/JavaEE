<HTML>
<HEAD>
<TITLE>Test</TITLE>
</HEAD>
<BODY>
<%@ page import="web.Bag" %>
<%@ page session="true" %>
<% out.println(session.getAttribute("bag")); %>
<h1>sac</h1>
<form action="/bag" method="post">
  Article : <input type="text" id="article" name="article"/>
  <input type="submit" value="submit"/>
</form>
</BODY>
</HTML>
