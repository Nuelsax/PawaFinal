<template>
<div>
 <div class="signup-box">
      <h1>Sign Up</h1>
      <h4>It's free and only takes a minute</h4>
      <form @submit.prevent="handle">
        <label>First Name</label>
        <input type="text" v-model="firstName" placeholder="" />
        <label>Last Name</label>
        <input type="text" v-model="lastName" placeholder="" />
        <label>Email</label>
        <input type="email" v-model="email" placeholder="" />
        <label>Password</label>
        <input type="password" v-model="password" placeholder="" />
        <input type="submit" value="submit" />
      </form>
    
    </div>
    <p class="para-2">
      Already have an account? <router-link to="/login">Login here</router-link>
    </p>
</div>
    
</template>

<script>
import axios from 'axios'
export default {
  name:"RegisterView",
  data() {
    return {
      firstName: '',
      lastName: '',
      email:'',
      password: '',
    }
  },
  methods: {
   async handle() {
      const data = {
        firstName:this.firstName,
        lastName:this.lastName,
        email:this.email,
        password:this.password
      }
     const response = await axios.post('pawa/api/user/register', data)
     console.log(response)
     this.$router.push('/login')
    }
  }
}
</script>


<style scoped>
body {
  background-color: #344a72;
  font-family: "Roboto", sans-serif;
}

.signup-box {
  width: 360px;
  height: 620px;
  margin: auto;
  background-color: white;
  border-radius: 3px;
}

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

h4 {
  text-align: center;
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
  background-color: #ea4d33;
  color: white;
  font-size: 18px;
}

.para-2 {
  text-align: center;
  color: white;
  font-size: 15px;
  margin-top: -100px;
}
.para-2 a {
  color: #49c1a2;
}


</style>