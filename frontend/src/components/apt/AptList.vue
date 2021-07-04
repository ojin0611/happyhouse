<template>
  <b-table-simple hover small caption-top responsive>
    <b-thead head-variant="dark">
      <b-tr>
        <b-th>아파트 이름</b-th>
        <b-th>건축 연도</b-th>
      </b-tr>
    </b-thead>
    <b-tbody
      ><!-- v-show="isShow" -->
      <apt-list-item v-for="(apt, index) in apts" :key="index" :apt="apt" />
    </b-tbody>
  </b-table-simple>
</template>

<script>
import { mapState } from 'vuex';
import AptListItem from '@/components/apt/AptListItem.vue';
export default {
  name: 'AptList',
  data() {
    return {};
  },
  components: {
    AptListItem,
  },
  created: {
    apts: [],
    // isShow: false
  },
  computed: {
    ...mapState(['apts']),
    // isShow: true
  },
};
</script>

<style></style>
