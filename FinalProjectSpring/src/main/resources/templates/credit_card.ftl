<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>

    <style>
        .credit-card-div span {
            padding-top: 10px;
        }

        .credit-card-div img {
            padding-top: 30px;
        }

        .credit-card-div .small-font {
            font-size: 9px;
        }

        .credit-card-div .pad-adjust {
            padding-top: 10px;
        }
    </style>

    <div class="row ">
        <div class="col-md-4 col-md-offset-4">
            <div class="credit-card-div">
                <div class="panel panel-default">
                    <div class="panel-heading">

                        <div class="row ">
                            <div class="col-md-12">
                                <input type="text" class="form-control" placeholder="Enter Card Number"/>
                            </div>
                        </div>

                        <div class="row ">
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <span class="help-block text-muted small-font"> Expiry Month</span>
                                <input type="text" class="form-control" placeholder="MM"/>
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <span class="help-block text-muted small-font"> Expiry Year</span>
                                <input type="text" class="form-control" placeholder="YY"/>
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <span class="help-block text-muted small-font"> CCV</span>
                                <input type="text" class="form-control" placeholder="CCV"/>
                            </div>
                            <div class="col-md-3 col-sm-3 col-xs-3">
                                <img src="http://bootstraptema.ru/snippets/form/2016/form-card/card.png"
                                     class="img-rounded"/>
                            </div>
                        </div>

                        <div class="row ">
                            <div class="col-md-12 pad-adjust">
                                <input type="text" class="form-control" placeholder="Name On The Card"/>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12 pad-adjust">
                                <form action="/account/payment/pay" method="post">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                    <div class="">
                                        <input type="text" class="form-control" placeholder="Amount of money"
                                               name="amount"/>
                                    </div>
                                    <input type="submit" class="btn btn-warning btn-block mt-3" value="PAY NOW"/>
                                </form>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12 pad-adjust">
                                <form action="/account">
                                    <input type="submit" class="btn btn-danger btn-block" value="CANCEL"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@c.common>