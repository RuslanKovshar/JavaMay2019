<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
    <div class="container">
        <div class="form-group">
            <form id="form" action="/account/application" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="delivery_points">

                    <div>
                        <h2><@spring.message "delivery.address.message"/></h2>
                    </div>

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
                </div>

                <hr>
                <div class="cargo-container">
                    <div class="row my-3">
                        <div class="col-6 col-md-4">
                            <h3 class="title"><@spring.message "type.message"/></h3>
                        </div>
                        <div class="col-12 col-md-8">
                            <div class="row">
                                <div class="col">
                                    <input id="load" class="btn btn-secondary btn-block" type="button"
                                           value="<@spring.message "load.message"/>">
                                </div>
                                <div class="col">
                                    <input id="tires" class="btn btn-secondary btn-block" type="button"
                                           value="<@spring.message "tires.message"/>">
                                </div>
                                <div class="col">
                                    <input id="documents" class="btn btn-secondary btn-block" type="button"
                                           value="<@spring.message "documents.message"/>">
                                </div>
                                <div class="col">
                                    <input id="pallets" class="btn btn-secondary btn-block" type="button"
                                           value="<@spring.message "pallets.message"/>">
                                </div>
                                <input id="type" type="hidden" value="Load" name="type">
                            </div>
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
                    <div class="row my-3">
                        <div class="col-6 col-md-4">
                            <h3><@spring.message "date.message"/></h3>
                        </div>
                        <div class="col-12 col-md-8">
                            <input id="date-picker" class="form-group" type="date" name="localDate" min="" max="">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <button class="btn btn-lg btn-dark btn-block"><@spring.message "calculate.button.message"/></button>
                    </div>
                    <div class="col">
                        <a href="/account" class="btn btn-lg btn-warning btn-block" ><@spring.message "back.button"/></a>
                    </div>
                </div>
            </form>
        </div>
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

        $('#load').click(function () {
            $('#type').val("Load");
        });
        $('#tires').click(function () {
            $('#type').val("Tires");
        });
        $('#documents').click(function () {
            $('#type').val("Documents");
        });
        $('#pallets').click(function () {
            $('#type').val("Pallets");
        });

    </script>
</@c.common>