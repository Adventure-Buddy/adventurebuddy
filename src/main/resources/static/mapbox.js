"use strict";

(function () {
    mapboxgl.accessToken = MAPBOX_KEY;
    var map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/mapbox/streets-v9',
        zoom: 8,
        center: [-98.4916, 29.4252]
    });

    console.log("hello");
})();



