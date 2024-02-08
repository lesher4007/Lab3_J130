package exercise1;

public class Main {
    public static void main(String[] args) {

        Stock stock = new Stock();

        for (int i = 0; i < 10; i++) {
            Consumer consumer = new Consumer();
            ConsumerAction consumerAction = new ConsumerAction(consumer, stock);
            consumerAction.start();
        }
        for (int i = 0; i < 2; i++) {
            ProviderAction providerAction = new ProviderAction(stock);
            Thread thread = new Thread(providerAction);
            thread.start();
        }

    }
}
