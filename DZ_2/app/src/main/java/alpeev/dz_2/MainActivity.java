package alpeev.dz_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ListFragment.ReportListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragm = new ListFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fram_layout, fragm)
                .commit();

    }

    public void buttonClicked(View view){
        DataSource.getInstance().setData(DataSource.getInstance().getData() + 1);
        RecyclerView recyclerView = findViewById(R.id.list_buttons);
        ((ListFragment.MyDataAdapter)recyclerView.getAdapter()).update();
    }

    @Override
    public void reportMessage(Fragment fram) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fram_layout, fram)
                .addToBackStack(null)
                .commit();
    }


}
