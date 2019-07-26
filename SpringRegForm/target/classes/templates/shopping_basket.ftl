<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
    <div ng-app="receipts_form" ng-controller="ReceiptsCtrl">
        <#if error>
            <div class="alert alert-danger" role="alert">
                <@spring.message "insufficient.funds.in.the.account"/>
            </div>
        </#if>
        <#if success>
            <div class="alert alert-success" role="alert">
                <@spring.message "receipt.successfully.paid"/>
            </div>
        </#if>
        <div ng-model="receipts">
            <div ng-repeat="r in receipts">
                <div class="card my-2">
                    <form action="{{getUrl($index)}}" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <#include "parts/card.ftl">
                        <button type="submit" class="btn btn-dark m-2"><@spring.message "pay"/></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="../js/angular.min.js"></script>
    <script type="text/javascript" src="../js/receipts.js"></script>
</@c.common>