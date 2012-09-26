<h4>User logged: <%= request.getUserPrincipal() != null ?  request.getUserPrincipal().getName() : "Anonymous" %></h4>
<a href="/logout.htm">Logout</a>