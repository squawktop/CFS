<template>
  <RouterView></RouterView>
</template>

<script>


// 导入bootstrap
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"
// import { ref } from "vue";

// import $ from 'jquery';
export default {
  components: {
    
  }
  ,
  setup() {
    // const user_id = ref("");
    // const username = ref("");
    // const password = ref("");

    // $.ajax({
    //   type: "get",
    //   url: "http://127.0.0.1:3000/user/getlist",
    //   success(resp) {
    //     user_id.value = resp[0].id;
    //     username.value = resp[0].username;
    //     password.value = resp[0].password;

    //   },
    //   error() {
    //     this.user_id = "error"
    //   }
    // })




    return {

    }
  }

}

</script>

<style></style>
