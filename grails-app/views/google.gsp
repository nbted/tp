<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>Google Maps Multiple Markers</title>
    <script src="http://maps.google.com/maps/api/js?sensor=false"
            type="text/javascript"></script>
</head>
<body>
<div id="map" style="width: 500px; height: 400px;"></div>

<script type="text/javascript">
    var locations = [
        ['La Villa d\'Este', 43.697833 , 7.267896999999948,5],
        ['LA HAVANE', 43.6961903 , 7.26997259999996,4],
        ['Buffalo Grill Nice', 43.695967 , 7.261056000000053, 3],
        ['Restaurant JAN',43.6997761 , 7.284809999999993, 2],
        ['Meat Bar', 43.6954331 , 7.254003499999953 ,1]
    ];

    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 10,
        center: new google.maps.LatLng(43.700000, 7.250000),
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;

    for (i = 0; i < locations.length; i++) {
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
</script>
</body>
</html>












<table>
    <thead>
    <tr>
        <th>Longitude</th>
        <th>Lattitude</th>
        <th>Ville</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${customLocalisationList}" var="MyLocalisation">
        <tr>
            <td><a href="/Localisation/show/${MyLocalisation.id}">${MyLocalisation.longitude}</a></td>
            <td><a href="/Localisation/show/${MyLocalisation.id}">${MyLocalisation.lattitude}</a></td>
            <td><a href="/Localisation/show/${MyLocalisation.id}">${MyLocalisation.country}</a></td>
        </tr>
    </g:each>
    </tbody>
</table>

