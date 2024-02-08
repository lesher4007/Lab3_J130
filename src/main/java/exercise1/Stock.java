package exercise1;

public class Stock {

    private int store = 50;

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public boolean purchase(int goods){
        int store=this.store;
        boolean res;

        if(this.store>goods){
            this. store-=goods;
            res= true;
            System.out.println("Покупатель " +Thread.currentThread().getId()+" товара на складе: "+ store+" - "+goods+" = " + this.store);
        }else {
            res= false;
        }

        return res;

    }

    public boolean supply(int goods){
        store+=goods;
        return true;
    }

}
