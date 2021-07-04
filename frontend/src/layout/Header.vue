<template>
  <div>
    <div>
      <b-navbar toggleable="lg" type="dark" variant="dark" fixed="top">
        <b-navbar-brand href="/about">Oh My House</b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item text="아파트 검색"
              ><router-link class="link" to="/apt">아파트 검색</router-link></b-nav-item
            >
          </b-navbar-nav>
          <b-navbar-nav>
            <b-nav-item text="게시판"
              ><router-link class="link" to="/board">게시판</router-link></b-nav-item
            >
          </b-navbar-nav>
          <b-navbar-nav v-if="!isCookie">
            <b-nav-item text="회원가입"
              ><router-link class="link" to="/signup">회원가입</router-link></b-nav-item
            >
          </b-navbar-nav>
          <b-navbar-nav v-if="isCookie" v-on:click.prevent="deleteCookie">
            <b-nav-item text="My Page" v-if="isCookie"
              ><router-link class="link" to="/about">로그아웃</router-link></b-nav-item
            >
          </b-navbar-nav>
          <b-navbar-nav v-if="!isCookie">
            <b-nav-item text="로그인"
              ><router-link class="link" to="/login">로그인</router-link></b-nav-item
            >
          </b-navbar-nav>
          <b-navbar-nav v-if="isCookie">
            <b-nav-item text="My Page"
              ><router-link class="link" to="/mypage">My Page</router-link></b-nav-item
            >
          </b-navbar-nav>
          <b-navbar-nav v-if="isCookie">
            <b-nav-item text="welcome"
              ><router-link class="link" to="/about"
                >{{ this.$cookies.get('username') }}님 환영합니다!</router-link
              ></b-nav-item
            >
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Header',
  data() {
    return {
      isCookie: null,
    };
  },
  created() {
    this.isCookie = document.cookie;
  },
  methods: {
    deleteCookie() {
      //this.$cookies.remove('jwt-auth-token');
      //this.isCookie = document.cookie;

      this.$cookies.keys().forEach((cookie) => this.$cookies.remove(cookie)); //모든 쿠키 다 지워버림

      //console.log(this.$cookies.keys());
      alert('로그아웃 되었습니다.');
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
.navbar.navbar-dark.bg-dark {
  background-color: #003366 !important;
}
</style>
