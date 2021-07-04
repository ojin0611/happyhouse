<template>
  <div id="app">
    <Header />
    <div class="router-view-container">
      <router-view />
    </div>
  </div>
</template>

<script>
import Header from '@/layout/Header';
export default {
  name: 'App',
  components: {
    // ES6 : property shorthand
    // Header: Header == Header
    //2. 컴포넌트 등록하기.
    Header,
  },
  data() {
    return {};
  },
  methods: {},
};
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

.router-view-container {
  width: 70%;
  padding-top: 5%;
  margin: auto;
}
</style>
