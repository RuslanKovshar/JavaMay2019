<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
    <div class="container">
        <div class="form-group">
            <form id="form" action="/user_account" method="post">
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
                        <input id="calculate"
                               class="btn btn-lg btn-primary btn-block"
                               type="submit"
                               value="<@spring.message "calculate.button.message"/>">
                    </div>
                    <div class="col">
                        <a href="/main" class="btn btn-lg btn-primary btn-block" ><@spring.message "back.button"/></a>
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
<#--<script type="text/javascript">

    var load = function () {
        $('#form').attr({action: "/user_account/load"});
        $('.display').empty().append('<div class="cargo-container">' +
            '                                <div>' +
            '                                    <p class="title"><@spring.message "weight.message"/></p>' +
            '                                </div>' +
            '                                <div>' +
            '                                    <input id="weight" class="form-control" type="text"' +
            '                                                                       name="weight" autocomplete="off">' +
            '                                </div>' +
            '                            </div>' +
            '                            <br>' +
            '                            <div class="cargo-container">' +
            '                                <div>' +
            '                                    <p class="title"><@spring.message "dimensions.message"/></p>' +
            '                                </div>' +
            '                                <div class="g" style="display: flex;">' +
            '                                    <label for="long"></label><input id="long" class="form-control" type="text"' +
            '                                                                     placeholder="<@spring.message "length.message"/>" name="length">' +
            '                                    <label for="width"></label><input id="width" class="form-control" type="text"' +
            '                                                                      placeholder="<@spring.message "width.message"/>" name="width">' +
            '                                    <label for="height"></label><input id="height" class="form-control" type="text"' +
            '                                                                       placeholder="<@spring.message "height.message"/>"' +
            '                                                                       name="height">' +
            '                                </div>' +
            '                            </div>' +
            '                        </div>');
    };

    function quantity() {
        var quantityArrowMinus = $(".quantity-arrow-minus");
        var quantityArrowPlus = $(".quantity-arrow-plus");
        var quantityNum = $(".quantity-num");

        quantityArrowMinus.click(quantityMinus);
        quantityArrowPlus.click(quantityPlus);

        function quantityMinus() {
            if (quantityNum.val() > 1) {
                quantityNum.val(+quantityNum.val() - 1);
            }
        }

        function quantityPlus() {
            quantityNum.val(+quantityNum.val() + 1);
        }
    }

    var tires = function () {
        $('#form').attr({action: "/user_account/tires"});
        $('.display').empty().append(' <div class="tires">' +
            '                            <div class="cargo-container">' +
            '                                <div>' +
            '                                    <p class="title"><@spring.message "diameter.message"/></p>' +
            '                                </div>' +
            '                                <div>' +
            '                                    <div class="values" style="display: flex;"></div>' +
            '                                    <div id="slider"></div>' +
            '                                    <input type="hidden" id="amount" name="diameter"/>' +
            '                                </div>' +
            '                            </div>' +
            '                            <br>' +
            '                            <div class="cargo-container">' +
            '                                <div>' +
            '                                    <p class="title"><@spring.message "quantity.message"/></p>' +
            '                                </div>' +
            '                                <div class="quantity-block">' +
            '                                    <input class="quantity-arrow-minus btn btn-secondary" type="button" value="-">' +
            '                                    <input class="quantity-num form-control" type="number" min="1" value="4" name="quantity"/>' +
            '                                    <input class="quantity-arrow-plus btn btn-secondary" type="button" value="+">' +
            '                                </div>' +
            '                            </div>' +
            '                        </div>');

        $(".tires").each(function () {
            var sliderValue = [13, 14, 15, 16, 17, 17.5, 18, 19, 19.5, 20, 21, 22, 22.5];

            $(function () {
                $("#slider").slider({
                    value: 13,
                    min: 13,
                    max: 22.5,
                    step: 0.5,
                    range: "min",
                    animate: "fast",
                    slide: function (event, ui) {
                        if (sliderValue.indexOf(ui.value) === -1) return false;
                        $("#amount").val(ui.value)
                    }
                });

                $("#amount").val($("#slider").slider("value"));
                quantity();

            });

            for (var i = 0; i < sliderValue.length; i++) {
                var width = (sliderValue[i + 1] - sliderValue[i]) * 10.5263;
                $(".values").append($('<p>R' + sliderValue[i] + '</p>').css({
                    "width": width + "%",
                    "font-size": "12px"
                }));
            }
        });
    };

    var documents = function () {
        $('#form').attr({action: "/user_account/documents"});
        $('.display').empty().append('<div class="cargo-container">' +
            '                                <div>' +
            '                                    <p class="title"><@spring.message "actual.weight.message"/></p>' +
            '                                </div>' +
            '                                <div>' +
            '                                    <select name="weight" id="weight"  class="form-control">' +
            '                                        <option disabled><@spring.message "choose.weight.message"/></option>' +
            '                                        <option value="0.1">0.1</option>' +
            '                                        <option value="0.5">0.5</option>' +
            '                                        <option value="1">1</option>' +
            '                                    </select>' +
            '                                </div>' +
            '                            </div>');
    };

    var pallets = function () {
        $('#form').attr({action: "/user_account/pallets"});
        $('.display').empty().append('<div class="pallets">' +
            '                            <div class="cargo-container">' +
            '                                <div>' +
            '                                    <p class="title"><@spring.message "size.message"/></p>' +
            '                                </div>' +
            '                                <div>' +
            '                                    <input class="btn btn-secondary pallet-small" type="button" value="80x60">' +
            '                                    <input class="btn btn-secondary pallet-normal" type="button" value="120x80">' +
            '                                    <input class="btn btn-secondary pallet-average" type="button" value="120x100">' +
            '                                    <input class="btn btn-secondary pallet-big" type="button" value="120x120">' +
            '                                    <input class="pallet-type" type="hidden" name="type">'+
            '                                </div>' +
            '                            </div>' +
            '                            <div class="cargo-container">' +
            '                                <div>' +
            '                                    <p class="title"><@spring.message "quantity.message"/></p>' +
            '                                </div>' +
            '                                <div class="quantity-block">' +
            '                                    <input class="quantity-arrow-minus btn btn-secondary" type="button" value="-">' +
            '                                    <input class="quantity-num form-control" type="number" min="1" value="4" name="quantity"/>' +
            '                                    <input class="quantity-arrow-plus btn btn-secondary" type="button" value="+">' +
            '                                </div>' +
            '                            </div>' +
            '                        </div>');

        $('.pallets').each(function () {
            $('.pallet-small').click(function () {
                $('.pallet-type').val("small");
            });
            $('.pallet-normal').click(function () {
                $('.pallet-type').val("normal");
            });
            $('.pallet-average').click(function () {
                $('.pallet-type').val("average");
            });
            $('.pallet-big').click(function () {
                $('.pallet-type').val("big");
            });

            quantity();
        });
    };

    window.onload = load;
    document.getElementById('pallets').addEventListener('click', pallets);
    document.getElementById('documents').addEventListener('click', documents);
    document.getElementById('tires').addEventListener('click', tires);
    document.getElementById('load').addEventListener('click', load);
</script>-->
</@c.common>