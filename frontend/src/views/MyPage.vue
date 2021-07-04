<template>
  <b-container class="bv-example-row" >
    <b-row align-h="center" class="mt-3 mb-3" cols="2">
      <h3>{{this.$cookies.get('username')}}님의 정보</h3>
    </b-row>
    <b-row align-h="center">
<b-table-simple cols="2">
  <b-tbody>
  <b-tr>
    <b-td colspan="6">이름</b-td>
    <b-td colspan="6">{{this.$cookies.get('username')}}</b-td>
  </b-tr>
  <b-tr>
    <b-td colspan="6">아이디</b-td>
    <b-td colspan="6">{{this.$cookies.get('userid')}}</b-td>
  </b-tr>
  <b-tr>
    <b-td colspan="6">이메일</b-td>
    <b-td colspan="6">{{this.$cookies.get('email')}}</b-td>
  </b-tr>
  <b-tr>
    <b-td colspan="6">주소</b-td>
    <b-td colspan="6">{{this.$cookies.get('address')}}</b-td>
  </b-tr>
  </b-tbody>
</b-table-simple>
</b-row>
<b-row align-h="center">
    <b-button size="md" variant="danger" type="submit"  v-on:click="getout">회원탈퇴</b-button>
</b-row>
</b-container>



</template>

<script>

export default {
  name: 'About',
  data(){
    return{
     
    }
  },

  methods: {
      getout() {
           this.$cookies.keys().forEach((cookie) => this.$cookies.remove(cookie)); //모든 쿠키 다 지워버림

      //console.log(this.$cookies.keys());
      alert('회원탈퇴가 완료되었습니다.');
      this.$router.push({ name: 'About' });
      this.$router.go(); //새로고침 역할
      }
  },



}


</script>