<template>
    <header class="HeaderWrapper">
        <div class="HeaderList">
            <div class="leftNav">
                <span v-for="(item, index) in navItems" :key="item.id" @click="setActive(item.id)" class="nav-item">
                    {{ item.name }}
                </span>
                <div class="active-bar" :style="activeBarStyle"></div>
            </div>
            <div class="rightNav">
                <input type="text" placeholder="搜索">
                <template v-if="isLogin">
                    <div class="userinfo">userinfo</div>

                </template>
                <template v-else>
                    <div class="loginbox">
                        <RouterLink to="/login" style="color: white; text-decoration: none;">请登录</RouterLink>

                    </div>
                </template>

            </div>
        </div>
    </header>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue';
import { storeToRefs } from 'pinia'
import { useUserStore } from '../../store/User.ts'
const userStore = useUserStore()
const { isLogin } = storeToRefs(userStore)

interface NavItem {
    id: number;
    name: string;
    path: string;
}

const navItems = ref<NavItem[]>([
    { id: 0, name: '微头条', type: '/' },
    { id: 1, name: '新闻', type: '/about' },
    { id: 2, name: '体育', type: '/about' },
    { id: 3, name: '娱乐', type: '/about' },
    { id: 4, name: '科技', type: '/about' },
    { id: 5, name: '其他', type: '/about' },
]);

const isActive = ref<number>(0);

function setActive(id: number) {
    isActive.value = id;
    console.log(id)
}

// 计算属性，用于动态计算横条的位置和宽度
const activeBarStyle = computed(() => {
    const activeItem = navItems.value.find(item => item.id === isActive.value);

    if (activeItem) {
        const index = navItems.value.indexOf(activeItem);
        const itemWidth = 100 / navItems.value.length; // 每个导航项的宽度百分比
        const left = index * itemWidth; // 计算横条的左侧位置

        return {
            width: `${itemWidth}%`,
            left: `${left}%`,
            transition: 'left 0.3s ease', // 添加过渡效果
        };
    }

    return {
        width: '0%',
        left: '0%',
    };
});
</script>

<style scoped>
.HeaderWrapper {
    width: 100%;
    height: 70px;
    box-sizing: border-box;
    background-color: #212529;
    display: flex;
    justify-content: center;
    align-items: center;
}

.HeaderList {
    width: 1226px;
    height: 100%;
    display: flex;
    align-items: center;
}

.leftNav {
    cursor: pointer;
    width: 50%;
    height: 100%;
    display: flex;
    position: relative;
    /* 为了 positioning active-bar 提供上下文 */
}

.nav-item {
    flex: 1;
    /* 每个导航项平分宽度 */
    color: white;
    font-size: 20px;
    font-weight: 800;
    text-align: center;
    /* 居中 */
    padding: 15px 0;
    /* 添加上下内边距 */
    text-decoration: none;
    /* 去掉链接下划线 */
}

.active-bar {
    position: absolute;
    /* 绝对定位横条 */
    height: 4px;
    /* 横条高度 */
    background-color: #007bff;
    /* 横条颜色 */
    bottom: 0;
    /* 在导航项底部对齐 */
    transition: left 0.3s ease, width 0.3s ease;
    /* 动画效果 */
}

.rightNav {
    cursor: pointer;
    width: 50%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
}

.rightNav input {
    padding: 10px 15px;
    border: none;
    border-radius: 24px;
    outline: none;
    background-color: #343a40;
    color: white;
    font-size: 16px;
    transition: background-color 0.3s;
}

.rightNav input::placeholder {
    color: #ffffff;
}

.rightNav input:hover,
.rightNav input:focus {
    background-color: #495057;
}

.userinfo {
    margin-left: 100px;
}

.loginbox {
    color: white !important;
    margin-left: 100px;
}
</style>
