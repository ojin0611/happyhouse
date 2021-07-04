<template>
  <div class="regist">
    <!-- v-if의 type을 이용하여 도서등록과 도서수정을 구분 -->
    <h1 v-if="type == 'create'" class="underline"></h1>
    <h1 v-else class="underline"></h1>
    <div class="regist_form">
      <!-- <label for="articleno">게시글번호</label>
      <input v-if="type == 'create'" type="text" id="articleno" name="articleno" v-model="articleno" ref="articleno" />
      <input v-else type="text" id="articleno" name="articleno" v-model="articleno" ref="articleno" readonly /><br /> -->
      <b-label for="subject">제목</b-label>
      <b-input type="text" id="subject" name="subject" v-model="subject" ref="subject" /><br />
      <b-label for="author">내용</b-label>
      <b-textarea id="content" name="content" v-model="content" ref="content" rows="12"/><br />
      <b-row align-h="center">
      <b-button v-if="type == 'create'" @click="checkValue" class="mr-1">등록</b-button>
      <b-button v-else @click="checkValue" class="mr-1">수정</b-button>
      <b-button @click="moveList">목록</b-button>
      </b-row>
    </div>
  </div>
</template>

<script>
import axios from "@/util/http-common";
import {mapState} from "vuex";

export default {
  name: "writeform",
  props: {
    // 상위 component로 부터 넘어온 type정보를 받음.
    type: { type: String }
  },
  data() {
    return {
      content: "",
      subject: "",
    };
  },
  computed:{
    ...mapState(['article']),
  },
  created() {
    if (this.type === "modify") {
      this.content = this.article.content;
      this.subject = this.article.subject;
    }
  },

  methods: {
    // 입력값 체크하기 - 체크가 성공하면 registBook 호출
    checkValue() {
      // 사용자 입력값 체크하기
      // isbn, 제목, 저자, 가격, 설명이 없을 경우 각 항목에 맞는 메세지를 출력
      let err = true;
      let msg = "";
      !this.subject && ((msg = "제목을 입력해주세요"), (err = false), this.$refs.subject.focus());
      err && !this.content && ((msg = "내용을 입력해주세요"), (err = false), this.$refs.content.focus());

      if (!err) alert(msg);
      // 만약, 내용이 다 입력되어 있다면 registBook 호출
      else this.type == "create" ? this.writeArticle() : this.modifyArticle();
    },
    writeArticle() {
      console.log(this.$cookies.get('userid'));
      axios
        .post("/article/", {
          subject: this.subject,
          content: this.content,
          userid: this.$cookies.get('userid'),
        })
        .then(() => {
          let msg = "등록이 완료되었습니다.";
          alert(msg);
          this.moveList();
        });
    },
    modifyArticle() {
        axios
        .put(`/article/`, {
          articleno: this.article.articleno,
          subject: this.subject,
          content: this.content
        })
        .then(() => {
          let msg = "수정이 완료되었습니다.";
          alert(msg);
          this.$router.push("/board");
        });
    },
    moveList() {
      this.$router.push("/board");
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
</style>
