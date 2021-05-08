"use strict";

    var marker = new google.maps.Marker({
        position: [40.747688, -74.004142],
        title: "Hello World!"
    });

    var map = new google.maps.Map($('#map')[0], {
        zoom: 5,
        center: new google.maps.LatLng(40.747688, -74.004142),
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    google.maps.event.addListener(map, 'click', function myFunction(e) {
        marker.setPosition(e.latLng);
        marker.setMap(map);

        console.log("Lattid: ", e.latLng.lat());
        console.log("Long ", e.latLng.lng());
//
        document.getElementById("longitude").value = e.latLng.lng();
        //    document.getElementById("longitude").setAttribute('value',e.latLng.lng());
            document.getElementById("latitude").value = e.latLng.lat();
//            function myFunction(){
//            //document.forms['location']['longitude'].value = e.latLng.lng();
//                 document.getElementById("longitude").value = (e.latLng.lng()).toString();
//            //    document.getElementById("longitude").setAttribute('value',e.latLng.lng());
//                document.getElementById("latitude").value = "e.latLng.lat()";
//
//            }
    });


