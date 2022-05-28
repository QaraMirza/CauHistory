package com.example.causcasianhistory.adapter;

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

    private final RecOnClickListener recOnClickListener;
    private final List<ListItem> listItemArray;

    public DataAdapter(RecOnClickListener recOnClickListener, List<ListItem> listItemArray) {
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

        private final TextView textView;
        private final TextView titleView;
        private final ImageView imageView;

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
        }

        @Override
        public void onClick(View view) {
            recOnClickListener.onItemClicked(getAdapterPosition());
        }
    }

}
