package com.example.student_006.myrecyclerviewapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.net.ProtocolException;
import java.util.List;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {
private List<String> mData;
private LayoutInflater mlayoutInflater;
private ItemClickListener itemClickListener;

    public MyRecycleViewAdapter(Context context, List<String> mData) {
        this.mData = mData;
        this.mlayoutInflater = mlayoutInflater.from(context);
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=mlayoutInflater.inflate(R.layout.recycler_row,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
    String version=mData.get(position);
    viewHolder.myTextView.setText(version);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    void setClickListner(ItemClickListener itemClickListener)
    {
        this.itemClickListener=itemClickListener;

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView myTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myTextView=itemView.findViewById(R.id.textView1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemClickListener!=null) itemClickListener.onItemClick(view,getAdapterPosition());
        }
    }


    public interface ItemClickListener
    {
        void onItemClick(View view,int position);

    }

}

