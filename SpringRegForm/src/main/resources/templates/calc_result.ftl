<#import "parts/map.ftl" as m>
<#import "/spring.ftl" as spring/>
<@m.map>
    <div class="head">
        <h2><@spring.message "delivery.cost.message"/></h2>
        <span><@spring.message "delivery.warning.message"/></span>
    </div>

    <div class="form-group">
        <h2>
            <@spring.message "delivery.from.message"/> <i>${load.startPoint}</i>
            <@spring.message "delivery.to.message"/> <i>${load.endPoint}</i>
        </h2>
        <p><@spring.message "delivery.weight.message"/> ${load.weight}</p>
        <h3><@spring.message "estimated.delivery.cost.message"/> ${load.cost}</h3>
    </div>

    <script>
        window.onload = initMap;
        function initMap() {
            var directionsService = new google.maps.DirectionsService;
            var directionsDisplay = new google.maps.DirectionsRenderer;

            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 6,
                center: {lat: 49, lng: 33}
            });
            directionsDisplay.setMap(map);

            var start = "${load.startPoint}";
            var end = "${load.endPoint}";
            var onChangeHandler = function () {
                calculateAndDisplayRoute(directionsService, directionsDisplay,start,end);
            };
            onChangeHandler();
        }

        function calculateAndDisplayRoute(directionsService, directionsDisplay,start,end) {
            directionsService.route({
                origin: start,
                destination: end,
                travelMode: 'DRIVING'
            }, function (response, status) {
                if (status === 'OK') {
                    directionsDisplay.setDirections(response);
                } else {
                    window.alert('Directions request failed due to ' + status);
                }
            });
        }
    </script>

</@m.map>