package alpeev.dz_2;

class DataSource {

    private static DataSource sInstance;

    private int quantity = 100;

    int getData(){
        return quantity;
    }

    void setData(int n){
         quantity = n;
    }

    synchronized static DataSource getInstance(){
        if(sInstance == null){
            sInstance = new DataSource();
        }
        return sInstance;
    }


}
