package alpeev.dz_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragm = new fragment_list();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fram_layout, fragm)
                .commit();

    }

    public void Clickable(View view){
        Data_source.getInstance().setData(Data_source.getInstance().getData() + 1);
        Fragment fragmNew = new fragment_list();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fram_layout, fragmNew)
                .commit();
    }

}
