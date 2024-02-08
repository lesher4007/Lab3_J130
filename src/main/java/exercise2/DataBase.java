package exercise2;

public class DataBase {

    private int readerConnection=0;

    private int writerConnection=0;


    public int getReaderConnection() {
        return readerConnection;
    }

    public void setReaderConnection(int readerConnection) {
        this.readerConnection = readerConnection;
    }

    public int getWriterConnection() {
        return writerConnection;
    }

    public void setWriterConnection(int writerConnection) {
        this.writerConnection = writerConnection;
    }



    public boolean reed(){
        boolean res;
        if(this.writerConnection!=1){
            this.readerConnection++;
            res= true;
            System.out.println("Читатель " +Thread.currentThread().getId()+" читает. Пользуется базой: "+ readerConnection+ " читателей, "+ writerConnection+" писателей.");
        }else {
            res= false;
        }
        return res;
    }

    public boolean write(){

        boolean res;
        if(this.readerConnection==0 && this.writerConnection==0){
            this.writerConnection++;
            res= true;
            System.out.println("Писатель " +Thread.currentThread().getId()+" редактирует Базу данных. Пользуется базой: "+ readerConnection+ " читателей, "+ writerConnection+" писателей.");
        }else {
            res= false;
        }
        return res;
    }
}
