package exercise1;

import java.util.Random;

public class ConsumerAction extends Thread {

    private Consumer consumer;
    private  Stock stock;

    @Override
    public void run() {
        while (true){
            while (consumer.getProduct()>1){
                consumerSleep(4000);
                consumer.setProduct(consumer.getProduct()-new Random().nextInt(3,5));
            }
            buy();
        }
    }

    public ConsumerAction(Consumer consumer, Stock stock) {
        this.consumer = consumer;
        this.stock = stock;
    }

    public void buy(){

        int goods = new Random().nextInt(5,9);

        System.out.println("Покупатель " +Thread.currentThread().getId()+" хочет купить товар: "+ goods+" штук.");
        while (!stock.purchase(goods)){
            System.out.println("Покупатель " +Thread.currentThread().getId()+" ждет поставки товара.");
            consumerSleep(5000);
        }
        consumer.setProduct(consumer.getProduct()+goods);
        System.out.println("Покупатель " +Thread.currentThread().getId()+" купил товар: "+ goods+" штук.");
    }

    private void consumerSleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
