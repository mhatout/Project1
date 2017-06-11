package com.example.muhammad.ratingassistant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class CDFragment extends Fragment {
    protected static int p ;
    public static View view;
    public CDFragment() {}
    public static CDFragment newInstance() {
        CDFragment fragment = new CDFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cd, container, false);
        Button cpbtn = (Button) v.findViewById(R.id.copybtn);
        Button dlbtn = (Button) v.findViewById(R.id.deletbtn);
        cpbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                view = v;
                MainActivity.fragment.performCopy(CommentFragment.adapter.holder.mTextView.getText().toString());
                Toast.makeText(v.getContext(),"Text Copied" , Toast.LENGTH_LONG).show();
                setFragment();

            }
        });
        dlbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.cArray2.remove(p);
                CommentFragment.adapter.notifyItemRemoved(p);
                CommentFragment.adapter.notifyItemRangeChanged(p, MainActivity.cArray2.size());
                setFragment();
            }
        });
        return v;
    }
    private void setFragment(){
        MainActivity.fragment = new CommentFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer , MainActivity.fragment).addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }
}
