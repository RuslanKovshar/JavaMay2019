<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
    <script type="text/javascript" src="../../js/angular.min.js"></script>
    <form class="form-signin" method="post" name="form" autocomplete="off"
          ng-submit="form.$valid && sendForm(auth)">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <#if exist!false>
            <div class="alert alert-danger" role="alert"><@spring.message "registr.error"/></div>
            <div ng-app="uniqueEmail" ng-controller="uniqueEmailCtrl"></div>
            <script type="text/javascript" src="../js/unique_email.js"></script>
        </#if>
        <#if success!false>
            <div class="alert alert-success" role="alert"><@spring.message "registr.success"/></div>
        </#if>

        <div class="form-group">
            <label for="InputEmail"><@spring.message "email.msg.in.regform"/></label>
            <input type="email"
                   class="form-control ${(emailError??)?string('is-invalid','')}"
                   id="InputEmail"
                   placeholder="example@mail.com"
                   ng-model="auth.email"
                   name="email"
                   value="<#if userDTO??>${userDTO.email}</#if>">
            <#if emailError??>
                <div class="invalid-feedback">${emailError}</div>
            </#if>
        </div>

        <div class="form-group">
            <label for="InputPassword"><@spring.message "password.msg.in.regform"/></label>
            <input type="password"
                   class="form-control ${(passwordError??)?string('is-invalid','')}"
                   id="InputPassword"
                   placeholder="Password"
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

    <script type="text/javascript" src="../js/main.js"></script>
</@c.common>