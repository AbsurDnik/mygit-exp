<#import "parts/custom.ftl" as c>
<@c.page>

<h3>Login page</h3>
<form action = "/login" method="post">
	
	  <div class="form-group">
	    <label >User Name :
	    <input type="text" name="username" class="form-control" placeholder="Enter username"></label>
	  </div>
	  
	  <div class="form-group">
	    <label>Password :
	    <input type="password" class="form-control mb-2 " name="password" placeholder="Password"></label>
	  </div>
	  
	  
	  <button type="submit" class="btn btn-primary mb-1">Sign In</button>
</form>

</@c.page>