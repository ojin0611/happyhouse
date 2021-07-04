<template>
  <b-table-simple
    hover
    small
    caption-top
    responsive
    style="position: relative; overflow-y: auto; height: 350px"
  >
    <b-thead head-variant="dark" style="position: sticky">
      <b-tr>
        <b-th>실거래가 (만원)</b-th>
        <b-th>면적 (m²)</b-th>
        <b-th>거래일자</b-th>
      </b-tr>
    </b-thead>
    <b-tbody>
      <apt-deal-info-list-item
        v-for="(aptdeal, index) in aptdeals"
        :key="index"
        :aptdeal="aptdeal"
      />
    </b-tbody>
  </b-table-simple>
</template>

<script>
import { mapState } from 'vuex';
import AptDealInfoListItem from '@/components/apt/AptDealInfoListItem.vue';

export default {
  name: 'AptDealInfoList',
  components: {
    AptDealInfoListItem,
  },
  computed: {
    ...mapState(['aptdeals']),
  },
};
</script>

<style></style>
