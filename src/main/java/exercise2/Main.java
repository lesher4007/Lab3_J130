package exercise2;

import exercise1.ConsumerAction;

public class Main {
    public static void main(String[] args) {

        DataBase dataBase =new DataBase();

        for (int i = 0; i < 10; i++) {
            Reader reader = new Reader();
            ReaderAction readerAction = new ReaderAction(reader, dataBase);
            readerAction.start();
        }
        for (int i = 0; i < 2; i++) {
            Writer writer = new Writer();
            WriterAction writerAction = new WriterAction(writer, dataBase);
            writerAction.start();
        }






    }
}
