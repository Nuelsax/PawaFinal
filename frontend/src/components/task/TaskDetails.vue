
<template>
      <div id="simpleModal" class="modal" :class="{show: active}">
            <div class="modal-content">
                <div class="modal-header">
                    <span @click="$emit('close-details-bar')" class="closeBtn">&times;</span>
                    <span>{{task.title}}</span>
                    <span><a class="editLink" @click="$emit('view-edit-bar', task)" href="#">edit task</a> </span>
                </div>
                <div class="modal-body">
                  <form  @submit="onSubmit">
                    
                       <p class="description">{{task.description}}</p>

                       <div class="date">
                           <p>Date:{{task.day}}/{{task.month}}/{{task.year}}</p>
                           <p>Priority:{{task.priority}}</p>
                       </div>
                        <div v-for="comment in task.comments" :key="comment.id" class="comments">
                        <div >
                      <p>created By {{task.createdBy}}</p>
                        <p class="commmet-text">{{comment.text}}</p>
                         <span>{{comment.date}}</span>
                        </div>
                       
                        </div>
                        
                         <div class="footer-comment">
                             <input v-model="text" class="comment-input" type="text">
                             <button type="submit" class="button">Add Comment</button>
                         </div>
                       
                  
                  </form>
                </div>
                <!-- <div class="modal-footer">
                    <h3>Modal Footer</h3>
                </div> -->
        </div>
        </div>
</template>

<script>
import axios from 'axios'
// eslint-disable-next-line no-unused-vars

export default {
  name: "TaskDetails",
 props:['task', 'active'],
  data() {
    return {
      text: '',
      
    }
  },
methods: {
 async onSubmit() {
     console.log('clicked')
     const data = {
         text:this.text
     }
     if(data.text === " ") {
          window.location.reload(); 
     } else {
      const id = this.task.id
      await axios.post(`pawa/api/comments/${id}`,data)
       window.location.reload(); 
     }
    
     

 }
}

}
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
    /* background-color: coral; */
    padding: 10px;
    color: black;
    align-items: center;
}

.editLink {
    color: #ea4d33;
    padding-left: 10px;
    font-size: 10px;
}

.date {
    display: flex;
    justify-content: space-between;
    align-items: center;
    font-size: 12px;
    height: 50px;
    padding: 20px;
    margin-bottom: 20px;
  box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px;
}

.description {
    font-size: 14px;
    padding: 20px;
    margin-bottom: 20px;
    box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px;
}

.comments {
     box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px;
     margin-bottom: 20px;
}

/* .modal-footer {
    background-color: coral;
    padding: 10px;
    color: white;
    text-align: center;
} */

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


.saveBtn {
    float: right;
}

.comment-input {
        width: 60%;
    height: 30px;
    background: none;
    margin-right: 20px;
    border: 1px solid black;
}


.tasks{
    display: flex;
    justify-content: space-between;
    margin: 0 20px;
    border-top: 0.1px solid black;
    border-bottom: 0.1px solid black;
    height: 40px;
    align-items: center;
}

.left {
    margin-right: 30px;
}

.footer-comment {
    display: flex;
}


.button {
    background: #ea4d33;
    padding: 0.5em 1em;
    color: #fff;
    border: 0;
     margin-bottom: 1rem;
    /* margin-top: 30px; */
}

::placeholder {
   text-align: center;
  }

@keyframes modalopen {
    from{opacity: 0}
    to { opacity: 1}
}

</style>
