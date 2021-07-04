<template>
  <b-tr @click="chooseApt">
    <b-td>{{ this.apt.aptName }}</b-td>
    <b-td>{{ this.apt.buildYear }}</b-td>
  </b-tr>
</template>

<script>
import { mapActions } from 'vuex';

export default {
  name: 'AptListItem',
  data() {
    return {};
  },
  props: {
    apt: Object,
  },
  methods: {
    ...mapActions(['selectApt']),
    chooseApt() {
      this.selectApt(this.apt.aptName);
    },
  },
};
</script>

<style></style>
