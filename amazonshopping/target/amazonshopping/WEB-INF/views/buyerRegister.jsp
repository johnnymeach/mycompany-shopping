

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" ng-app="minmax">
<head >
	<title >Buyer Register</title >
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" >
    <link href="./resources/js/ladda-themeless.min.css" rel="stylesheet">
	<link href="./resources/css/main.css" rel="stylesheet" >
</head >

<body >
<nav class="navbar navbar-inverse navbar-fixed-top" >
	<div class="container" >
		<div class="navbar-header" >
			<a class="navbar-brand"
			   href="#" >Buyer Register
			</a >
		</div >
	</div >
</nav >

<div class="container main-content" ng-controller="MinMaxCtrl">

	<form ng-submit="onSubmit()" novalidate="novalidate">
		<div class="form-group" >
			<label for="name" class="control-label">Name</label >
			<input type="text"
			       class="form-control"
                   ng-model="formModel.name" 
			       id="name" 
                   required="required">
		</div >

		<div class="form-group">
			<label for="email" class="control-label">Email</label >
			<input type="email"
			       class="form-control"
                   ng-model="formModel.email" 
			       id="email" 
                   name="email"
                   required="required">
		</div >
        
       
        
		<div class="form-group" >
			<label for="username" class="control-label">Username</label >
			<input type="text"
			       class="form-control"
                   ng-model="formModel.username" 
			       id="username" 
                   
                   ng-pattern="/^[A-Za-z0-9_]{1,15}$/"
                   
                   ng-minlength="7"
                   
                   ng-pattern-err-type="badUsername"
                   
                   required="required">
		</div >

		<div class="form-group" >
			<label for="age" class="control-label">Age</label >
			<input type="number"
			       class="form-control"
                   ng-model="formModel.age"
                   min="18"
                   max="64"
			       id="age" 
                   ng-min-err-type="tooYoung"
                   ng-max-err-type="tooOld"
                   required="required">
		</div >

		<div class="form-group" >
			<label for="sex" class="control-label">Sex</label >
			<select name="sex"
			        id="sex"
                    ng-model="formModel.sex" 
                    required="required"
				    class="form-control" >
				<option value="" >Please Choose</option >
				<option value="male" >Male</option >
				<option value="female" >Female</option >
			</select >
		</div >

		<div class="form-group" >
			<label for="password" class="control-label">Password</label >
			<input type="password"
			       class="form-control"
                   ng-model="formModel.password" 
                   required="required"
                   ng-minlength="10"
			       id="password" >
		</div >

		<div class="form-group">
			<button class="btn btn-primary" 
                    type="submit"
                    ladda="submitting" 
                    data-style="expand-right"
                    >
                <span ng-show="submitting">Registering</span>
                <span ng-show="!submitting">Register</span>
			</button>
                    <span>Not a user? Register as a <a href="vendorRegister">business account</a></span>
		</div>
	</form >
</div >


<script src="./resources/js/angular.min.js" ></script>
<script src="./resources/js/jcs-auto-validate.js"></script>
<script src="./resources/js/spin.min.js"></script>
<script src="./resources/js/ladda.min.js"></script>
<script src="./resources/js/angular-ladda.min.js"></script>
<script src="./resources/js/main.js" ></script>


</body >
</html >
