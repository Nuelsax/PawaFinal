<template>
    <button @click="onClick" :style="{background: color}" class="button">{{text}}</button>
</template>

<script>
export default {
    name:'ButtonCard',
    props: {
        text:String,
        color:String,
    },
    methods: {
        onClick() {
            
            this.$emit('toggle-add-task')
        }
    }
}
</script>