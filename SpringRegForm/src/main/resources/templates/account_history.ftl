<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
    <div ng-app="receiptsHistory_form" ng-controller="ReceiptsHistoryCtrl"
         ng-init="init('/account/users/${id}/receipts_history')">
        <div ng-model="payedReceipts">
            <div ng-repeat="r in payedReceipts">
                <div class="card my-2">
                    <#include "parts/card.ftl">
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="../../../js/angular.min.js"></script>
    <script type="text/javascript" src="../../../js/account_history.js"></script>
</@c.common>