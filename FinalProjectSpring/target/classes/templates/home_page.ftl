<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
    <div class="alert alert-success">
        <h1><@spring.message "welcome"/></h1>
        <h5><@spring.message "lowcost"/></h5>
    </div>
    <h3 class="alert alert-info"><@spring.message "tariffs"/></h3>
    <h5 class="alert alert-primary"><@spring.message "wish"/></h5>
        <div class="row">
        <img src="../images/delivery.jpg" class="col">
        <table class="table table-bordered table-dark table-sm col" style="text-align: center">
            <thead class="thead-light">
            <tr>
                <th scope="col"><@spring.message "table.weight"/></th>
                <th scope="col"><@spring.message "delivery.cost.message"/></th>
            </tr>
            </thead>
            <tr>
                <td>0.5</td>
                <td>40</td>
            </tr>
            <tr>
                <td>1</td>
                <td>45</td>
            </tr>
            <tr>
                <td>2</td>
                <td>50</td>
            </tr>
            <tr>
                <td>5</td>
                <td>55</td>
            </tr>
            <tr>
                <td>10</td>
                <td>65</td>
            </tr>
            <tr>
                <td>20</td>
                <td>85</td>
            </tr>
            <tr>
                <td>30</td>
                <td>105</td>
            </tr>
            <tr>
                <td><@spring.message "surcharge"/></td>
                <td>4,5</td>
            </tr>
        </table>
        </div>
</@c.common>