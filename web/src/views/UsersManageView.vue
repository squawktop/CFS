<template>
    <NavBar />
    <ContentField>

        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">姓名</th>
                    <th scope="col">性别</th>
                    <th scope="col">手机号</th>
                    <th scope="col">住址</th>
                    <th scope="col">电子邮箱</th>
                    <th scope="col">邮政编码</th>
                    <th scope="col">管理</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <button type="button" class="btn btn-primary">Primary</button>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                    <td>@fat</td>
                    <td>@fat</td>
                    <td>@fat</td>
                    <button type="button" class="btn btn-danger">Danger</button>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td colspan="2">Larry the Bird</td>
                    <td>@twitter</td>
                    <td>@twitter</td>
                    <td>@twitter</td>
                    <td>@twitter</td>
                    <button type="button" class="btn btn-danger">Danger</button>
                </tr>
            </tbody>
        </table>

    </ContentField>



</template>

<script>
import NavBar from "@/components/NavBar.vue";
import ContentField from "@/components/ContentField.vue";

export default {
    components: {
        NavBar,
        ContentField
    },
    setup() {

    }

}
</script>


<style scoped></style>