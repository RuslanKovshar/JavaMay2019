<#import "parts/common.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.common>
    <title>Directions Service</title>
    <style>
        /* Always set the map height explicitly to define the size of the div
         * element that contains the map. */
        #map {
            width: auto;
            height: 60%;
            margin-left: 20%;
        }

        /* Optional: Makes the sample page fill the window. */
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }

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
    </style>

    <div id="floating-panel">
        <b>Start: </b>
        <#--<select id="start">
            <option value="Kyiv">Kyiv</option>
            <option value="Konotop">Konotop</option>
        </select>-->
        <input id="start" type="text">
        <br>
        <br>
        <b>End: </b>
        <#--<select id="end">
            <option value="Kyiv">Kyiv</option>
            <option value="Konotop">Konotop</option>
        </select>-->
        <input id="end" type="text">
        <br><br>
        <input id="calculate" type="submit" value="Calculate">
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