<#import "/spring.ftl" as spring/>
<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
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

    <form action="/account/application">
        <button type="submit"
                class="btn btn-lg btn-dark btn-block mt-2"><@spring.message "create.application"/></button>
    </form>

    <form action="/account/shopping_basket">
        <button type="submit" class="btn btn-lg btn-dark btn-block mt-2"><@spring.message "shopping.basket"/></button>
    </form>

    <form action="/account/payment">
        <button type="submit" class="btn btn-lg btn-dark btn-block mt-2"><@spring.message "top.up.account"/></button>
    </form>


    <form action="/account/users/${user.id}/account_history">
        <button type="submit" class="btn btn-lg btn-dark btn-block mt-2"><@spring.message "account.history"/></button>
    </form>

    <#if admin>
        <form action="/account/all_users">
            <button type="submit"
                    class="btn btn-lg btn-dark btn-block mt-2"><@spring.message "show.all.users"/></button>
        </form>
    </#if>

    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit" class="btn btn-warning btn-lg btn-block mt-2"><@spring.message "logout"/>
        </button>
    </form>
</@c.common>