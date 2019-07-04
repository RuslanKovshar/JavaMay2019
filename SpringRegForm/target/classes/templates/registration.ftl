<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
 <#--ng-app="registrationForm" ng-controller="AppCtrl"-->
<div class="container">
    <form class="form-signin" <#--action="/registration"--> method="post" name="form" autocomplete="off" novalidate ng-submit="form.$valid && sendForm(auth)">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <#if exist>
            <div class="alert alert-danger" role="alert"><@spring.message "registr.error"/></div>
        </#if>
        <#if success>
            <div class="alert alert-success" role="alert"><@spring.message "registr.success"/></div>
        </#if>
        <div class="form-group">
            <label for="InputEmail"><@spring.message "email.msg.in.regform"/></label>
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
            <label for="InputPassword"><@spring.message "password.msg.in.regform"/></label>
            <input type="password"
                   class="form-control"
                   id="InputPassword"
                   placeholder="Password"
                   required
                   ng-model="auth.password"
            name="password">
        </div>

        <button type="submit" class="btn btn-primary btn-lg btn-block"  style="margin-top:30px" ng-disabled="form.$invalid">
            <@spring.message "registr.button"/>
        </button>
    </form>

    <form class="form-signin" action="/login">
    <#--    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
        <button type="submit" class="btn btn-secondary btn-lg btn-block"><@spring.message "back.button"/></button>
    </form>
</div>

<script type="text/javascript" src="../js/angular.min.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
</@c.common>