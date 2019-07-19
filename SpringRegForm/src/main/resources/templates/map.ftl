<#import "/spring.ftl" as spring/>
<#import "parts/common.ftl" as c>
<@c.common>
    <title>Directions Service</title>
    <style>
        /* Always set the map height explicitly to define the size of the div
         * element that contains the map. */
        #map {
            margin-left: 35%;
            width: 800px;
            height: 400px;
            border: 1px solid #999;
            border-radius: 10px;
        }

        /* Optional: Makes the sample page fill the window. */
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }

        /*label {
            font-size: 12px;
        }*/

        #floating-panel {
            position: absolute;
            /*top: 10px;
            left: 25%;*/
            /*z-index: 5;*/
            background-color: #fff;
            padding: 5px;
            border: 1px solid #999;
            text-align: center;
            font-family: 'Roboto', 'sans-serif';
            line-height: 30px;
            /*padding-left: 10px;*/
        }

        .result{
            border: 1px solid #999;
            background-color: #fff;
            padding: 5px;
            font-family: 'Roboto', 'sans-serif';
        }

        .form-group{
            position: absolute;
            border: 1px solid #999;
            background-color: #fff;
            width: 30%;
            border-radius: 5px;
            padding: 10px;
            margin: 10px;
        }

        .head{
            border: 1px solid #999999;
            padding: 10px;
            margin: 10px;
            background-color: #fff;
            border-radius: 5px;
        }
    </style>

    <#if price??>
        <div class="result">
            <p>${price}</p>
        </div>
    </#if>

    <div class="head">
        <h2><@spring.message "delivery.cost.message"/></h2>
        <span><@spring.message "info.message"/></span>
    </div>

    <div class="form-group" <#--id="floating-panel"-->>
        <form action="/weight" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <label for="start"><@spring.message "from.message"/></label>
            <input id="start" class="form-control" type="text">
            <label for="end"><@spring.message "where.message"/></label>
            <input id="end" class="form-control" type="text">
            <label for="weight"><@spring.message "weight.message"/></label>
            <input id="weight" class="form-control" type="text" name="weight"><br>
            <input id="calculate" class="btn btn-primary" type="submit" value="<@spring.message "calculate.button.message"/>">
        </form>
    </div>

    <div id="map"></div>

    <script>
        function initMap() {
            var directionsService = new google.maps.DirectionsService;
            var directionsDisplay = new google.maps.DirectionsRenderer;
            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 6,
                center: {lat: 49/*41.85*/, lng: 33/*-87.65*/}
            });
            directionsDisplay.setMap(map);

            var onChangeHandler = function () {
                calculateAndDisplayRoute(directionsService, directionsDisplay);

            };
            document.getElementById('calculate').addEventListener('click', onChangeHandler);
            //document.getElementById('start').addEventListener('change', onChangeHandler);
            //document.getElementById('end').addEventListener('change', onChangeHandler);
        }

        function calculateAndDisplayRoute(directionsService, directionsDisplay) {
            directionsService.route({
                origin: document.getElementById('start').value,
                destination: document.getElementById('end').value,
                travelMode: 'DRIVING'
            }, function (response, status) {
                if (status === 'OK') {
                    directionsDisplay.setDirections(response);

                    var directionsRoute = response.routes[0];
                    var int = parseInt(directionsRoute.legs[0].distance.text);
                    console.log(int);

                } else {
                    window.alert('Directions request failed due to ' + status);
                }
            });
        }
    </script>
    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC3TS8IXsmetWH4lbfjc3qDk7hd7VU5UE4&callback=initMap">
    </script>
</@c.common>