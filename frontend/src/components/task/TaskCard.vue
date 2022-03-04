<template>
 <div class="todos">
    <div class="tasks">
                <h6> <i class="fa-solid fa-circle-check" @click="$emit('view-details', task)"></i> {{task.title}}</h6>
                <div class="left">
                <h6><span><i @click="showTaskTab(task.id)"  class="fa-solid fa-calendar-days fas"></i></span>{{task.day}}/{{task.month}}/{{task.year}} 
                 <span><i class="fa-solid fa-comment fas2 "></i></span> <span><i @click="$emit('view-task', task)" class="fa-solid fa-pen fas"></i></span> 
                  <span><i @click="deleteTodo(task.id)"   class="fa-solid fa-trash-can fas"></i></span>  </h6>
            </div>
            </div>
       </div>

</template>

<script>
import axios from 'axios'


export default {

  props: ['task'],
   
  
  methods: {
  async deleteTodo(id) {
    console.log("clicked" + id)
    await axios.delete(`http://localhost:8080/pawa/api/tasks/${id}`)
     window.location.reload();
    

  },
   },
    
  
  computed:{

  },
 

};
</script>

<style scoped>

.tasks{
    display: flex;
    justify-content: space-between;
    margin: 0 20px;
    border-top: 0.1px solid black;
    border-bottom: 0.1px solid black;
    height: 30px;
    align-items: center;
}

.fas2 {
   
  margin-left:5px;
    color:  #ea4d33;
    cursor: pointer;

}

.fas {
     margin-right: 5px;
    color:  #ea4d33;
    cursor: pointer;
}

@media (max-width: 500px) {
  .todos {
    grid-template-columns: 1fr;
  }
}
</style>
