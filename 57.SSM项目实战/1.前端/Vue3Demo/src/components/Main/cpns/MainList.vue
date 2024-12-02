<template>
    <div class="mainWrapper">
        <div class="MainListWrapper">
            <template v-for="(item, index) in MainList">
                <div class="ListBox">
                    <div class="item">Title:{{ item.title }}</div>
                    <div class="item">Count: {{ item.content }}</div>
                    <div class="item">Time: {{ item.date }}</div>
                    <div class="item">View Count: {{ item.view }}</div>
                    <button class="ViewAllButton">View All</button>
                </div>
            </template>
        </div>
    </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
interface MainList {
    id: number
    title: string
    content: string
    date: string
    view: number
}
const MainList = ref<MainList[]>([
    {
        id: 1,
        title: '标题1',
        content: '内容1',
        date: '2022-01-01',
        view: 999
    },
    {
        id: 2,
        title: '标题2',
        content: '内容2',
        date: '2022-01-02',
        view: 999
    },
    {
        id: 3,
        title: '标题3',
        content: '内容3',
        date: '2022-01-03',
        view: 999
    }
])



</script>

<style scoped lang="less">
.mainWrapper {
    width: 100%;
}

.MainListWrapper {
    width: 1226px;
    margin: 0 auto;
    display: flex;
    flex-wrap: wrap;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.ListBox {
    padding: 30px;
    width: 50%;
    border-radius: 20px;
    border: 1px solid #eee;
    margin-top: 30px;
    margin-bottom: 30px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    /* 添加阴影效果 */
}

.item {
    margin-top: 20px;
    margin-bottom: 20px;
    font-size: 18px;
}

.ViewAllButton {
    margin-top: 20px;
    padding: 10px 20px;
    /* 内边距 */
    background-color: #007bff;
    /* 按钮背景颜色 */
    color: white;
    /* 字体颜色 */
    border: none;
    /* 去掉默认边框 */
    border-radius: 5px;
    /* 圆角 */
    font-size: 16px;
    /* 字体大小 */
    cursor: pointer;
    /* 鼠标悬停指针 */
    transition: background-color 0.3s ease, transform 0.2s ease;
    /* 过渡效果 */
}

.ViewAllButton:hover {
    background-color: #0056b3;
    /* 悬停时的背景颜色 */
    transform: translateY(-2px);
    /* 悬停时抬起效果 */
}

.ViewAllButton:active {
    transform: translateY(0);
    /* 点击时返回原位 */
}
</style>
