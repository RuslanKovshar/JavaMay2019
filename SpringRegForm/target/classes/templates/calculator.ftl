<#import "parts/map.ftl" as m>
<#import "/spring.ftl" as spring/>
<@m.map>
    <div class="head">
        <h2><@spring.message "delivery.cost.message"/></h2>
        <span><@spring.message "info.message"/></span>
    </div>

    <div class="form-group" <#--id="floating-panel"-->>
        <form action="/calculate" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <label for="start"><@spring.message "from.message"/></label>
            <input id="start" class="form-control" type="text" name="startPoint" autocomplete="off">
            <label for="end"><@spring.message "where.message"/></label>
            <input id="end" class="form-control" type="text" name="endPoint" autocomplete="off">
            <label for="weight"><@spring.message "weight.message"/></label>
            <input id="weight" class="form-control" type="text" name="weight" autocomplete="off"><br>
            <input id="calculate" class="btn btn-primary" type="submit"
                   value="<@spring.message "calculate.button.message"/>">
        </form>
    </div>
</@m.map>