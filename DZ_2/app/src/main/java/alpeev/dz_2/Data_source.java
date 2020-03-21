package alpeev.dz_2;

class Data_source {

    private static Data_source sInstance;

    private int quantity = 100;

    int getData(){
        return quantity;
    }

    void setData(int n){
         quantity = n;
    }

    synchronized static Data_source getInstance(){
        if(sInstance == null){
            sInstance = new Data_source();
        }
        return sInstance;
    }
}
