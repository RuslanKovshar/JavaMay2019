<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Main page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>
<body>
<div class="container" style="width: 40%;">
    <h2>Hello, dear user. That`s your info</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Email</th>
            <th scope="col">Role</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${id}</td>
            <td>${email}</td>
            <td><#list role as r >${r}</#list></td>
        </tr>
        </tbody>
    </table>

    <#if admin>
        <form action="/all_users">
            <button type="submit" class="btn btn-lg btn-primary btn-block">Show all users</button>
            <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
        </form>
    </#if>

    <br>
    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit" class="btn btn-lg btn-primary btn-block" style="background-color: crimson;">Logout
        </button>
    </form>
</div>
</body>
</html>