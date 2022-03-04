<template>
    <div >
         <div class="login-box">
      <h1>Login</h1>
      <form @submit.prevent="handleSubmit">
        <label>Email</label>
        <input type="email" v-model="email" placeholder="" />
        <label>Password</label>
        <input type="password" v-model="password" placeholder="" />
        <input type="submit" value="submit" />
      </form>
    </div>
    <p class="para-2">
      Not have an account? <router-link to="/">Sign-Up Here</router-link>
    </p>
    </div>
</template>


<script>
import axios from 'axios'
export default {
   name:"LoginView",
   data() {
     return {
       email:'',
       password: ''
     }
   },
   methods: {
     async handleSubmit() {
          const response = await axios.post('/pawa/api/user/login',{
            email:this.email,
            password:this.password
          })
          if(response.data.userId !==  0) {
            console.log(response)
            localStorage.setItem("userId", response.data.userId)
            this.$router.push('/home')
          } else {
             console.log(response)
          this.$router.push('/') 
          }
         
     }
   }
}
</script>

<style scoped>


.login-box {
  width: 360px;
  height: 280px;
  margin: auto;
  border-radius: 3px;
  background-color: white;
}

h1 {
  text-align: center;
  padding-top: 15px;
}


form {
  width: 300px;
  margin-left: 20px;
}

form label {
  display: flex;
  margin-top: 20px;
  font-size: 18px;
}

form input {
  width: 100%;
  padding: 7px;
  border: none;
  border: 1px solid gray;
  border-radius: 6px;
  outline: none;
}
input[type="submit"] {
  width: 320px;
  height: 35px;
  margin-top: 20px;
  border: none;
  background-color:  #ea4d33;
  color: white;
  font-size: 18px;
}
p {
  text-align: center;
  padding-top: 20px;
  font-size: 15px;
}
.para-2 {
  text-align: center;
  color: white;
  font-size: 15px;
  margin-top: -10px;
}
.para-2 a {
  color: #49c1a2;
}
</style>