"use strict";

(function () {
    mapboxgl.accessToken = file;
    var map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/mapbox/streets-v9',
        zoom: 8,
        center: [-98.4916, 29.4252]
    });

    map.addControl(new mapboxgl.GeolocateControl({
        positionOptions: {
            enableHighAccuracy: true
        },
        trackUserLocation: true
    }));

    let lat = document.getElementById('lat').value;
    let lng = document.getElementById('lng').value;

    let marker = new mapboxgl.Marker();
    marker
        .setLngLat([lng, lat])
        .addTo(map)



})();



