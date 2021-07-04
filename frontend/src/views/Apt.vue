<template>
  <div>
    <b-container class="bv-example-row" fluid>
      <b-row class="mb-3 mt-3 ms-3 me-3">
        <b-col><select-sigungu /></b-col>
      </b-row>
      <b-row class="mb-3 mt-3 ml-3 mr-3">
        <b-col cols="7"><map-view /></b-col>
        <b-col cols="5">
          <b-row style="overflow-y: auto; height: 300px">
            <apt-list />
          </b-row>
          <b-row><apt-name/></b-row>
          <b-row >
            <apt-deal-info-list />
          </b-row>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import SelectSigungu from '@/components/apt/SelectSigungu.vue';
import AptList from '@/components/apt/AptList.vue';
import MapView from '@/components/apt/MapView.vue';
import AptDealInfoList from '../components/apt/AptDealInfoList.vue';
import AptName from '@/components/apt/AptName.vue'
export default {
  name: 'Apt',
  components: {
    SelectSigungu,
    AptList,
    MapView,
    AptDealInfoList,
    AptName,
  },
  data() {
    return {};
  },
  methods: {},
};
</script>

<style></style>
