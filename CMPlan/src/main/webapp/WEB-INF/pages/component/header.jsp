<div class="username">
	User logged: <%= request.getUserPrincipal() != null ?  request.getUserPrincipal().getName() : "Anonymous" %>
</div>
<div class="logout">
	<a href="/CMPlan/logout.htm">Logout</a>
</div>