import Vue from 'vue';
import Vuex from 'vuex';
import axios from '@/util/http-common';
// import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    sido: [],
    gugun: [],
    dong: [],
    apts: [],
    aptdeals: [],
    articles: [],
    article:'',
  },
  getters: {
    sido(state) {
      return state.sido;
    },
    gugun(state) {
      return state.gugun;
    },
    dong(state) {
      return state.dong;
    },
    apts(state) {
      return state.apts;
    },
    aptdeals(state) {
      return state.aptdeals;
    },
    articles(state) {
      return state.articles;
    },
    article(state) {
      return state.article;
    },
  },

  mutations: {
    GET_SIDO_LIST(state, payload) {
      state.sido = payload;
    },
    GET_GUGUN_LIST(state, payload) {
      state.gugun = payload;
    },
    GET_DONG_LIST(state, payload) {
      state.dong = payload;
    },
    GET_APTS_LIST(state, payload) {
      state.apts = payload;
    },
    SELECT_APT(state, payload) {
      state.aptdeals = payload;
    },
    GET_ARTICLE_LIST(state, payload) {
      state.articles = payload;
    },
    GET_ARTICLE(state, payload) {
      state.article = payload;
    },
  },
  actions: {
    getSidoList({ commit }) {
      axios.get('/house/sido').then(({ data }) => {
        commit('GET_SIDO_LIST', data);
      });
    },
    getGugunList({ commit }, sidoCode) {
      axios.get('/house/gugun/' + sidoCode).then(({ data }) => {
        commit('GET_GUGUN_LIST', data);
      });
    },
    getDongList({ commit }, gugunCode) {
      axios.get('/house/dong/' + gugunCode).then(({ data }) => {
        commit('GET_DONG_LIST', data);
      });
    },
    getAptsList({ commit }, dong) {
      axios.get('/house/apt/' + dong).then(({ data }) => {
        commit('GET_APTS_LIST', data);
      });
    },
    selectApt({ commit }, aptName) {
      axios.get('/house/deal/' + aptName).then(({ data }) => {
        commit('SELECT_APT', data);
      });
    },
    getArticleList({ commit }) {
      axios.get('/article/').then(({ data }) => {
        commit('GET_ARTICLE_LIST', data);
      });
    },
    getArticle({ commit }, articleno) {
      axios.get('/article/'+articleno).then(({ data }) => {
        commit('GET_ARTICLE', data);
      });
    },
  },
  modules: {},
  // plugins: [createPersistedState()],
});
