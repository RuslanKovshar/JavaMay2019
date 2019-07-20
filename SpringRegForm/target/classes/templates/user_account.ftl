<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>

    <style>
        .delivery_points {
            display: grid;
            grid-template-columns: 1fr 1fr 1fr;
        }

        .weight_div {
            display: grid;
            grid-template-columns: 1fr 2fr;
        }

        .gabarit {
            display: grid;
            grid-template-columns: 1fr 2fr;
        }



        .container {
            width: 40%;
        }

        .nav a {
            color: black;
        }


    </style>
    <div class="container">
        <div class="form-group">
            <form action="/user_account" method="post">

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                <div class="delivery_points">
                    <div>
                        <h2>Маршрут</h2>
                    </div>
                    <div>
                        <label for="start"><@spring.message "from.message"/></label>
                        <input id="start" class="form-control" type="text" name="startPoint" autocomplete="off">
                    </div>
                    <div>
                        <label for="end"><@spring.message "where.message"/></label for="end">
                        <input id="end" class="form-control" type="text" name="endPoint" autocomplete="off"><br>
                    </div>
                </div>
                <hr>

                <div class="con">
                    <h2>Dynamic Tabs</h2>
                    <ul class="nav <#--nav-pills-->nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
                        <li><a data-toggle="tab" href="#menu1">Menu 1</a></li>
                        <li><a data-toggle="tab" href="#menu2">Menu 2</a></li>
                        <li><a data-toggle="tab" href="#menu3">Menu 3</a></li>
                    </ul>

                    <div class="tab-content">
                        <div id="home" class="tab-pane fade in active">
                            <h3>Load</h3>
                            <div class="weight_div">
                                <div>
                                    <h2>weight<#--<@spring.message "weight.message"/>--></h2>
                                </div>
                                <div>
                                    <label for="weight"></label><input id="weight" class="form-control" type="text" name="weight" autocomplete="off">
                                </div>
                            </div>
                            <div class="gabarit">
                                <div>
                                    <p style="font-size: 22px;">Габариты</p>
                                </div>
                                <div class="g" style="display: flex;">
                                    <label for="height"></label><input id="height" class="form-control" type="text" placeholder="height"
                                                                       name="height">
                                    <label for="width"></label><input id="width" class="form-control" type="text" placeholder="width" name="width">
                                    <label for="long"></label><input id="long" class="form-control" type="text" placeholder="long" name="long">
                                </div>
                            </div>
                        </div>

                        <div id="menu1" class="tab-pane fade">
                            <h3>Menu 1</h3>
                            <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                                commodo
                                consequat.</p>
                        </div>

                        <div id="menu2" class="tab-pane fade">
                            <h3>Menu 2</h3>
                            <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque
                                laudantium,
                                totam rem aperiam.</p>
                        </div>
                        <div id="menu3" class="tab-pane fade">
                            <h3>Menu 3</h3>
                            <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt
                                explicabo.</p>
                        </div>
                    </div>
                </div>


                <input id="calculate"
                       class="btn btn-primary"
                       type="submit"
                       value="<@spring.message "calculate.button.message"/>">


            </form>
        </div>

    </div>
</@c.common>