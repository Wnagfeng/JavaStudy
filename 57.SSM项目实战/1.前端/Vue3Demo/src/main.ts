import { createApp } from 'vue';
import 'normalize.css/normalize.css';
import App from './App.vue';
import router from './router';  // 如果你使用路由
import pinia from './store';     // 引入 Pinia 实例

const app = createApp(App);
app.use(router);  // 使用 Vue Router
app.use(pinia);   // 使用 Pinia
app.mount('#app');
