<template>
  <div class="hello">
    <div class="map-section">
      <gmap-map
        ref="mainMap"
        :center="startLocation"
        :zoom="zoom"
        map-type-id="roadmap"
        style="width: 100%; height: 100%"
        :options="{
          zoomControl: true,
          scaleControl: false,
          mapTypeControl: false,
          fullscreenControl: false,
          streetViewControl: false,
          disableDefaultUi: false,
        }"
        ><div v-if="apts.length > 0 && apts != []">
          <gmap-marker
            v-for="(item, key) in apts"
            :key="key"
            :position="getPosition(item)"
            :clickable="true"
            :title="item.aptName"
            :icon="markerOptions"
            :item="item"
            @mouseover="openInfoWindow(key)"
            @mouseout="closeInfoWindow"
            @click="chooseApt(item)"
          >
            <gmap-info-window
              :opened="window_open && focusedKey == key"
              :position="getPosition(item)"
              :key="key"
            >
              <strong style="font-size: 18px; color: black" v-html="item.aptName"></strong>
            </gmap-info-window>
          </gmap-marker>
        </div>
      </gmap-map>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';
export default {
  name: 'Map',
  data: function () {
    let mapMarker =
      'data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMjMiIGhlaWdodD0iMjkiIHZpZXdCb3g9IjAgMCAyMyAyOSIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4NCjxwYXRoIGQ9Ik0yMyAxMS41QzIzIDIxLjUgMTEuNSAyOC41IDExLjUgMjguNUMxMS41IDI4LjUgMCAyMS41IDAgMTEuNUMwIDUuMTQ4NzMgNS4xNDg3MyAwIDExLjUgMEMxNy44NTEzIDAgMjMgNS4xNDg3MyAyMyAxMS41WiIgZmlsbD0iI0M3MDYyOSIvPg0KPGNpcmNsZSBjeD0iMTEuNSIgY3k9IjExLjUiIHI9IjUuNSIgZmlsbD0iIzgxMDAxNyIvPg0KPC9zdmc+DQo=';
    let mapMarkerActive =
      'data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMjMiIGhlaWdodD0iMjkiIHZpZXdCb3g9IjAgMCAyMyAyOSIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4NCjxwYXRoIGQ9Ik0yMyAxMS41QzIzIDIxLjUgMTEuNSAyOC41IDExLjUgMjguNUMxMS41IDI4LjUgMCAyMS41IDAgMTEuNUMwIDUuMTQ4NzMgNS4xNDg3MyAwIDExLjUgMEMxNy44NTEzIDAgMjMgNS4xNDg3MyAyMyAxMS41WiIgZmlsbD0iIzMzMzMzMyIvPg0KPGNpcmNsZSBjeD0iMTEuNSIgY3k9IjExLjUiIHI9IjUuNSIgZmlsbD0iYmxhY2siLz4NCjwvc3ZnPg0K';
    return {
      zoom: 14,
      mapMarker,
      mapMarkerActive,
      startLocation: {
        lat: 37.5665734,
        lng: 126.978179,
      },
      selectedCity: null,
      selectedLocation: null,
      infoPosition: null,
      infoOpened: false,
      infoCurrentKey: null,
      markerOptions: {
        url: mapMarker,
      },
      window_open: false,
      item: Object,
      focusedKey: 0,
      key: 0,
    };
  },
  computed: {
    ...mapState(['apts']),
  },
  watch: {
    apts: {
      handler: function () {
        (this.startLocation.lat = parseFloat(this.apts[0].lat)),
          (this.startLocation.lng = parseFloat(this.apts[0].lng));
      },
    },
  },
  methods: {
    ...mapActions(['selectApt']),
    setCenter() {
      if (this.apts.length > 0 && this.apts != []) {
        this.startLocation = {
          lat: parseFloat(this.apts[0].lat),
          lng: parseFloat(this.apts[0].lng),
        };
      }
    },
    getPosition: function (marker) {
      return {
        lat: parseFloat(marker.lat),
        lng: parseFloat(marker.lng),
      };
    },
    chooseApt: function (marker) {
      this.selectApt(marker.aptName);
    },
    openInfoWindow: function (Key) {
      this.window_open = true;
      this.focusedKey = Key;
    },
    closeInfoWindow() {
      this.window_open = false;
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.map-section {
  height: 95vh;
  position: relative;
  overflow: hidden;
}
.map-info-window {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  background: #fff;
  padding: 15px 20px 10px;
}

.map-info-window-slide-leave-active,
.map-info-window-slide-enter-active {
  transition: 0.5s;
}
.map-info-window-slide-enter {
  transform: translate(0, -100%);
}
.map-info-window-slide-leave-to {
  transform: translate(0, -100%);
}
.city-info > div {
  margin-bottom: 10px;
}
.map-btn-close-holder {
  margin-top: 10px;
}
</style>
