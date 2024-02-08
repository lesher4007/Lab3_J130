package exercise1;

import java.util.Random;

public class ProviderAction implements Runnable {

    private Stock stock;

    public ProviderAction(Stock stock) {
        this.stock = stock;
    }

    public void goodsSupply(){


        stock.supply( new Random().nextInt(30,40));
        System.out.println("Постовщик " +Thread.currentThread().getId()+" грузит товар на склад: "+ stock.getStore()+" штук.");
        providerSleep(new Random().nextInt(8000,10000));
        System.out.println("Постовщик " +Thread.currentThread().getId()+" отправляются за новой партией товара ");


    }

    private void providerSleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true){
            goodsSupply();
        }
    }
}
