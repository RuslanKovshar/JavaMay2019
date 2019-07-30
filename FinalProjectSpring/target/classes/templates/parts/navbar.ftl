<#include "security.ftl">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">Delivery GIANT</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/"><@spring.message "home"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/calculate"><@spring.message "calculator.message"/></a>
            </li>
            <#if authenticated>
                <li class="nav-item">
                    <a class="nav-link" href="/account"><@spring.message "account"/></a>
                </li>
            </#if>
        </ul>

        <div class="dropdown my-2 my-lg-0">
            <a class="nav-link dropdown-toggle"
               href="#" id="navbarDropdown"
               role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <@spring.message "language.message"/>
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a id="en" class="dropdown-item" href="?lang=en"><@spring.message "lang.eng"/></a>
                <a class="dropdown-item" href="?lang=ua"><@spring.message "lang.ua"/></a>
            </div>
        </div>

        <#if authenticated>
            <div class="nav-link mx-4"><a href="/account" style="text-decoration: none;">${name}</a></div>
            <form action="/logout" class="form-inline my-2 my-lg-0" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <button class="btn btn-outline-warning my-2 my-sm-0" type="submit"><@spring.message "logout"/></button>
            </form>
        <#else>
            <form action="/account" class="form-inline my-2 my-lg-0">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><@spring.message "sign.in"/></button>
            </form>
        </#if>
    </div>
</nav>