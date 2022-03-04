
<template>
      <div id="simpleModal" class="modal" :class="{show: active}">
            <div class="modal-content">
                <div class="modal-header">
                    <span @click="$emit('close-add-bar')" class="closeBtn">&times;</span>
                    <h2>New Task</h2>
                </div>
                <div class="modal-body">
                  <form  @submit.prevent="onSubmit">
                    
                        <label >Name:</label><br>
                        <input class="input" v-model="todos.title" type="text"><br>
                        
                      
                        <label>Description:</label><br>
                       <textarea v-model="todos.description"  cols="30" rows="5"></textarea>
                       <div class="date">
                        <label for="date">Set Due Date</label><br>
                        <input v-model="todos.day" class="day"  type="text" placeholder="DD">
                        <input  v-model="todos.month" class="month"  type="text" placeholder="MM">
                        <input class="year"  v-model="todos.year" type="text" placeholder="AAAA">
                       </div>
                       <label >Priority:</label><br>
                       <select v-model="todos.priority" :required="true" class="select"  id="priority">
                            
                            <option v-for="priority in allPriorities" :key="priority">{{priority}}</option>
                           
                       </select><br>
                       <label for="comment">Comment:</label><br>
                       <textarea v-model="todos.comments[0].text"   cols="30" rows="5"></textarea>
                         
                      
                       <button type="submit" id="modalBtn" class="button saveBtn">Add a new task</button>
                  
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
import axios from 'axios'
// eslint-disable-next-line no-unused-vars

export default {
  name: "AddTask",
  props: ['active'],
    data() {
    return {
            todos: {
               title: '',
              description: '',
              day:'',
              month:'',
              year: '',
              comments: [
                  {
                      text:""
                  }
              ],
              priority: '',
            },
            allPriorities:priorities,
    }
  },

    methods: {
           
       async onSubmit() {
           console.log('clicked')
            const data = {
               title:this.todos.title,
               description:this.todos.description,
               day:this.todos.day,
               month:this.todos.month,
               year:this.todos.year,
               comments: [
                  {
                      text:this.todos.comments[0].text
                  }
              ],
              priority: this.todos.priority,
            }
            console.log(data)
            const id = localStorage.getItem("userId");
              await axios.post(`pawa/api/tasks/${id}`,data)
             this.$emit('close-add-bar')
             window.location.reload();
            
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
