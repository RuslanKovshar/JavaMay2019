<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>
<body <#--ng-app="registrationForm" ng-controller="AppCtrl"-->>

<div class="container">
    <form class="form-signin" <#--action="/registration"--> method="post" name="form" autocomplete="off" novalidate ng-submit="form.$valid && sendForm(auth)">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <#if exist>
            <div class="alert alert-danger" role="alert">User already exist</div>
        </#if>
        <#if success>
            <div class="alert alert-success" role="alert">New user created.</div>
        </#if>
        <div class="form-group">
            <label for="InputEmail">Email address</label>
            <input type="email"
                   class="form-control"
                   id="InputEmail"
                   placeholder="Email"
                   pattern="([a-z0-9_\.-]+)@([a-z0-9_\.-]+)\.([a-z\.]{2,6})"
                   title="Must look like example@mail.com"
                   required
                   ng-model="auth.email"
                    name="email">
        </div>
        <div class="form-group">
            <label for="InputPassword">Password</label>
            <input type="password"
                   class="form-control"
                   id="InputPassword"
                   placeholder="Password"
                   required
                   ng-model="auth.password"
            name="password">
        </div>

        <button type="submit" class="btn btn-primary btn-lg btn-block"  style="margin-top:30px" ng-disabled="form.$invalid">
            Submit
        </button>
    </form>

    <form class="form-signin" action="/login">
    <#--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
        <button type="submit" class="btn btn-secondary btn-lg btn-block"> Back to login page</button>
    </form>
</div>

<script type="text/javascript" src="../js/angular.min.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
</body>
</html>