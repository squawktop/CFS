<template>

    <NavBar></NavBar>
    <div class="container-fluid"> <!-- 使用Bootstrap的.container类 -->

        <div class="row">
            <div class="col-2 left">
                <div class="accordion" id="accordionExample">
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="headingOne">
                            <button class="accordion-button" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                首页
                            </button>
                        </h2>
                        <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne"
                            data-bs-parent="#accordionExample">
                            <div class="accordion-body">
                                item1
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="headingTwo">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                用户中心
                            </button>
                        </h2>
                        <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo"
                            data-bs-parent="#accordionExample">
                            <div class="accordion-body">
                                item2
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="headingThree">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                管理中心
                            </button>
                        </h2>
                        <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree"
                            data-bs-parent="#accordionExample">
                            <div class="accordion-body">
                                分类管理
                            </div>
                        </div>
                        <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree"
                            data-bs-parent="#accordionExample">
                            <div class="accordion-body">
                                地址管理
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-10" style="background-color: red;">k</div>
        </div>
    </div>
</template>

<script>
import NavBar from "@/components/NavBar.vue";

// import { useStore } from 'vuex';
// import { ref } from "vue";
// import $ from 'jquery'
// import router from "@/router";


export default {
    components: {
        NavBar,

    }, setup() {

    }

}

</script>


<style scoped>
/* .row >.left  div {
    background-color: #212529;
}

.row>.left button {
    color:white;
    background-color: #212529;
}
.row>.left h2 {
    color: white;
    background-color: #212529;
} */

.row>* {
    padding-left: 0;
    padding-right: 5px;
}
</style>
