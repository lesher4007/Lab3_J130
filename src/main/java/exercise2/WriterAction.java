package exercise2;

import java.util.Random;

public class WriterAction extends Thread{
    private Writer writer;
    private DataBase dataBase;

    public WriterAction(Writer writer, DataBase dataBase) {
        this.writer = writer;
        this.dataBase = dataBase;
    }

    @Override
    public void run() {
        try {
            while (true) {
        writerSleep(5000);
        write();
            }
        }catch (InterruptedException e){

        }

    }
    private void writerSleep(long millis) throws InterruptedException {

            Thread.sleep(millis);


    }

    public void write() throws InterruptedException {

        int use = new Random().nextInt(10000,15000);
        int use2 = new Random().nextInt(2000,10000);
        writerSleep(use2);

        System.out.println("Писатель " +Thread.currentThread().getId()+" хочет подключится к базе. Пользуется базой: "+ dataBase.getReaderConnection()+ " читателей, "+ dataBase.getWriterConnection()+" писателей.");
        while (!dataBase.write()){
            System.out.println("Писатель " +Thread.currentThread().getId()+" ждет разрешение на подключение. Пользуется базой: "+ dataBase.getReaderConnection()+ " читателей, "+ dataBase.getWriterConnection()+" писателей.");
            writerSleep(4000);
        }


        writerSleep(use);
        dataBase.setWriterConnection(dataBase.getWriterConnection()-1);
        System.out.println("Писатель " +Thread.currentThread().getId()+" выходит из базы. Пользуется базой: "+ dataBase.getReaderConnection()+ " читателей, "+ dataBase.getWriterConnection()+" писателей.");
        Thread.currentThread().interrupt();



    }
}
