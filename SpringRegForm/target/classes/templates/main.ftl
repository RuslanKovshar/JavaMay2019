<#import "/spring.ftl" as spring/>
<#import "parts/common.ftl" as c>
<@c.common>
<div class="container" style="width: 40%;">
    <h2><@spring.message "greeting"/></h2>
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
            <button type="submit" class="btn btn-lg btn-primary btn-block"><@spring.message "show.all.users"/></button>
            <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
        </form>
    </#if>

    <br>
    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit" class="btn btn-secondary btn-lg btn-block"><@spring.message "logout"/>
        </button>
    </form>
</div>
</@c.common>