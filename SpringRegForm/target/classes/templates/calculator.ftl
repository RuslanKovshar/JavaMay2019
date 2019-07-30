<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>

        <div class="alert alert-info">
            <h2><@spring.message "delivery.cost.message"/></h2>
            <p><@spring.message "info.message"/></p>
        </div>

    <div class="card my-2 p-3">
        <form action="/calculate" method="post">
            <div class="row my-3">
                <div class="col-6 col-md-4">
                    <h2><@spring.message "delivery.address.message"/></h2>
                </div>
                <div class="col-12 col-md-8">
                    <input class="form-control ${(deliveryAddressError??)?string('is-invalid','')}"
                           type="text"
                           placeholder="Address"
                           name="deliveryAddress" value="<#if applicationDTO??>${applicationDTO.deliveryAddress}</#if>">
                    <#if deliveryAddressError??>
                        <div class="invalid-feedback">${deliveryAddressError}</div>
                    </#if>
                </div>
            </div>
            <div class="row my-3">
                <div class="col-6 col-md-4">
                    <h3><@spring.message "actual.weight.message"/></h3>
                </div>
                <div class="col-12 col-md-8">
                    <input type="text" name="weight"
                           class="form-control ${(weightError??)?string('is-invalid','')}"
                           placeholder="weight"
                           value="<#if applicationDTO??>${applicationDTO.weight!}</#if>">
                    <#if weightError??>
                        <div class="invalid-feedback">${weightError}</div>
                    </#if>
                </div>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button class="btn btn-dark btn-lg m-2"><@spring.message "calculate.button.message"/></button>
        </form>
    </div>
</@c.common>