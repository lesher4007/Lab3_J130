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
        write();

    }
    private void writerSleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void write(){

        int use = new Random().nextInt(10000,15000);

        System.out.println("Писатель " +Thread.currentThread().getId()+" хочет подключится к базе.");
        while (!dataBase.write()){
            System.out.println("Писатель " +Thread.currentThread().getId()+" ждет разрешение на подключение.");
            writerSleep(4000);
        }


        writerSleep(use);
        dataBase.setWriterConnection(dataBase.getWriterConnection()-1);
        System.out.println("Писатель " +Thread.currentThread().getId()+" выходит из базы.");
        Thread.currentThread().interrupt();



    }
}
