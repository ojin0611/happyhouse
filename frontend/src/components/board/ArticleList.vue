<template>
  <div>
    <board-nav></board-nav>
    <b-table-simple>
      <b-thead>
        <b-tr>
          <b-th>번호</b-th>
          <b-th>제목</b-th>
          <b-th>작성일</b-th>
        </b-tr>
      </b-thead>
      <b-tbody>
        <article-list-item v-for="(article, index) in articles" :key="index" :article="article" />
      </b-tbody>
    </b-table-simple>
  </div>
</template>

<script>
import ArticleListItem from '@/components/board/ArticleListItem.vue';
import BoardNav from '@/components/board/BoardNav.vue';
import { mapGetters } from 'vuex';
export default {
  name: 'ArticleList',
  data() {
    return {};
  },
  components: {
    ArticleListItem,
    BoardNav,
  },
  created() {
    this.$store.dispatch('getArticleList');
  },
  computed: {
    ...mapGetters(['articles']),
  },
};
</script>

<style></style>
