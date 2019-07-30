<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
    <div class="alert alert-info">
        <h2><@spring.message "delivery.cost.message"/></h2>
        <span><@spring.message "delivery.warning.message"/></span>
    </div>

    <#if application??>
        <div class="card p-3">
            <h4><@spring.message "delivery.weight.message"/> ${application.weight}</h4>
            <h4><@spring.message "delivery.address.message"/>: ${application.deliveryAddress}</h4>
            <h3><@spring.message "estimated.delivery.cost.message"/> ${cost}</h3>
        </div>
    </#if>
</@c.common>