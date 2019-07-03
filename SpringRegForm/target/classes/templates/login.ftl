<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Sign in</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>
<body>
<div class="container">
    <form class="form-signin" method="post" action="/login">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <h2 class="form-signin-heading">Please sign in</h2>
        <#if error>
        <div class="alert alert-danger" role="alert">Bad credentials</div>
        </#if>
        <#if logout>
            <div class="alert alert-success" role="alert">You have been signed out</div>
        </#if>
        <p>
            <label for="username" class="sr-only">Email</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Email" required autofocus>
        </p>
        <p>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
    <form class="form-signin" action="/registration">
        <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
        <p>Didn`t register yet?</p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Create account</button>
    </form>
</div>
</body>
</html>