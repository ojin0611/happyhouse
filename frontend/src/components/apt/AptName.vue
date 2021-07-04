<template>
  <h5>{{ this.aptdeals[0].aptName }}</h5>
</template>

<script>
import { mapState } from 'vuex';
export default {
  name: 'AptName',
  data() {
    return {};
  },
  computed: {
    ...mapState(['aptdeals']),
  },
};
</script>

<style></style>
