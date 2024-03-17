<template>
    <NavBar></NavBar>
    <ContentField>
        <table class="table table-striped table-hover align-middle" v-if="products.isLoaded">
            <thead>
                <tr>
                    <th scope=" col">id</th>
                    <th scope="col">name</th>
                    <th scope="col">brand</th>
                    <th scope="col">size</th>
                    <th scope="col">color</th>
                    <th scope="col">season</th>
                    <th scope="col">style</th>
                    <th scope="col">cloth</th>
                    <th scope="col">amount</th>
                    <th scope="col">price</th>
                    <th scope="col">uptime</th>
                    <th scope="col">description</th>
                    <th scope="col"> img </th>
                    <th scope="col">操作</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="product in products" :key="product.productId">
                    <th scope="row">{{ product.productId }}</th>
                    <td style="font-size: 14px;">{{ product.name }}</td>
                    <td>{{ product.brand }}</td>
                    <td>{{ product.size }}</td>
                    <td>{{ product.color }}</td>
                    <td>{{ product.season }}</td>
                    <td>{{ product.style }}</td>
                    <td>{{ product.cloth }}</td>
                    <td>{{ product.amount }}</td>
                    <td>￥{{ product.price }}</td>
                    <td>{{ product.uptime }}</td>
                    <td style="font-size: 14px;">{{ product.description }}</td>
                    <td> <img :src="product.image" alt="" style="width: 50px;"></td>
                    <td>
                        <button type="button" class="btn btn-primary btn-sm">修改</button>
                        <button type="button" class="btn btn-danger btn-sm">删除</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </ContentField>

</template>

<script>
import NavBar from "@/components/NavBar.vue";
import ContentField from "@/components/ContentField.vue";
import { ref } from "vue";
import { useStore } from "vuex";
import $ from 'jquery'


export default {
    components: {
        NavBar,
        ContentField,
    },

    setup() {
        const store = useStore();

        const products = ref({
            productId: "",
            name: "",
            brand: "",
            size: "",
            color: "",
            season: "",
            style: "",
            cloth: "",
            amount: "",
            price: "",
            uptime: "",
            description: "",
            image: "",
            providerId: "",
            categoryId: "",
            isLoaded: false,
        });




        $.ajax({
            url: "http://127.0.0.1:3000/api/product/getlist/",
            type: "get",
            headers: {
                Authorization:
                    "Bearer " +
                    store.state.user.token,
            },
            success(resp) {
                console.log(resp.result)
                products.value = resp.result;
                products.value.isLoaded = true; console.log(products.value.isLoaded)
            }, error() {
                console.log("失败")
            }
        })
        return {
            products,
        }
    }

}

</script>


<style scoped>
[v-cloak]:not(body) {
    display: none;
}
</style>
