package com.example.muhammad.ratingassistant.adapters;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.*;
import com.example.muhammad.ratingassistant.MainActivity;
import com.example.muhammad.ratingassistant.OnSwipeTouchListener;
import com.example.muhammad.ratingassistant.R;
import com.example.muhammad.ratingassistant.fragments.CommentFragment;

import java.lang.*;
import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

     static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView mTextView;

        private ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.my_text_view);

        }
    }
    public MyAdapter(ArrayList<String> myDataset) {
          MainActivity.cArray2 = myDataset;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
         View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final int p =position;
        holder.mTextView.setText(MainActivity.cArray2.get(position));
        holder.mTextView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
               MainActivity.fragment.performCopy(holder.mTextView.getText().toString());
                Toast.makeText(v.getContext(),"Text Copied" , Toast.LENGTH_LONG).show();
                return true;
            }
        });
        /*holder.mTextView.setOnTouchListener(new OnSwipeTouchListener(MainActivity.fragment.getActivity()){
            public void onSwipeLeft() {
                MainActivity.cArray2.remove(p);
                notifyItemRemoved(p);
                notifyItemRangeChanged(p, MainActivity.cArray2.size());
            }
        });*/
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
