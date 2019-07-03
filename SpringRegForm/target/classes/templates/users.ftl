<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>

<body ng-app="users_form" ng-controller="UserCtrl">
<div class="container">
    <table class="table table-striped" ng-model="users">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Email</th>
            <th scope="col">Roles</th>
            <th scope="col">Active</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="u in users">
            <td>{{u.id}}</td>
            <td>{{u.email}}</td>
            <td>{{u.authorities}}</td>
            <td>{{u.active}}</td>
        </tr>
        </tbody>
    </table>
    <form action="/">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit" class="btn btn-lg btn-primary btn-block">Back to main page</button>
    </form>
</div>
<script type="text/javascript" src="../js/angular.min.js"></script>
<script type="text/javascript" src="../js/users.js"></script>
</body>
</html>