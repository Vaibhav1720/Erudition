package com.example.fisherieserudition;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.viewHolder> {

    ArrayList<PdfModel> list;
    Context context;
    ItemClickListener itemClickListener;


    public PdfAdapter(ArrayList<PdfModel> list, Context context, ItemClickListener itemClickListener)
    {
        this.list = list;
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public PdfAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_card, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PdfAdapter.viewHolder holder, int position) {

        PdfModel model = list.get(position);
        holder.imageView.setImageResource(model.getImage());
        holder.textView.setText((model.getText()));
//
//        @Override
//        public void onClick(View view) {
//            itemClickListener.onClick(view,position);
//        }
//
//
        holder.imageView.setOnClickListener((v)->{
            Toast.makeText(context,"Image is Clicked",Toast.LENGTH_SHORT).show();
            itemClickListener.onClick(v,position);
        });

        holder.textView.setOnClickListener((v)->{
            Toast.makeText(context,"Text is Clicked",Toast.LENGTH_SHORT).show();
            itemClickListener.onClick(v,position);
        });

    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
        ImageView imageView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
            imageView.setOnClickListener(this);
        }

        //@Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition());
        }

    }
}
