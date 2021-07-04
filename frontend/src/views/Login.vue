<template>
  <b-container class="bv-example-row mt-3">
    <b-row align-h="center" cols="2">
      <b-card
        overlay
        img-src="https://i.ibb.co/dDTXfXB/nv.jpg"
        img-alt="Card Image"
        text-variant="white"
        title=""
        sub-title=""
      >
        <b-card-text style="text-align: left; font-size: 30px"> 로그인 </b-card-text>
      </b-card>
    </b-row>
    <b-row align-h="center" cols="2">
      <b-form @submit.prevent="login">
        <b-form-group class="mt-3 mb-3">
          <b-form-input
            v-model="userid"
            type="text"
            placeholder="아이디를 입력하세요"
          ></b-form-input>
        </b-form-group>
        <b-form-group class="mt-3 mb-3">
          <b-form-input
            v-model="userpwd"
            type="password"
            placeholder="비밀번호를 입력하세요"
          ></b-form-input>
        </b-form-group>
        <b-row align-h="center">
          <b-button size="md" variant="success" type="submit" class="mt-3 mb-3">로그인</b-button>
        </b-row>
        <b-row align-h="center">
          <router-link :to="{ name: 'Signup' }">회원가입</router-link>
        </b-row>
      </b-form>
    </b-row>
  </b-container>
</template>

<script>
import axios from '@/util/http-common';
//import VueCookies from 'vue-cookies';
export default {
  name: 'Login',
  data() {
    return {
      userid: '',
      userpwd: '',
    };
  },
  methods: {
    login() {
      const userid = this.userid;
      const userpwd = this.userpwd;

      if (!userid || !userpwd) {
        return false;
      }

      axios
        .post('http://localhost:8097/user/login', { userid, userpwd })
        .then((res) => {
          if (res.status === 200) {
            alert('로그인 성공');

            this.$cookies.set('jwt-auth-token', res.headers['jwt-auth-token']);
            this.$cookies.set('username', res.data.username);
            this.$cookies.set('userid', res.data.userid);
            this.$cookies.set('email', res.data.email);
            this.$cookies.set('address', res.data.address);
            console.log(this.$cookies.keys());
            //document.cookie = `accessToken=${res.header["accessToken"]}`;
            //VueCookies.set('accessToken',res.header["accessToken"]);

            // document.cookie = `refreshToken=${res.data.data.refreshToken}`;
            //axios.defaults.headers.common['x-access-token'] = res.data.data.accessToken;
            this.$router.push({ name: 'About' });
            this.$router.go(); //새로고침 역할
          }
        })
        .catch((error) => {
          console.error(error);
          alert('로그인에 실패했습니다.');
        });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}

.btn-lg {
  width: 100%;
}
</style>
