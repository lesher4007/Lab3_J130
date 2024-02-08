package exercise2;

import java.util.Random;

public class ReaderAction extends Thread{

    private Reader reader;
    private DataBase dataBase;

    public ReaderAction(Reader reader, DataBase dataBase) {
        this.reader = reader;
        this.dataBase = dataBase;
    }

    @Override
    public void run() {
        try {
            while (true) {
                readerSleep(4000);
                reed();
            }
        }catch (InterruptedException e){

        }

    }
    private void readerSleep(long millis) throws InterruptedException {

            Thread.sleep(millis);

    }

    public void reed() throws InterruptedException {

        int use = new Random().nextInt(5000,9000);

        System.out.println("Читатель " +Thread.currentThread().getId()+" хочет подключится к базе.");
        while (!dataBase.reed()){
            System.out.println("Читатель " +Thread.currentThread().getId()+" ждет разрешение на подключение.");
            readerSleep(4000);
        }
        readerSleep(use);
        dataBase.setReaderConnection(dataBase.getReaderConnection()-1);
        System.out.println("Читатель " +Thread.currentThread().getId()+" выходит из базы.");
        Thread.currentThread().interrupt();
    }

}

