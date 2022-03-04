import { createStore } from 'vuex'
import axios from 'axios';

export default createStore({
  state: {
    task: [],
  },
  getters: {
    allTodos: (state) => state.task,
  },
  mutations: {
    setTodos:(state, task) => (state.task = task),
  },
  actions: {
    async fetchTodos({ commit}) {
      const res = await axios.get( 'http://localhost:8080/pawa/api/tasks/');

      // if(res.data == []) {
      //   this.heading = !this.heading
      // }
      /* eslint-disable */
      console.log(this.showAddTask)
      console.log(`this is res.data ${res.data}`)

      commit('setTodos', res.data)
  },
  

  },
  modules: {
  }
  
})
