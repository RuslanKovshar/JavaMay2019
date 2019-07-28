<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
    <script type="text/javascript" src="../../js/angular.min.js"></script>
    <div class="container">
        <form class="form-signin" <#--action="/registration"--> method="post" name="form" autocomplete="off"
              ng-submit="form.$valid && sendForm(auth)">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
     <#--       <#if exist>
                <div class="alert alert-danger" role="alert"><@spring.message "registr.error"/></div>
                <div ng-app="uniqueEmail" ng-controller="uniqueEmailCtrl"></div>
                <script type="text/javascript" src="../js/unique_email.js"></script>
            </#if>
            <#if success>
                <div class="alert alert-success" role="alert"><@spring.message "registr.success"/></div>
            </#if>-->

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
                       class="form-control ${(passwordError??)?string('is-invalid','')}"
                       id="InputPassword"
                       placeholder="Password"
                       required
                       ng-model="auth.password"
                       name="password">
                <#if passwordError??>
                    <div class="invalid-feedback">${passwordError}</div>
                </#if>
            </div>

            <button type="submit" class="btn btn-dark btn-lg btn-block">
                <@spring.message "registr.button"/>
            </button>
        </form>

        <form class="form-signin" action="/login">
            <button type="submit" class="btn btn-success btn-lg btn-block"><@spring.message "back.button"/></button>
        </form>
    </div>

    <script type="text/javascript" src="../js/main.js"></script>
</@c.common>