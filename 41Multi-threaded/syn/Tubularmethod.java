package syn;
//本节演示多线程的通信方案一：管道通信
//本节主要用到的方法是：
//1.wait()方法：使线程暂停，直到其他线程调用notify()方法或notifyAll()方法唤醒。
/*
* 管道通信(介绍)：
* 消费者 --- 消费商品
* 生成者 --- 生成商品
* 缓冲区 --- 存储商品[当缓冲区没有商品时候，消费者等待，当缓冲区有商品时候，生成者等待]
* */
public class Tubularmethod {
    public static void main(String[] args) {
        Buffer buffer =new  Buffer();
        new  Thread(new Consumer(buffer)).start();
        new  Thread(new Producer(buffer)).start();


    }
}
//商品
class Goods {
    int id;//商品id
    String name; //商品名称
    //构造器
    Goods(int id,String name ){
        this.id=id;
        this.name=name;
    }
}
// 缓冲区
class Buffer {
    int size=0;//当前缓冲区的商品数量
    Goods[] goods= new Goods[10];//仓库只能放下十个商品
    //生产方法
    public synchronized void pushGoods(Goods g) throws InterruptedException {
        if(size==goods.length){
        //    在这里仓库就满了生产者就等待别生产了
            wait();
        }
        //    在这里说明仓库不满生产者可以生产了
        goods[size]=g;//把商品放到仓库里面
        size++;//索引加加
        //    通知消费者可以消费了我放入了一个商品谁先来给谁
        notify();
    }
    //消费方法
    public synchronized Goods putGood() throws InterruptedException{
        //如果仓库没有商品等待生产
        if(size==0){
            wait();
        }
        //如果仓库有商品可以直接消费
        Goods g =goods[--size];
        //消费者消费了通知生产者生产商品
        notify();
        return g;
    }
}


// 消费者
class Consumer implements Runnable{
    Buffer buffer;

    public Consumer (Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            try {
                Goods g= buffer.putGood();
                System.out.println("消费者消费了"+g.id+"商品");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
//生产者
class Producer implements Runnable{
    Buffer buffer;

    public Producer (Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            Goods G= new Goods(i,i+"");
            try {
                buffer.pushGoods(G);
                System.out.println("生产者生产了"+i+"商品");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
