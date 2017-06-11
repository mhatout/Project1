package com.example.muhammad.ratingassistant;

import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.*;

import java.lang.*;
import java.util.ArrayList;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

     protected ViewHolder holder;
     static class ViewHolder extends RecyclerView.ViewHolder {

         protected TextView mTextView;

        private ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.my_text_view);

        }
    }
    protected MyAdapter(ArrayList<String> myDataset) {
          MainActivity.cArray2 = myDataset;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
         View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        holder = new ViewHolder(v);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        position = CDFragment.p;
        holder.mTextView.setText(MainActivity.cArray2.get(position));
        holder.mTextView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                CDFragment.view = v;
                MainActivity.fragment.setCopyFragment();
                return true;
            }
        });
    }
    public void insert(int position, String text) {
        MainActivity.cArray2.add(position, text);
        notifyItemInserted(position);
    }
    @Override
    public int getItemCount() {
        return MainActivity.cArray2.size();
    }

}
