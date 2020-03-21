package alpeev.dz_2;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static java.lang.String.valueOf;

public class ListFragment extends Fragment {

    private ReportListener reportListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) DataSource.getInstance().setData(savedInstanceState.getInt("quantity"));

        MyDataAdapter adap;
        RecyclerView recyclerView = view.findViewById(R.id.list_buttons);
        adap = new ListFragment.MyDataAdapter(DataSource.getInstance().getData());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), getResources().getInteger(R.integer.is_horizontal)));
        recyclerView.setAdapter(adap);
    }



    class MyDataAdapter extends RecyclerView.Adapter<MyViewHolder>{

        int quantity;

        MyDataAdapter(int q){
            quantity = q;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.buttons, parent, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.but.setText(valueOf(position + 1));
            if((position % 2) == 0) holder.but.setTextColor(Color.RED);
            else holder.but.setTextColor(Color.BLUE);
        }

        @Override
        public int getItemCount() {
            return quantity;
        }

        public void update(){
            quantity = DataSource.getInstance().getData();
            notifyDataSetChanged();
        }

    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final Button but;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            but = itemView.findViewById(R.id.but);
            but.setOnClickListener(view -> {
                Fragment fram = new NumberFragment();
                Bundle bun = new Bundle();
                bun.putCharSequence("number", but.getText());
                bun.putInt("color", but.getCurrentTextColor());
                fram.setArguments(bun);
                reportListener.reportMessage(fram);
            });

        }
    }

    @Override
    public void onAttach(Context context) {
        reportListener = (ReportListener)context;
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        reportListener = null;
        super.onDetach();
    }

    public interface ReportListener{
        void reportMessage(Fragment fram);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("quantity", DataSource.getInstance().getData());
        super.onSaveInstanceState(outState);
    }

}
