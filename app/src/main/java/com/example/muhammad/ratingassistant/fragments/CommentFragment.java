package com.example.muhammad.ratingassistant.fragments;

import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.muhammad.ratingassistant.MainActivity;
import com.example.muhammad.ratingassistant.R;
import com.example.muhammad.ratingassistant.adapters.MyAdapter;

public class CommentFragment extends Fragment {

   public static MyAdapter adapter;

    public CommentFragment() {/* Required empty public constructor*/}


    public static CommentFragment newInstance() {
        return new CommentFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View v = inflater.inflate(R.layout.fragment_comment, container, false);
        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.recycle_view);
        mRecyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        adapter = new MyAdapter(MainActivity.cArray2);
        mRecyclerView.setAdapter(adapter);
        return v;
    }
    @Override
    public void onAttach(Context context) {super.onAttach(context);}
    @Override
    public void onDetach() {super.onDetach();}

    public void performCopy(String text){
        ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text",text);
        clipboard.setPrimaryClip(clip);
    }
}
