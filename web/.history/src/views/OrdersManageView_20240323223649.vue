<template>
    <NavBar />
    <ContentField v-if="isLoaded">
        <table class="table table-hover align-middle">
            <thead>
                <tr>
                    <th scope="col">用户名</th>
                    <th scope="col">订单编号</th>
                    <th scope="col">产品</th>
                    <th scope="col">支出</th>
                    <th scope="col">下单时间</th>
                    <th scope="col">收货地址</th>
                    <th scope="col">状态</th>
                    <th scope="col">支付方式</th>
                    <th scope="col">操作</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="order in orderlist" :key="order.orderId">
                    <th scope="row">{{ order.username }}</th>
                    <td>{{ order.orderId }}</td>
                    <td>{{ order.product }}</td>
                    <td>￥{{ order.cost }}</td>
                    <td>{{ order.submittime }}</td>
                    <td>{{ order.address }}</td>
                    <td>{{ order.status }}</td>
                    <td>{{ order.payway }}</td>
                    <td>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#modify-orderinfo-btn">修改</button>
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
import $ from 'jquery'
import { ref } from "vue";
import { useStore } from "vuex";

export default {
    components: {
        NavBar,
        ContentField,
    },

    setup() {
        const store = useStore();
        const isLoaded = ref(false);
        const orderlist = ref([]);


        const refresh = () => {
            $.ajax({
                url: "http://127.0.0.1:3000/api/order/getlist/",
                type: "get",
                headers: {
                    Authorization:
                        "Bearer " +
                        store.state.user.token,
                },
                success(resp) {
                    console.log(resp.result)
                    orderlist.value = resp.result;
                    console
                    isLoaded.value = true;
                }, error() {
                    console.log("失败")
                }
            })
        }

        refresh();

        return {
            store,
            orderlist,
            refresh,
            isLoaded
        }
    }

}
</script>


<style scoped></style>