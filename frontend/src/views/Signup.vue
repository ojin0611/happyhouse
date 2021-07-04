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
        <b-card-text style="text-align: left; font-size: 30px"> 회원가입 </b-card-text>
      </b-card>
    </b-row>
    <b-row align-h="center" cols="2">
      <b-form @submit.prevent="signup">
        <b-form-group class="mt-3 mb-3">
          <b-form-input
            type="text"
            v-model="userid"
            placeholder="아이디를 입력하세요"
          ></b-form-input>
        </b-form-group>
        <b-form-group class="mt-3 mb-3">
          <b-form-input
            type="text"
            v-model="username"
            placeholder="이름을 입력하세요"
          ></b-form-input>
        </b-form-group>
        <b-form-group class="mt-3 mb-3">
          <b-form-input
            type="password"
            v-model="userpwd"
            placeholder="비밀번호를 입력하세요"
          ></b-form-input>
        </b-form-group>
        <b-form-group class="mt-3 mb-3">
          <b-form-input
            type="text"
            v-model="email"
            placeholder="이메일을 입력하세요"
          ></b-form-input>
        </b-form-group>
        <b-form-group class="mt-3 mb-3">
          <b-form-input
            type="text"
            v-model="address"
            placeholder="주소를 입력하세요"
          ></b-form-input>
        </b-form-group>
        <b-row align-h="center">
          <b-button size="md" variant="success" type="submit" class="mt-3 mb-3">회원가입</b-button>
        </b-row>
        <b-row align-h="center">
          <router-link :to="{ name: 'Login' }">로그인하기</router-link>
        </b-row>
      </b-form>
    </b-row>
  </b-container>
</template>

<script>
import axios from '@/util/http-common';

export default {
  name: 'Signup',
  data() {
    return {
      userid: '',
      username: '',
      userpwd: '',
      email: '',
      address: '',
    };
  },
  methods: {
    signup() {
      const userid = this.userid;
      const username = this.username;
      const userpwd = this.userpwd;
      const email = this.email;
      const address = this.address;

      if (!userid || !username || !userpwd || !email || !address) {
        return false;
      }

      axios
        .post('http://localhost:8097/user/join', { userid, username, userpwd, email, address })
        .then((res) => {
          if (res.status === 200) {
            // 성공적으로 회원가입이 되었을 경우
            this.$router.push({ name: 'Login' });
          }
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
