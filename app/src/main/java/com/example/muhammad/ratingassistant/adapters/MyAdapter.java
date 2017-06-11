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

<<<<<<< HEAD
import static java.security.AccessController.getContext;
=======
import java.lang.*;
import java.util.ArrayList;
>>>>>>> 74da99bef97808310d59d635549d6fca3af89cbe


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
<<<<<<< HEAD


=======
               MainActivity.fragment.performCopy(holder.mTextView.getText().toString());
>>>>>>> 74da99bef97808310d59d635549d6fca3af89cbe
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
    private void performCopy(){
        ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", holder.mTextView.getText().toString());
        clipboard.setPrimaryClip(clip);
    }
}
