<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>

    <div class="card my-2">
        <div class="card-body">
            <h2><@spring.message "delivery.cost.message"/></h2>
            <p class="card-text"><@spring.message "info.message"/></p>
        </div>
    </div>

    <div class="card my-2">
        <form action="/calculate" method="post">
            <div class="row">
                <div class="col-sm">
                    <label for="start"><@spring.message "from.message"/></label>
                    <input id="start" class="form-control" type="text" name="startPoint" autocomplete="off">
                </div>
                <div class="col-sm">
                    <label for="end"><@spring.message "where.message"/></label for="end">
                    <input id="end" class="form-control" type="text" name="endPoint" autocomplete="off"><br>
                </div>
            </div>
            <div class="row my-3">
                <div class="col-6 col-md-4">
                    <h3><@spring.message "actual.weight.message"/></h3>
                </div>
                <div class="col-12 col-md-8">
                    <input type="text" name="weight" class="form-control">
                </div>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <button class="btn btn-dark btn-lg m-2"><@spring.message "calculate.button.message"/></button>
        </form>
    </div>
</@c.common>