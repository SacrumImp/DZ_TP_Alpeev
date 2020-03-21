package alpeev.dz_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements fragment_list.ReportListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) Data_source.getInstance().setData(savedInstanceState.getInt("quantity"));

        Fragment fragm = new fragment_list();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fram_layout, fragm)
                .commit();

    }

    public void buttonClicked(View view){
        Data_source.getInstance().setData(Data_source.getInstance().getData() + 1);
        Fragment fragmNew = new fragment_list();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fram_layout, fragmNew)
                .commit();
    }

    @Override
    public void reportMessage(int View, Fragment fram) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(View, fram)
                .addToBackStack(null)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("quantity", Data_source.getInstance().getData());
        super.onSaveInstanceState(outState);
    }
}
