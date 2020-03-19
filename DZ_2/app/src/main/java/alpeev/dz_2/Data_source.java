package alpeev.dz_2;

public class Data_source {

    private static Data_source sInstance;

    int quantity = 100;

    public int getData(){
        return quantity;
    }

    public void setData(int n){
         quantity = n;
    }

    public synchronized static Data_source getInstance(){
        if(sInstance == null){
            sInstance = new Data_source();
        }
        return sInstance;
    }
}
