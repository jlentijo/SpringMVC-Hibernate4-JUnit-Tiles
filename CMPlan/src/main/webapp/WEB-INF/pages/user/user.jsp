<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="title">List of users</div>
<table class="table_user">
	<thead>
		<tr>
			<td>IdUser</td>
			<td>Username</td>
			<td>Name</td>
			<td>Surnames</td>
			<td>Date inserted</td>
			<td>Date updated</td>
			<td></td>
			<td></td>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="user" items="${listUsers}">
		<tr>
			<td>${user.idUser}</td>
			<td>${user.username}</td>
			<td>${user.name}</td>
			<td>${user.surnames}</td>
			<td>${user.insert_date}</td>
			<td>${user.last_update_date}</td>
			<td><a href="/CMPlan/user/loadUser/${user.idUser}.htm"><img src="/CMPlan/img/pencil.png"/></a></td>
			<td><a href="/CMPlan/user/deleteUser/${user.idUser}.htm"><img src="/CMPlan/img/trash.png"/></a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<form action="/CMPlan/user/saveUser.htm" method="post">
	<table class="form">
		<tr>
			<td><label>Username</label></td>
			<td><input value="${user.username}" name="user.username"/></td>
		</tr>
		<tr>
			<td><label>Name</label></td>
			<td><input value="${user.name}" name="user.name"/></td>
		</tr>
		<tr>
			<td><label>Surnames</label></td>
			<td><input value="${user.surnames}" name="user.surnames"/></td>
		</tr>
		<tr>
			<td>
				<input type="hidden" name="user.idUser" value="${user.idUser}"/>
			</td>
			<td>
				<input type="reset" class="button" value="Reset"/>
				<input type="submit" class="button" value="Save User"/>
			</td>
		</tr>
	</table>
</form>