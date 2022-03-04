<template>
  <div class="container">
  <HeaderCard  v-on:toggle-add-task="addTask()"/>
  <TaskDescription  v-on:close-edit-bar="closeEditBar()"  :task="task" :active="active.todoedit_active" />
  <AddTask v-on:close-add-bar="closeAddBar()"  :active="active.todoadd"/>
  <TaskDetails :task="task"   :active="active.tododetails" v-on:close-details-bar="closeDetailsBar()" v-on:view-edit-bar="viewEditTask($event)"   />
  <TaskCard  v-for="task in tasks" :key="task.id" :task="task" v-on:view-task="viewtask($event)" v-on:view-details="viewDetails($event)"/>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
// @ is an alias to /src
// import tasks from '../data/tasks.js'
import TaskCard from '../components/task/TaskCard.vue'
import HeaderCard from '../components/HeaderCard.vue'
import TaskDescription from '../components/task/TaskDescription.vue'
import TaskDetails from '../components/task/TaskDetails.vue'
import AddTask from '../components/task/AddTask.vue'
import axios from 'axios'
export default {   
  name: 'HomeView',
  components: {
     TaskCard,
     HeaderCard,
     TaskDescription,
     TaskDetails,
     AddTask
  },
   data() {
    return {
       tasks:[],
       task: {
           "id": "",
        "title": "",
        "description": "",
        "day": "",
        "month": "",
        "year": "",
        "priority": "",
        "comments": [{
            "text":""
        }]
       },
         active: {
         todoedit_active:false,
         tododetails:false,
         todoadd:false

       }
    }
  },
  
  methods: {
     ...mapActions(['fetchTodos','deleteTodo','getTodo']),
    viewtask(task) {
       this.task= task
         this.active.todoedit_active = true
         
          console.log(this.task)
    },
       viewEditTask(task) {
       this.task= task
         this.active.todoedit_active = true
         this.active.tododetails= false
          console.log(this.task)
    },

    closeEditBar() {
     this.active.todoedit_active = false
    },
    viewDetails(task) {
      this.task=task
     this.active.tododetails= true
    },
    closeDetailsBar() {
  this.active.tododetails= false
    },

    addTask() {
      this.active.todoadd= true
    },

    closeAddBar() {
        this.active.todoadd= false
    },
      async loadData() {
          const response = await axios.get('/pawa/api/tasks/')
         this.tasks = response.data
         
     }
  },
  computed: mapGetters(['allTodos','getOneTodo','getHeading']),
    async created() {
     try {
          const response = await axios.get('/pawa/api/tasks/')
           this.tasks = response.data
     } catch(e) {
       console.log(e)
     }
  }
}
</script>


<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400&display=swap');
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
body {
  font-family: 'Poppins', sans-serif;
}
.container {
    max-width: 600px;
    margin: auto;
    border: 1px solid gray;
    height: 100vh;
    overflow: hidden;
    background-color:#ffffff;
}

.button {
    background: #ea4d33;
    padding: 0.5em 1em;
    color: #fff;
    border: 0;
    cursor:pointer;
     margin-bottom: 1rem;
  
}
</style>