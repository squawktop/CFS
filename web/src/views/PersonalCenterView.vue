<template>

    <NavBar />
    <div class="row">
        <AsideBar />
        <div class="col-10">
            <ContentField>
                <slot>

                    <el-form :model="ruleForm" :rules="rules" label-width="100px" class="demo-ruleForm" ref="formRef">

                        <el-form-item label="姓名" prop="name">
                            <el-input v-model="ruleForm.name" style="width: 400px;"></el-input>
                        </el-form-item>

                        <el-form-item label="性别" prop="sex">
                            <el-radio v-model="ruleForm.sex" label="0">男</el-radio>
                            <el-radio v-model="ruleForm.sex" label="1">女</el-radio>
                        </el-form-item>

                        <el-form-item label="地区" prop="province">
                            <el-cascader size="large" :options="pcaTextArr" v-model="ruleForm.province"
                                placeholder=" 请选择省市区" style="width: 400px;">
                            </el-cascader>
                        </el-form-item>

                        <el-form-item label="详细地址" prop="address">
                            <!-- <el-input v-model="ruleForm.address" placeholder="如街道、门牌号、小区、乡镇、村等"></el-input> -->
                            <el-input v-model="ruleForm.address" placeholder="如街道、门牌号、小区、乡镇、村等" type="textarea"
                                maxlength="30" show-word-limit style="width: 400px;"></el-input>
                        </el-form-item>



                        <el-form-item label="电子邮箱" prop="email">
                            <el-input v-model="ruleForm.email" style="width: 400px;"></el-input>
                        </el-form-item>

                        <el-form-item label="手机" prop="phone">
                            <el-input v-model="ruleForm.phone" style="width: 400px;"></el-input>
                        </el-form-item>

                        <el-form-item label="邮政编码" prop="zipcode">
                            <el-input v-model="ruleForm.zipcode" style="width: 400px;"></el-input>
                        </el-form-item>

                        <el-form-item>
                            <el-button type="primary" @click="submitForm('ruleForm')">立即修改</el-button>
                            <el-button @click="resetForm('ruleForm')">重置</el-button>
                        </el-form-item>
                    </el-form>
                </slot>
            </ContentField>

        </div>

    </div>


</template>

<script>
import NavBar from "@/components/NavBar.vue";
import AsideBar from "@/components/AsideBar.vue";
import ContentField from "@/components/ContentField.vue";


import { pcaTextArr } from 'element-china-area-data'
import $ from 'jquery'
import { reactive, ref } from 'vue';

import { ElMessage } from 'element-plus'



export default {
    components: {
        NavBar,
        AsideBar,
        ContentField,
    },
    setup() {
        const ruleForm = reactive({
            province: '',
            address: '',
            name: '',
            sex: '',
            email: '',
            phone: '',
            zipcode: '',
        });

        const rules = {
            province: [
                { required: true, message: '请选择地区', trigger: 'blur' },
            ],
            address: [
                { required: true, message: '请选择活动区域', trigger: 'blur' }
            ],
            name: [
                { required: true, message: '请输入您的姓名', trigger: 'blur' },
            ],
            sex: [
                { required: true, message: '请选择性别', trigger: 'blur' },
            ],
            email: [
                { required: true, message: "请输入正确的邮箱", trigger: "blur" },
                {
                    validator: function (rule, value, callback) {
                        if (/^([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|_|.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/.test(value) == false) {
                            callback(new Error("请输入邮箱"));
                        } else {
                            //校验通过
                            callback();
                        }
                    },
                    trigger: "blur"
                }
            ],
            phone: [
                { required: true, message: "请输入手机号", trigger: "blur" },
                {
                    validator: function (rule, value, callback) {
                        if (/^(13[0-9]|14[0-9]|15[0-9]|16[6]|18[0-9]|19[6,9]|17[0-9])\d{8}$/i.test(value) == false) {
                            callback(new Error("请输入手机号"));
                        } else {
                            //校验通过
                            callback();
                        }
                    },
                    trigger: "blur"
                }
            ],
            zipcode: [
                { required: true, message: "请输入邮政编码", trigger: "blur" },
                {
                    validator: function (rule, value, callback) {
                        if (!/^\d{6}$/.test(value)) {
                            callback(new Error("请输入正确的邮政编码"));
                        } else {
                            // 校验通过  
                            callback();
                        }
                    },
                    trigger: "blur"
                }
            ],


        };

        const formRef = ref(ruleForm);

        // 提交表单
        const submitForm = () => {
            formRef.value.validate((valid) => {
                if (valid) {
                    $.ajax({
                        url: "http://127.0.0.1:3000/api/user/account/update/",
                        type: "post",
                        data: {
                            name: ruleForm.name,
                            sex: ruleForm.sex,
                            province: ruleForm.province[0],
                            city: ruleForm.province[1],
                            area: ruleForm.province[2],
                            address: ruleForm.address,
                            email: ruleForm.email,
                            phone: ruleForm.phone,
                            zipcode: ruleForm.zipcode,
                        },
                        headers: {
                            Authorization:
                                "Bearer " +
                                "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiMzc3YzkxMDMwZGU0OTdjOGYzYWRmZmQ2YzJhMDg2NCIsInN1YiI6IjE4IiwiaXNzIjoic2ciLCJpYXQiOjE3MDk4OTkxMDQsImV4cCI6MTcxMTEwODcwNH0.o4gnaDT0v-OLyO2WrNk8yKe1VWMjQQ2pRhAIBL3TXBQ"
                        },
                        success(resp) {
                            if (resp.error_message === "success") {
                                submitSuccess();
                            } else {
                                submitFailed();
                            }
                        },
                        error() {
                            submitFailed();
                        }

                    });

                } else {
                    submitFailed();
                    return false;
                }
            });
        };

        const submitSuccess = () => {
            ElMessage.success("修改成功");
        }
        const submitFailed = () => {
            ElMessage.error('修改失败')
        }


        // 重置表单  
        const resetForm = () => {
            formRef.value.resetFields();
            ElMessage.success("您已清空");
        };
        return {
            ruleForm,
            rules,
            formRef,
            pcaTextArr,
            submitForm,
            resetForm,
            submitSuccess,
            submitFailed
        }

    },
}

</script>


<style scoped>
.accordion-body {
    cursor: pointer;
    border-radius: 5%;
}

.accordion-body:hover {
    background-color: rgba(207, 226, 255, 0.5);
}
</style>
