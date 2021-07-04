<template>
  <b-tr>
    <b-td>{{ this.aptdeal.dealAmount }}</b-td>
    <b-td>{{ this.aptdeal.area }}</b-td>
    <b-td>{{this.aptdeal.dealYear}}년 {{this.aptdeal.dealMonth}}월 {{this.aptdeal.dealDay}}일</b-td>
  </b-tr>
</template>

<script>
export default {
  name: 'AptDealInfoListItem',
  data() {
    return {};
  },
  props: {
    aptdeal: Object,
  },
};
</script>

<style></style>
