<template>
  <div v-if="article" class="regist">
    <h1 class="underline"></h1>
    <div class="regist_form">
      <label for="articleno">게시글 번호</label>
      <div class="view">{{ article.articleno }}</div>
      <label for="subject">제목</label>
      <div class="view">{{ article.subject }}</div>
      <label for="content">내용</label>
      <div class="view" style="height:auto; min-height:100px; word-break:break-all; overflow:auto">{{ article.content }}</div>
      <label for="userid">작성자</label>
      <div class="view">{{ article.userid }}</div>
      <label for="regtime">작성시간</label>
      <div class="view">{{ article.regtime }}</div>
      <div style="padding-top: 15px">
        <b-row align-h="center">
        <b-button class="btn mr-1"><router-link :to="`/board/modify/${article.articleno}`" v-if="$cookies.get('userid')==article.userid" class="textdeco">수정</router-link></b-button>
        <b-button class="btn mr-1" v-if="$cookies.get('userid')==article.userid" @click="deleteArticle">삭제</b-button>
        <b-button class="btn"><router-link to="/board" class="textdeco">목록</router-link></b-button>
      </b-row>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "@/util/http-common";
import {mapState} from "vuex";

export default {
  name: "ArticleDetail",
  computed:{
    ...mapState(['article']),
  },
  methods: {
    deleteArticle() {
      if (confirm("정말로 삭제?")) {
        axios.delete(`/article/`+this.article.articleno).then(() => {
          let msg = "삭제가 완료되었습니다.";
          alert(msg);
          this.$router.push("/board");
        });
      }
    },
    enterToBr(str) {
      if (str) return str.replace(/(?:\r\n|\r|\n)/g, "<br />");
    }
  }
};
</script>

<style scoped>
.regist {
  padding: 10px;
}
.regist_form {
  text-align: left;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
input,
textarea,
.view {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}
.btn{
  color: white;
}
.textdeco{
  text-decoration: none;
  color: inherit;
}
</style>
