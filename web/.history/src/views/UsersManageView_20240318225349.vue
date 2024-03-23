<template>
    <NavBar />
    <ContentField v-if="userlist.isLoaded">

        <!-- delete Modal -->
        <div class="modal fade" id="delete-Modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel" style="text-align: center;">确认删除</h5>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" @click="deleteUser(deleteUserId)">删除</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- 创建Modal -->
        <div class="modal fade" id="modify-userinfo-btn" tabindex="-1">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">修改</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <label for="add-bot-title" class="form-label">姓名</label>
                            <input type="text" class="form-control" id="add-bot-title" placeholder="请输入姓名">
                        </div>
                        <div class="mb-3">
                            <label for="add-bot-description" class="form-label">性别</label>
                            <textarea class="form-control" id="add-bot-description" rows="3"
                                placeholder="请输入性别"></textarea>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="error-message">
                            <!-- {{ botadd.error_message }} -->
                        </div>
                        <button type="button" class="btn btn-primary" @click="usersModify">提交</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>

        <table class="table table-hover align-middle">
            <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">姓名</th>
                    <th scope="col">性别</th>
                    <th scope="col">手机号</th>
                    <th scope="col">住址</th>
                    <th scope="col">电子邮箱</th>
                    <th scope="col">邮政编码</th>
                    <th scope="col">provinceId</th>
                    <th scope="col">countryId</th>
                    <th scope="col">管理</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="user in userlist" :key="user.userId">
                    <th scope="row">{{ user.userId }}</th>
                    <td>{{ user.name }}</td>
                    <td>{{ user.sex }}</td>
                    <td>{{ user.phone }}</td>
                    <td>{{ user.address }}</td>
                    <td>{{ user.email }}</td>
                    <td>{{ user.zipcode }}</td>
                    <td>{{ user.provinceId }}</td>
                    <td>{{ user.countryId }}</td>
                    <td>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#modify-userinfo-btn">修改</button>
                        <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                            data-bs-target="#delete-Modal" @click="setDeleteUserId(user.userId)">删除</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </ContentField>



</template>

<script>
import NavBar from "@/components/NavBar.vue";
import ContentField from "@/components/ContentField.vue";
import { Modal } from 'bootstrap/dist/js/bootstrap';
import { ElMessage } from 'element-plus'
import { ref } from "vue";
import { useStore } from "vuex";

import $ from 'jquery';

export default {
    components: {
        NavBar,
        ContentField
    },
    setup() {
        const store = useStore();
        const userlist = ref({
            userId: '',
            name: '',
            sex: '',
            address: '',
            email: '',
            zipcode: '',
            phone: '',
            provinceId: '',
            countryId: '',
            isLoaded: false,
        });

        const deleteUserId = ref(0);

        const refresh_users = () => {
            $.ajax({
                url: "http://127.0.0.1:3000/api/user/account/getlist/",
                type: "get",
                headers: {
                    Authorization:
                        "Bearer " +
                        store.state.user.token,
                },
                success(resp) {
                    userlist.value = resp.result;
                    userlist.value.isLoaded = true;
                    console.log(resp.result)
                }, error() {
                    console.log("失败")
                }
            })
        }

        refresh_users();

        const usersModify = () => {
            alert("提交成功");
            Modal.getInstance("#modify-userinfo-btn").hide();
            refresh_users();
        }

        const setDeleteUserId = id => {
            deleteUserId.value = id;
        }

        const deleteUser = id => {
            console.log(id);
            $.ajax({
                url: "http://127.0.0.1:3000/api/user/account/deleteuserinfo/",
                type: "post",
                data: {
                    id: id
                },
                headers: {
                    Authorization:
                        "Bearer " +
                        store.state.user.token,
                },
                success(resp) {
                    if (resp.error_message === 'success') {
                        ElMessage.success('删除成功');
                        refresh_users();
                    } else {
                        ElMessage.error('删除失败')
                    }
                    Modal.getInstance("#delete-Modal").hide();
                }, error() {
                    ElMessage.error('删除失败')
                    Modal.getInstance("#delete-Modal").hide();
                }
            })
        }



        return {
            userlist,
            usersModify,
            deleteUser,
            deleteUserId,
            setDeleteUserId
        }
    }

}
</script>


<style scoped></style>