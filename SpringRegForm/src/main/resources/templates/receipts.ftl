<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
    <div ng-app="receipts_form" ng-controller="ReceiptsCtrl">
        <#if error>
            <div>
                <h3>error</h3>
            </div>
        </#if>
        <#if success>
            <div>
                <h3>success</h3>
            </div>
        </#if>
        <table class="table table-striped" ng-model="receipts">
            <thead>
            <tr>
                <th scope="col">№</th>
                <th scope="col">Weight</th>
                <th scope="col">Type</th>
                <th scope="col">Date</th>
                <th scope="col">Cost</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="r in receipts">
                <td>{{$index}}</td>
                <td>{{r.application.weight}}</td>
                <td>{{r.application.type}}</td>
                <td>{{r.application.localDate}}</td>
                <td>{{r.cost}}</td>
                <td>
                    <form id="buy{{$index}}" action="{{getIframeSrc($index)}}" method="post">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <input id="test" type="hidden" value="/main/save/{{$index}}">
                        <button type="submit">Оплатить</button>
                    </form>
                    <script type="text/javascript">
                        $(function () {
                            $('#buy').attr('action',"/main/save/" + $('#test').val());
                        })
                    </script>
                </td>
            </tr>
            </tbody>
        </table>

    </div>


    <script type="text/javascript" src="../js/angular.min.js"></script>
    <script type="text/javascript" src="../js/receipts.js"></script>
</@c.common>