import dynamicProxy.Start;

public class Main {
    public static void main(String[] args) {
        // 静态代理
        // 作用：【代理对象】 对 【被代理对象】的某个方法执行之前或者之后加入其他的增强的逻辑！
        // 试想一下，你有一个对象里面有很多方法你在某个地方要用到这个对象了
        // 但是你已有的对象功能不够了,你需要添加几行代码才能实现你需要的功能
        // 但是你的对象你已经写好了,你懒得加了,加了有损完整性,你不想加,
        // 这时候你就需要使用静态代理,在该对象使用前或者使用后加点东西
        /**
         * 三个角色：
         * 1.抽象角色
         * 2.代理角色
         * 3.被代理角色
         * */
        Baoqiang baoqiang = new Baoqiang();
        Xiaohong xiaohong = new Xiaohong(baoqiang);
        xiaohong.LiveShow(1000);
        xiaohong.Sleep();
    }

    static class Baoqiang implements Start {
        @Override
        public void LiveShow(int money) {
            System.out.println("我是宝强，我正在直播，我要赚 " + money + " 元");
        }

        @Override
        public void Sleep() {
            System.out.println("我是宝强，我要睡觉");
        }
    }

    // 小红作为王宝强的代理对象
    static class Xiaohong implements Start {
        private Baoqiang proxyClass;

        public Xiaohong(Baoqiang baoqiang) {
            // 将传入的参数赋值给proxyClass
            this.proxyClass = baoqiang;
        }

        @Override
        public void LiveShow(int money) {
            // 计算代理收入
            System.out.println("我是小红, 我是王宝强的助力, 我给王宝强拉了一场表演赚了 " + (money - 700) + " 元");
            proxyClass.LiveShow(money-300);
        }

        @Override
        public void Sleep() {
            System.out.println("我是小红, 我要帮宝强开了酒店给他睡觉");
            proxyClass.Sleep();
        }
    }
}
