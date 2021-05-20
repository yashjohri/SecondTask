package com.johri.secondtask.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.johri.secondtask.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyHolder> {

    private Context context;
    private ArrayList<String> labelList;
    private HashMap<Integer, Boolean> checkedMap;

    public ListAdapter(Context context, ArrayList<String> labelList) {
        this.context = context;
        this.labelList = labelList;
        this.checkedMap = new HashMap<>();
    }

    @NonNull
    @Override
    public ListAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.MyHolder holder, int position) {
        holder.tvLabel.setText(labelList.get(position));
        if(checkedMap.get(position)==null || !checkedMap.get(position)){
            holder.checkBox.setChecked(false);
        }
        else{
            holder.checkBox.setChecked(true);
        }
    }

    @Override
    public int getItemCount() {
        return labelList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        CheckBox checkBox;
        TextView tvLabel;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.checkbox);
            tvLabel = itemView.findViewById(R.id.tvLabel);

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkedMap.put(getAbsoluteAdapterPosition(), checkBox.isChecked());
                }
            });
        }
    }

    public void deleteLabels(){
        ArrayList<String> temp = new ArrayList<>();
        for(int i=0; i<labelList.size(); i++){
            if(checkedMap.get(i)==null || !checkedMap.get(i)){
                temp.add(labelList.get(i));
            }
        }
        labelList.clear();
        checkedMap.clear();
        labelList.addAll(temp);
        notifyDataSetChanged();
    }
}
