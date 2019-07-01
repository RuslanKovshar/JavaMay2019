<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
</head>

<body ng-app="users_form" ng-controller="UserCtrl">

<!--<table ng-model="users">
    <tr>
        <th>Id</th>
        <th>Email</th>
        <th>Password</th>
    </tr>
    <tr ng-repeat="u in users">
        <td>{{u.id}}</td>
        <td>{{u.email}}</td>
        <td>{{u.password}}</td>
    </tr>
</table>-->

<table class="table table-striped" ng-model="users">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Email</th>
        <th scope="col">Password</th>
    </tr>
    </thead>
    <tbody>
    <tr ng-repeat="u in users">
        <td>{{u.id}}</td>
        <td>{{u.email}}</td>
        <td>{{u.password}}</td>
    </tr>
    </tbody>
</table>

<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/users.js"></script>
</body>
</html>