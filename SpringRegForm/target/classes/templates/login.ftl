<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
<div class="container">
    <form class="form-signin" method="post" action="/login">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <h2 class="form-signin-heading"> <@spring.message "please.sign.in"/> </h2>
        <#if error>
        <div class="alert alert-danger" role="alert"> <@spring.message "bad.credentials"/> </div>
        </#if>
        <#if logout>
            <div class="alert alert-success" role="alert"><@spring.message "sign.out"/></div>
        </#if>
        <p>
            <label for="username" class="sr-only">Email</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Email" required autofocus>
        </p>
        <p>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit"> <@spring.message "sign.in"/></button>
    </form>
    <form class="form-signin" action="/registration">
        <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
        <h3><@spring.message "didnt.register"/></h3>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><@spring.message "create.account"/></button>
    </form>
</div>
</@c.common>