<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TestShop: Create New Post</title>
<script type="text/javascript">
	function validateForm() {
		var postName = document.forms["createPostForm"]["PostName"].value;
		var postPrice = document.forms["createPostForm"]["PostPrice"].value;

		if (postName == null || postName == "") {
			alert("Item name cannot be empty!");
			return false;
		}
		if (postPrice == null || postPrice == "" || isNaN(postPrice)
				|| postPrice < 0 || postPrice == 0) {
			alert("Invalid item price.");
			return false;
		}

	}
</script>
</head>
<body>
	<form name="createPostForm" action="CreatePostController" method="post"
		onsubmit="return validateForm()">
		<h3>
			<b>Create New Post</b>
		</h3>
		<p>* Fields are mandatory</p>
		<p>
			* Item Name:<br> <input type="text" name="PostName"
				class="loginbox">
		</p>
		<p>
			* Post Type:<br> <input type="radio" name="PostType"
				value="Offer" class="loginbox" checked> I am offering this
			item.<br> <input type="radio" name="PostType" value="Want"
				class="loginbox"> I want this item.
		</p>
		<p>
			* Price:<br> <input type="text" name="PostPrice" class=logingbox>
		</p>
		<p>
			* Description:<br>
			<textarea name="PostDescription" rows="4" cols="50">Please insert the description of the item you want to sell here.</textarea>
		</p>
		<p>
			<input type="submit" value="Post Your Add" class="Loginbutton"><input
				type="reset" value="Reset" class="loginbutton">
		</p>
	</form>
</body>
</html>