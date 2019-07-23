<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
    <div class="head">
        <h2><@spring.message "delivery.cost.message"/></h2>
        <span><@spring.message "delivery.warning.message"/></span>
    </div>

    <div class="form-group">
<#--        <h2>
            <@spring.message "delivery.from.message"/> <i>${load.startPoint}</i>
            <@spring.message "delivery.to.message"/> <i>${load.endPoint}</i>
        </h2>-->
        <p><@spring.message "delivery.weight.message"/> ${result.weight}</p>
        <h3><@spring.message "estimated.delivery.cost.message"/> ${result.cost}</h3>
    </div>
</@c.common>