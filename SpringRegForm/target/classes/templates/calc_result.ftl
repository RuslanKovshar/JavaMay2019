<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
    <div class="head">
        <h2><@spring.message "delivery.cost.message"/></h2>
        <span><@spring.message "delivery.warning.message"/></span>
    </div>

    <div class="form-group">
        <p><@spring.message "delivery.weight.message"/> ${result.weight}</p>
        <h3><@spring.message "estimated.delivery.cost.message"/> ${result.cost}</h3>
    </div>
</@c.common>