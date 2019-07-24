<#import "/spring.ftl" as spring/>
<#import "parts/common.ftl" as c>
<@c.common>
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
            <td>${user.id}</td>
            <td>${user.email}</td>
            <td><#list user.authorities as r >${r}<#sep>, </#list></td>
        </tr>
        </tbody>
    </table>

    <form action="/main/application">
        <button type="submit" class="btn btn-lg btn-primary btn-block">Создать заявку</button>
    </form>

    <form action="/main/receipts">
        <button type="submit" class="btn btn-lg btn-primary btn-block">Просмотреть счета</button>
    </form>

    <form action="/main/payment">
        <button type="submit" class="btn btn-lg btn-primary btn-block">Пополнить счет</button>
    </form>

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
</@c.common>