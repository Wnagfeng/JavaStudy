<template>
    <div class="AppWrapper">
        <Header></Header>
        <!-- 这里可以放主要内容 -->
        <MainList></MainList>
        <Footer></Footer>
    </div>
</template>

<script setup lang="ts">

import Header from '../Header/index'
import MainList from './cpns/MainList.vue'
import Footer from '../Footer/index'


</script>

<style scoped lang="less">
.AppWrapper {
    min-height: 100vh;
    display: flex;
    flex-direction: column;
}
</style>