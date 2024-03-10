<template>
<!-- 使用Bootstrap的.container类 -->
    <!-- <div class="container-fluid"> 
         <div class="row"> -->
            <div class="col-2 aside">
                <div class="accordion accordion-flush" id="accordionFlushExample">
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingOne">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#flush-collapseOne" aria-expanded="false"
                                aria-controls="flush-collapseOne">
                                <img src="../assets/menu.svg" alt="" style="width:20px; margin-right:5px; ">
                                首页
                            </button>
                        </h2>
                        <div id="flush-collapseOne" class="accordion-collapse collapse"
                            aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;首页</div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingTwo">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#flush-collapseTwo" aria-expanded="false"
                                aria-controls="flush-collapseTwo">
                                <img src="../assets/menu.svg" alt="" style="width:20px; margin-right:5px; ">
                                个人中心
                            </button>
                        </h2>
                        <div id="flush-collapseTwo" class="accordion-collapse collapse"
                            aria-labelledby="flush-headingTwo" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个人中心</div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingThree">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#flush-collapseThree" aria-expanded="false"
                                aria-controls="flush-collapseThree">
                                <img src="../assets/menu.svg" alt="" style="width:20px; margin-right:5px; ">
                                用户管理
                            </button>
                        </h2>
                        <div id="flush-collapseThree" class="accordion-collapse collapse"
                            aria-labelledby="flush-headingThree" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户管理</div>
                        </div>
                    </div>

                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingFour">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#flush-collapseFour" aria-expanded="false"
                                aria-controls="flush-collapseFour">
                                <img src="../assets/menu.svg" alt="" style="width:20px; margin-right:5px; ">
                                商品管理
                            </button>
                        </h2>
                        <div id="flush-collapseFour" class="accordion-collapse collapse"
                            aria-labelledby="flush-headingFour" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品分类管理</div>
                        </div>

                        <div id="flush-collapseFour" class="accordion-collapse collapse"
                            aria-labelledby="flush-headingFour" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品信息管理</div>
                        </div>

                        <div id="flush-collapseFour" class="accordion-collapse collapse"
                            aria-labelledby="flush-headingFour" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品评价管理</div>
                        </div>

                    </div>


                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingFive">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#flush-collapseFive" aria-expanded="false"
                                aria-controls="flush-collapseFive">
                                <img src="../assets/menu.svg" alt="" style="width:20px; margin-right:5px; ">
                                系统管理
                            </button>
                        </h2>
                        <div id="flush-collapseFive" class="accordion-collapse collapse"
                            aria-labelledby="flush-headingFive" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系统管理</div>
                        </div>
                    </div>

                    <div class="accordion-item">
                        <h2 class="accordion-header" id="flush-headingSix">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                                data-bs-target="#flush-collapseSix" aria-expanded="false"
                                aria-controls="flush-collapseSix">
                                <img src="../assets/menu.svg" alt="" style="width:20px; margin-right:5px; ">
                                订单管理
                            </button>
                        </h2>
                        <div id="flush-collapseSix" class="accordion-collapse collapse"
                            aria-labelledby="flush-headingSix" data-bs-parent="#accordionFlushExample">
                            <div class="accordion-body"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单管理</div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- <div class="col-10" style="background-color: red;">k</div> -->
        <!-- </div>
    </div> -->
</template>

<script>

</script>


<style scoped>
.aside{
    display: flex;
    margin-top: 20px;
}

.accordion-body {
    cursor: pointer;
    border-radius: 5%;
    
}

.accordion-body:hover {
    background-color: rgba(207, 226, 255, 0.5);
}
</style>
