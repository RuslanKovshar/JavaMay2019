<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
    <div class="card p-4">
        <form id="form" action="/account/application" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <div class="row my-3">
                <div class="col-6 col-md-4">
                    <h2><@spring.message "delivery.address.message"/></h2>
                </div>
                <div class="col-12 col-md-8">
                    <input class="form-control ${(deliveryAddressError??)?string('is-invalid','')}" type="text"
                           name="deliveryAddress" value="<#if applicationDTO??>${applicationDTO.deliveryAddress}</#if>">
                    <#if deliveryAddressError??>
                        <div class="invalid-feedback">${deliveryAddressError}</div>
                    </#if>
                </div>
            </div>

            <hr>
            <div class="cargo-container">
                <div class="row my-3">
                    <div class="col-6 col-md-4">
                        <h3 class="title"><@spring.message "type.message"/></h3>
                    </div>
                    <div class="col-12 col-md-8">
                        <select name="type" class="form-control ${(typeError??)?string('is-invalid','')}">
                            <option disabled selected><@spring.message "choose.type"/></option>
                            <option value="Load"><@spring.message "load.message"/></option>
                            <option value="Tires"><@spring.message "tires.message"/></option>
                            <option value="Documents"><@spring.message "documents.message"/></option>
                            <option value="Pallets"><@spring.message "pallets.message"/></option>
                        </select>
                        <#if typeError??>
                            <div class="invalid-feedback">${typeError}</div>
                        </#if>
                    </div>
                </div>
                <div class="row my-3">
                    <div class="col-6 col-md-4">
                        <h3><@spring.message "actual.weight.message"/></h3>
                    </div>
                    <div class="col-12 col-md-8">
                        <input type="text" name="weight"
                               pattern="^([0-9]*[.])?[0-9]+$"
                               title="Numbers only"
                               class="form-control ${(weightError??)?string('is-invalid','')}"
                               value="<#if applicationDTO??>${applicationDTO.weight!}</#if>">
                        <#if weightError??>
                            <div class="invalid-feedback">${weightError}</div>
                        </#if>
                    </div>

                </div>
                <div class="row my-3">
                    <div class="col-6 col-md-4">
                        <h3><@spring.message "date.message"/></h3>
                    </div>
                    <div class="col-12 col-md-8">
                        <input id="date-picker" class="form-control ${(localDateError??)?string('is-invalid','')}"
                               type="date" name="localDate" min=""
                               value="<#if applicationDTO??>${applicationDTO.localDate!}</#if>">
                        <#if localDateError??>
                            <div class="invalid-feedback">${localDateError}</div>
                        </#if>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <button class="btn btn-lg btn-dark btn-block"><@spring.message "calculate.button.message"/></button>
                </div>
                <div class="col">
                    <a href="/account" class="btn btn-lg btn-warning btn-block"><@spring.message "back.button"/></a>
                </div>
            </div>
        </form>
    </div>
    <script type="text/javascript">
        $(function () {
            var date = new Date();
            var year = date.getFullYear();
            var tempMonth = (date.getMonth() + 1);
            var month = tempMonth < 10 ? '0' + tempMonth : tempMonth;
            var tempDay = date.getDate() + 1; // +1 to make tomorrow
            var day = tempDay < 10 ? '0' + tempDay : tempDay;
            var min = year + '-' + month + '-' + day;
            $('#date-picker').attr('min', min);
        });
    </script>
</@c.common>