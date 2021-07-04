<template>
  <b-container class="bv-example-row mt-3" fluid>
    <b-card
      overlay
      img-src="https://i.ibb.co/dDTXfXB/nv.jpg"
      img-alt="Card Image"
      text-variant="white"
      title=""
      sub-title=""
    >
      <b-card-text style="text-align: left; font-size: 50px"> 게시판 </b-card-text>
    </b-card>
    <b-button v-if="isCookie" class="mt-2 mb-2" style="float: right"
      ><router-link class="link" :to="{ name: 'ArticleWrite' }">글쓰기</router-link></b-button
    >
    <b-button v-if="!isCookie" v-on:click="show" class="mt-2 mb-2" style="float: right"
      ><router-link class="link" :to="{ name: 'ArticleWrite' }">글쓰기</router-link></b-button
    >
  </b-container>
</template>

<script>
export default {
  name: 'BoardNav',
  data() {
    return {
      isCookie: null,
    };
  },
  created() {
    this.isCookie = document.cookie;
  },
  methods: {
    show() {
      alert('로그인을 하고 이용해주세요');
      this.$router.push({ name: 'Login' });
      this.$router.go(); //새로고침 역할
    },
  },
};
</script>

<style scoped>
.link {
  text-decoration: none;
  color: inherit;
}
</style>
