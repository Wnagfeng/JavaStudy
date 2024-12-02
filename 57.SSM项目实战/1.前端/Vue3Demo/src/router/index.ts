import { createRouter, createWebHistory } from 'vue-router';

// 导入你的页面组件
import Main from '../components/Main/index.vue';
import Login from '../Login.vue';

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Main
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
