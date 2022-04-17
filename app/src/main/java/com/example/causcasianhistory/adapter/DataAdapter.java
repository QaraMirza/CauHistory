package com.example.causcasianhistory.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.causcasianhistory.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataHolder> {

    private Context context;
    private RecOnClickListener recOnClickListener;
    private List<ListItem> listItemArray;
    private TextView textView;
    private TextView titleView;
    private ImageView imageView;

    public DataAdapter(Context context, RecOnClickListener recOnClickListener, List<ListItem> listItemArray) {
        this.context = context;
        this.recOnClickListener = recOnClickListener;
        this.listItemArray = listItemArray;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout ,parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        holder.setData(listItemArray.get(position));
    }

    @Override
    public int getItemCount() {
        return listItemArray.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public DataHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.itemText);
            titleView = itemView.findViewById(R.id.titleText);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }
        public void setData(ListItem item) {
            textView.setText(item.getText());
            titleView.setText(item.getTitle());
            imageView.setImageResource(item.getImage());
        };

        @Override
        public void onClick(View view) {
            recOnClickListener.onItemClicked(getAdapterPosition());
        }
    }

    public void updateList(List<ListItem> listArray) {
        listItemArray.clear();
        listItemArray.addAll(listArray);
        notifyDataSetChanged();
    }
}
