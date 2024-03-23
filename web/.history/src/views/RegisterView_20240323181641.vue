<template>
    <div class="background">
        <h2>在线服装销售管理系统</h2>
        <ContentField>
            <div class="row justify-content-md-center">
                <div class="col-3">
                    <form @submit.prevent="register">
                        <div class="mb-3">
                            <label for="username" class="form-label">用户名</label><input v-model="username" type="text" class="form-control" id="username"
                                placeholder="请输入用户名" />
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">密码</label>
                            <input v-model="password" type="password" class="form-control" id="password"
                                placeholder="请输入密码" />
                        </div>
                        <div class="mb-3">
                            <label for="confirmedPassword" class="form-label">确认密码</label>
                            <input v-model="confirmedPassword" type="password" class="form-control"
                                id="confirmedPassword" placeholder="请再次输入密码" />
                        </div>
                        <div class="error-message">{{ error_message }} </div>
                        <button type="submit" class="btn btn-primary">注册</button>
                        <!-- <button type="button" class="btn btn-primary" style="margin-top: 10px" @click="loginview" >已有账号，返回登录</button> -->
                        <div class="tip" @click="loginview">已有账号，返回登录</div>
                    </form>
                </div>
            </div>
        </ContentField>
    </div>

</template>

<script>
import ContentField from "@/components/ContentField.vue";
import { ElMessage } from 'element-plus'
import { ref } from 'vue'
import router from "@/router/index";
import $ from 'jquery'

export default {
    components: {
        ContentField,
    },
    setup() {
        let username = ref('');
        let password = ref('');
        let confirmedPassword = ref('');
        let error_message = ref('');

        const register = () => {
            $.ajax({
                url: "http://127.0.0.1:3000/api/user/account/register/",
                type: "post",
                data: {
                    username: username.value,
                    password: password.value,
                    confirmedPassword: confirmedPassword.value,
                },
                success(resp) {
                    if (resp.error_message === 'success') {
                        ElMessage.success("注册成功，请登录") ;
                        router.push({ name: "user_login" });
                    } else {
                        error_message.value = resp.error_message;
                    }
                }
            })
        }

        const loginview = () =>{
            router.push({name:"user_login"}) ; 
        } 

        return {
            username,
            password,
            confirmedPassword,
            error_message,
            register,
            loginview,
        }
    }
};
</script>

<style scoped>
h2 {

    text-align: center;
    margin-top: 150px;
    font-weight: bold;
}

button {
    width: 100%;
}

div.error-message {
    color: red;
}

.tip {
    cursor: pointer;
    text-align: center;
    margin-top: 10px;
    
}
.tip:hover{
    text-decoration:underline;
}
</style>
