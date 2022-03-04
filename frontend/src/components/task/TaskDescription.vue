
<template>
      <div id="simpleModal" class="modal" :class="{show: active}">
            <div class="modal-content">
                <div class="modal-header">
                    <span @click="$emit('close-edit-bar')"  class="closeBtn">&times;</span>
                    <h2>{{task.title}}</h2>
                </div>
                <div class="modal-body">
                  <form  @submit.prevent="onSubmit">
                    
                        <label >Name:</label><br>
                        <input class="input" v-bind:value="task.title" @change="todoTextChange" type="text"><br>
                        
                      
                        <label>Description:</label><br>
                       <textarea v-bind:value="task.description" @change="todoDescriptionChange"  cols="30" rows="5"></textarea>
                       <div class="date">
                        <label for="date">Set Due Date</label><br>
                        <input v-bind:value="task.day" class="day" @change="todoDayChange"   type="text" placeholder="DD">
                        <input  v-bind:value="task.month" class="month"  @change="todoMonthChange"  type="text" placeholder="MM">
                        <input class="year"  v-bind:value="task.year" type="text" @change="todoYearChange"  placeholder="AAAA">
                       </div>
                       <label >Priority:</label><br>
                       <select v-bind:value="task.priority" :required="true" class="select" @change="todoPriortyChange"  id="priority">
                            
                            <option v-for="priority in this.allPriorities" :key="priority">{{priority}}</option>
                           
                       </select><br>
                       <label for="comment">Comment:</label><br>
                       <textarea v-bind:value="task.comment" @change="todoCommentChange"    cols="30" rows="5"></textarea>
                         
                      
                       <button type="submit" id="modalBtn" class="button saveBtn">Edit task</button>
                  
                  </form>
                </div>
                <!-- <div class="modal-footer">
                    <h3>Modal Footer</h3>
                </div> -->
        </div>
        </div>
</template>

<script>

import priorities from './priorites.js'
import axios from "axios"
// eslint-disable-next-line no-unused-vars

export default {
  name: "TaskDescription",
  props:['task', 'active'],
  computed: {
      
  },
  data() {
      return {
         allPriorities:priorities
      }
     
  },
    methods: {
     
    async onSubmit(id) {
           axios.put(`http://localhost:8080/pawa/api/tasks/${id},`)
       }
       
    },
 
};
</script>

<style lang="scss">

.modal {
    display: none;
    position:  fixed;
    z-index: 1;
    left: 0;
    top: 0;
    height: 100%;
    width: 100%;
    overflow: auto;
    background-color: rgba(0,0,0, 0.5);

    &.show {
           display:block;
    }
}

.modal-content {
    background-color: #ffffff;
    margin: 8% auto;
    height: 65vh;
  
    width: 30%;
    box-shadow: 70%;
    box-shadow: 0 5px 8px 0 rgba(0,0,0, 0.17);
    animation-name: modalopen;
    animation-duration: 1s;

}

.modal-header h2, .modal-footer h3 {
    margin: 0;
}
.modal-header {
 
    padding: 10px;
    color: black;
}


.modal-body {
    padding: 10px 20px;
}

.closeBtn {
    color: #ccc;
    float: right;
    font-size: 30px;
    
}

.closeBtn:hover, .closeBtn:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

.input {
    width: 96%;
    height: 30px;
    background: none;
    border: 1px solid black;
}
textarea {
    width: 96%;
}

.day {
    width: 15%;
    height: 30px;
}
.month {
    width: 20%;
    height: 30px;
}
.year {
    width: 30%;
    height: 30px;
}

.saveBtn {
    float: right;
}

.select {
    width: 70%;
    height: 30px;
    outline: none;
}

.tasks{
    display: flex;
    justify-content: space-between;
    margin: 0 20px;
    border-top: 0.1px solid black;
    border-bottom: 0.1px solid black;
    height: 30px;
    align-items: center;
}

.left {
    margin-right: 30px;
}

::placeholder {
   text-align: center;
  }

@keyframes modalopen {
    from{opacity: 0}
    to { opacity: 1}
}

</style>
