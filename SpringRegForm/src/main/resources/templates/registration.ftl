<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>
<body ng-app="registrationForm" ng-controller="AppCtrl">

<div class="container">
    <form class="form-signin" name="form" autocomplete="off" novalidate ng-submit="form.$valid && sendForm(auth)">
        <#if error>
        <div class="alert alert-danger" role="alert">Bad credentials</div>
    </#if>
    <#if logout>
    <div class="alert alert-success" role="alert">You have been signed out</div>
</#if>
        <div class="form-group">
            <label for="InputEmail">Email address</label>
            <input type="email"
                   class="form-control"
                   id="InputEmail"
                   placeholder="Email"
                   required
                   ng-model="auth.email">
        </div>
        <div class="form-group">
            <label for="InputPassword">Password</label>
            <input type="password"
                   class="form-control"
                   id="InputPassword"
                   placeholder="Password"
                   required
                   ng-model="auth.password">
        </div>

        <button type="submit" class="btn btn-default" style="margin-top:30px" ng-disabled="form.$invalid">
            Submit
        </button>
    </form>
</div>

<script type="text/javascript" src="../public/js/angular.min.js"></script>
<script type="text/javascript" src="../public/js/main.js"></script>
</body>
</html>