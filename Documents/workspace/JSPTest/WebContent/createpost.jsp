<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TestShop: Create New Post</title>
<script type="text/javascript">
	function validateForm() {
		var itemName = document.forms["createPostForm"]["ItemName"].value;
		if (itemName == null || itemName == "") {
			alert("Item Name cannot be empty!");
			return false;
		}
	}
</script>
</head>
<body>
	<form name="createPostForm" action="createPostController" method="post"
		onsubmit="return validateForm()">
		<h3>
			<b>Create New Post</b>
		</h3>
		<p>All fields are mandatory</p>
		<p>
			Item Name:<br> <input type="text" name="ItemName"
				class="loginbox">
		</p>
		<br>
	</form>
</body>
</html>