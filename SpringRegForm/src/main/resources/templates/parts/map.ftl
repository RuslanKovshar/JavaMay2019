<#macro map>
    <#import "/spring.ftl" as spring/>
    <#import "common.ftl" as c>
    <@c.common>
        <link rel="stylesheet" href="../../css/calculator_styles.css">
        <title>Directions Service</title>
        <#nested >
        <div id="map"></div>
        <script>
            function initMap() {
                var directionsDisplay = new google.maps.DirectionsRenderer;

                var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 6,
                    center: {lat: 49, lng: 33}
                });
                directionsDisplay.setMap(map);
            }
       </script>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC3TS8IXsmetWH4lbfjc3qDk7hd7VU5UE4&callback=initMap">
        </script>
    </@c.common>
</#macro>