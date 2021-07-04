<template>
  <b-tr @click="selectArticle">
    <b-td>{{ this.article.articleno }}</b-td>
    <b-td>{{ this.article.subject }}</b-td>
    <b-td>{{ this.article.regtime }}</b-td>
  </b-tr>
</template>

<script>
import { mapActions } from 'vuex';

export default {
  name: 'ArticleListItem',
  data() {
    return {};
  },
  props: {
    article: Object,
  },
  methods:{
    ...mapActions(['getArticle']),
    selectArticle() {
      this.getArticle(this.article.articleno);
      this.$router.push({ name: 'ArticleDetail' });
    },
  }
};
</script>

<style></style>
