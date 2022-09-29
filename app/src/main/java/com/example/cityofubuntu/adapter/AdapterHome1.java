package com.example.cityofubuntu.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cityofubuntu.R;
import com.example.cityofubuntu.data.DataHome;
import com.example.cityofubuntu.data.Donnee;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterHome1 extends RecyclerView.Adapter<AdapterHome1.MyViewHolder> {

    public Context mcontext;
    private ArrayList<DataHome> dataSet;
    public OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public AdapterHome1(Context context, ArrayList<DataHome> data) {
        this.mcontext = context;
        this.dataSet = data;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName1);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(mcontext)
                .inflate(R.layout.cards_layout1, parent, false);

        // view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        DataHome dataHome = dataSet.get(listPosition);
        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataHome.getNomrayon());
        Log.i("IMAGEPHAT",Donnee.PATH+dataHome.getNameImageUSer());
        Picasso.get().load(Donnee.PATH+dataHome.getNameImageUSer()).placeholder(R.drawable.ic_launcher_background).fit().centerInside().into(imageView);

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
