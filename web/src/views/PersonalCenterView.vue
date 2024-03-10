<template>

    <NavBar />
    <div class="row">
        <AsideBar />
        <div class="col-10">
            <ContentField>
                <slot>


                    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

                        <el-form-item label="姓名" prop="name">
                            <el-input v-model="ruleForm.name" style="width: 400px;"></el-input>
                        </el-form-item>

                        <el-form-item label="性别" prop="sex">
                            <el-radio v-model="ruleForm.sex" label="0">男</el-radio>
                            <el-radio v-model="ruleForm.sex" label="1">女</el-radio>
                        </el-form-item>


                        <el-form-item label="地区" prop="province">
                            <el-cascader size="large" :options="options" @change="handleChange" v-model="provinceCode"
                                placeholder=" 请选择省市区" style="width: 400px;"></el-cascader>
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
    <!-- <AsideBar /> -->


</template>

<script>
import NavBar from "@/components/NavBar.vue";
import AsideBar from "@/components/AsideBar.vue";
import ContentField from "@/components/ContentField.vue";
// import { regionData } from "element-china-area-data";
import { regionData, codeToText } from "element-china-area-data";


// import { ref } from "vue";
import $ from 'jquery'
// import router from "@/router";




export default {
    components: {
        NavBar,
        AsideBar,
        ContentField,

    }, setup() {


    }, data() {
        return {
            ruleForm: {
                province: '',
                city: '',
                area: '',
                address: '',
                name: '',
                sex: '',
                email: '',
                phone: '',
                zipcode: '',
            },
            rules: {
                province: [
                    { required: true, message: '请选择地区', trigger: 'blur' },
                ],
                address: [
                    { required: true, message: '请选择活动区域', trigger: 'blur' }
                ],
                name: [
                    { required: true, message: '请输入您的性别', trigger: 'blur' },
                    // { min: 2, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
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


            },

            options: regionData,//选择格式
            provinceCode: [], //省市区绑定数组

        };
    },
    methods: {
        submitForm(formName) {


            this.$refs[formName].validate((valid) => {
                if (valid) {
                    alert('submit!');

                    $.ajax({
                        url: "http://127.0.0.1:3000/api/user/account/update/",
                        type: "post",
                        data: {
                            name: this.ruleForm.name,
                            sex: this.ruleForm.sex,
                            province: this.ruleForm.province,
                            city: this.ruleForm.city,
                            area: this.ruleForm.area,
                            address: this.ruleForm.address,
                            email: this.ruleForm.email,
                            phone: this.ruleForm.phone,
                            zipcode: this.ruleForm.zipcode,
                        },
                        headers: {
                            Authorization:
                                "Bearer " +
                                "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiMzc3YzkxMDMwZGU0OTdjOGYzYWRmZmQ2YzJhMDg2NCIsInN1YiI6IjE4IiwiaXNzIjoic2ciLCJpYXQiOjE3MDk4OTkxMDQsImV4cCI6MTcxMTEwODcwNH0.o4gnaDT0v-OLyO2WrNk8yKe1VWMjQQ2pRhAIBL3TXBQ"
                        },
                        success(resp) {
                            if (resp.error_message === "success") {
                                console.log("添加成功")
                            } else {
                                console.log("添加失败");
                            }
                        },
                        error() {
                            console.log("添加失败");
                        }

                    });

                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
            this.provinceCode = [];
        },

        handleChange(e) {
            this.ruleForm.province = codeToText[e[0]];
            this.ruleForm.city = codeToText[e[1]];
            this.ruleForm.area = codeToText[e[2]];

            // console.log(e, "所选code值");
        },
    }

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
