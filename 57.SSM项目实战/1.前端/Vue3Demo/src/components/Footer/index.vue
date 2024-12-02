<template>
    <footer class="FooterWrapper">
        <div class="FooterContent">
            <div class="links">
                <a href="#">关于我们</a>
                <a href="#">联系方式</a>
                <a href="#">服务条款</a>
                <a href="#">隐私政策</a>
            </div>
            <div class="copyright">
                <p>© 2024 CoderJoon. 保留所有权利</p>
                <p>浙ICP备xxx号-1</p>
            </div>
        </div>
    </footer>
</template>

<script setup lang="ts">
// Footer组件逻辑
</script>

<style scoped>
.FooterWrapper {
    width: 100%;
    background-color: #212529;
    padding: 30px 0;
    color: #ffffff;
    display: flex;
    justify-content: center;
}

.FooterContent {
    width: 1226px;
    text-align: center;
}

.links {
    margin-bottom: 20px;
}

.links a {
    color: #ffffff;
    text-decoration: none;
    margin: 0 15px;
    font-size: 14px;
    transition: color 0.3s;
}

.links a:hover {
    color: #007bff;
}

.copyright {
    color: #6c757d;
    font-size: 12px;
}

.copyright p {
    margin: 5px 0;
}
</style>
