<template>
<div class="header">
 <h2>Pawa Task</h2>
    <ButtonCard @toggle-add-task="$emit('toggle-add-task')" text="add Task" color="#ea4d33"/>
</div>
   
</template>


<script>
import ButtonCard from './ButtonCard'
export default {
    name:'HeaderCard',
    components: {
        ButtonCard
    }

}
</script>

<style scoped>
.header h2 {
    color: #333333;
    margin-bottom: 1rem;
}
.header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin:20px 15px;
    /* height: 20px; */
    border-bottom: 0.1px solid gray;
}
</style>