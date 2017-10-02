

<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>View map</title>
    <style>
    #map {
        height: 100%;
    }

    html, body {
        height: 100%;
        margin: 0;
        padding: 0;
    }
    </style>

</head>
<body>

<div id="map"></div>
<script>
    var locations = [
        ['La Villa d\'Este', 43.697833 , 7.267896999999948,5],
        ['LA HAVANE', 43.6961903 , 7.26997259999996,4],
        ['Buffalo Grill Nice', 43.695967 , 7.261056000000053, 3],
        ['Restaurant JAN',43.6997761 , 7.284809999999993, 2],
        ['Meat Bar', 43.6954331 , 7.254003499999953 ,1]
    ];
    var map;

    function initMap() {
        var nice ={lat: 43.700000, lng: 7.250000},
            map = new google.maps.Map(document.getElementById('map'), {
                center: nice ,
                zoom: 8,
                mapTypeId: google.maps.MapTypeId.ROADMAP

            });
        var infowindow = new google.maps.InfoWindow();
        var marker, i;
        for (i = 0; i < locations.length; i++){
            marker = new google.maps.Marker({
                position: new google.maps.LatLng(locations[i][1], locations[i][2]),
                map: map
            });

            google.maps.event.addListener(marker, 'click', (function(marker, i) {
                return function() {
                    infowindow.setContent(locations[i][0]);
                    infowindow.open(map, marker);
                }
            })(marker, i));
        }

    }
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAlIWi8Sg7yWJqLmPDgSktaC6wQ7tOKscw&callback=initMap"
        async defer></script>

</body>
</html>
