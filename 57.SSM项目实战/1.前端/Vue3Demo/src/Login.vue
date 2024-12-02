<template>
    <div class="container">
        <div class="form-wrapper" :class="{ 'form-wrapper-register': !isLogin }">
            <div class="form-header">
                <h2>{{ isLogin ? '欢迎回来' : '创建账号' }}</h2>
                <p class="subtitle">{{ isLogin ? '很高兴再次见到您' : '开始您的旅程' }}</p>
            </div>

            <form @submit.prevent="handleSubmit" class="form-content">
                <div class="form-group">
                    <input type="email" v-model="email" required />
                    <label :class="{ 'label-float': email }">邮箱地址</label>
                    <span class="focus-border"></span>
                </div>

                <div class="form-group">
                    <input type="password" v-model="password" required />
                    <label :class="{ 'label-float': password }">密码</label>
                    <span class="focus-border"></span>
                </div>

                <transition name="slide-fade">
                    <div v-if="!isLogin" class="form-group">
                        <input type="password" v-model="confirmPassword" required />
                        <label :class="{ 'label-float': confirmPassword }">确认密码</label>
                        <span class="focus-border"></span>
                    </div>
                </transition>

                <button type="submit" class="submit-button">
                    <span>{{ isLogin ? '登录' : '注册' }}</span>
                    <i class="arrow"></i>
                </button>
            </form>

            <p class="toggle">
                {{ isLogin ? '还没有账号?' : '已有账号?' }}
                <span @click="toggleForm" class="toggle-link">
                    {{ isLogin ? '立即注册' : '立即登录' }}
                </span>
            </p>
        </div>
    </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from './store/User';

const router = useRouter();
const userStore = useUserStore();

const isLogin = ref(true);
const email = ref('');
const password = ref('');
const confirmPassword = ref('');

const toggleForm = () => {
    isLogin.value = !isLogin.value;
    email.value = '';
    password.value = '';
    confirmPassword.value = '';
};

const handleSubmit = async () => {
    if (isLogin.value) {
        try {
            // 这里添加实际的登录逻辑
            console.log('登录:', { email: email.value, password: password.value });
            router.push('/');
        } catch (error) {
            console.error('登录失败:', error);
        }
    } else {
        if (password.value !== confirmPassword.value) {
            alert('密码不匹配！');
            return;
        }
        // 这里添加实际的注册逻辑
        console.log('注册:', { email: email.value, password: password.value });
    }
};
</script>

<style scoped lang="scss">
.container {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    padding: 20px;
}

.form-wrapper {
    background: rgba(255, 255, 255, 0.95);
    padding: 40px;
    border-radius: 20px;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    width: 400px;
    max-width: 90%;
    transform-origin: center;
    animation: formAppear 0.6s ease-out;
}

.form-header {
    text-align: center;
    margin-bottom: 40px;

    h2 {
        color: #2d3748;
        font-size: 28px;
        margin-bottom: 10px;
    }

    .subtitle {
        color: #718096;
        font-size: 16px;
    }
}

.form-group {
    position: relative;
    margin-bottom: 30px;

    input {
        width: 100%;
        padding: 12px 0;
        font-size: 16px;
        color: #2d3748;
        border: none;
        border-bottom: 2px solid #e2e8f0;
        background: transparent;
        transition: all 0.3s ease;

        &:focus {
            outline: none;
            border-bottom-color: #667eea;
        }
    }

    label {
        position: absolute;
        left: 0;
        top: 15px;
        color: #a0aec0;
        font-size: 16px;
        transition: all 0.3s ease;
        pointer-events: none;
    }

    .label-float,
    input:focus+label {
        top: -10px;
        font-size: 14px;
        color: #667eea;
    }

    .focus-border {
        position: absolute;
        bottom: 0;
        left: 0;
        width: 0;
        height: 2px;
        background-color: #667eea;
        transition: 0.4s;
    }

    input:focus~.focus-border {
        width: 100%;
    }
}

.submit-button {
    width: 100%;
    padding: 15px;
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    color: white;
    border: none;
    border-radius: 10px;
    font-size: 16px;
    font-weight: 600;
    cursor: pointer;
    transition: transform 0.3s ease, box-shadow 0.3s ease;
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 10px;

    &:hover {
        transform: translateY(-2px);
        box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
    }

    .arrow {
        border: solid white;
        border-width: 0 2px 2px 0;
        display: inline-block;
        padding: 3px;
        transform: rotate(-45deg);
        transition: transform 0.3s ease;
    }

    &:hover .arrow {
        transform: rotate(-45deg) translate(3px, 3px);
    }
}

.toggle {
    text-align: center;
    margin-top: 25px;
    color: #718096;

    .toggle-link {
        color: #667eea;
        cursor: pointer;
        font-weight: 600;
        margin-left: 5px;
        transition: color 0.3s ease;

        &:hover {
            color: #764ba2;
        }
    }
}

// 动画
@keyframes formAppear {
    from {
        opacity: 0;
        transform: translateY(20px);
    }

    to {
        opacity: 1;
        transform: translateY(0);
    }
}

.slide-fade-enter-active,
.slide-fade-leave-active {
    transition: all 0.3s ease;
}

.slide-fade-enter-from,
.slide-fade-leave-to {
    transform: translateY(-20px);
    opacity: 0;
}

// 响应式设计
@media (max-width: 480px) {
    .form-wrapper {
        padding: 20px;
    }

    .form-header h2 {
        font-size: 24px;
    }
}
</style>