<template>
  <div>
    <b-container class="bv-example-row">
  <b-row>
    <b-col>
      <b-col>시도</b-col>
      <b-col>
        <b-form-select id="sido" v-model="selectedSidoCode" size="sm" class="mt-3" @change="getGugunCode">
          <b-form-select-option v-for="(option, index) in sido" :key="index" v-bind:value="option.sidoCode">
            {{ option.sidoName }}
          </b-form-select-option>
        </b-form-select>
      </b-col>
    </b-col>
    <b-col>
      <b-col>구군</b-col>
      <b-col>
        <b-form-select id="gugun" v-model="selectedGugunCode" size="sm" class="mt-3" @change="getDongCode">
          <b-form-select-option v-for="(option, index) in gugun" :key="index" v-bind:value="option.gugunCode">
            {{ option.gugunName }}
          </b-form-select-option> 
        </b-form-select>
      </b-col>
    </b-col>
    <b-col>동
    <b-form-select id="dong" v-model="selectedDong" size="sm" class="mt-3" @change="getAptNameList">
      <b-form-select-option v-for="(option, index) in dong" :key="index" v-bind:value="option.dong">
        {{ option.dong }}
      </b-form-select-option>
    </b-form-select></b-col>
  </b-row>
</b-container>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex';
export default {
  name: 'SelectSigungu',
  data() {
    return {
      selectedSidoCode: '',
      selectedGugunCode: '',
      selectedDong: '',
    };
  },
  computed: {
    ...mapGetters(['sido', 'gugun', 'dong']),
  },
  created() {
    this.$store.dispatch('getSidoList');
  },
  methods: {
    ...mapActions(['getGugunList', 'getDongList', 'getAptsList']),
    getGugunCode() {
      this.getGugunList(this.selectedSidoCode);
    },
    getDongCode() {
      this.getDongList(this.selectedGugunCode);
    },
    getAptNameList() {
      this.$store.state.aptdeals = [];
      this.getAptsList(this.selectedDong);
    },
  },
};
</script>

<style></style>
