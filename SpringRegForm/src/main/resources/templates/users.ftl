<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
    <body ng-app="users_form" ng-controller="UserCtrl">
    <table class="table table-striped" ng-model="users">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col"><@spring.message "table.email"/></th>
            <th scope="col"><@spring.message "table.role"/></th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="u in users">
            <td>{{u.id}}</td>
            <td>{{u.email}}</td>
            <td>{{u.authorities}}</td>
            <td>
                <form action="{{getUrl(u.id)}}">
                    <button type="submit" class="btn btn-dark"><@spring.message "view.order.history"/></button>
                </form>
            </td>
        </tr>
        </tbody>
    </table>
    <form action="/account">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit" class="btn btn-lg btn-warning btn-block"><@spring.message "back.button"/></button>
    </form>
    <script type="text/javascript" src="../js/angular.min.js"></script>
    <script type="text/javascript" src="../js/users.js"></script>
    </body>
</@c.common>