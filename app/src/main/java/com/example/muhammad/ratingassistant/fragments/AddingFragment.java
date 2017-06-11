package com.example.muhammad.ratingassistant.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.muhammad.ratingassistant.MainActivity;
import com.example.muhammad.ratingassistant.R;


public class AddingFragment extends Fragment {


    public AddingFragment() {}
    // TODO: Rename and change types and number of parameters
    public static AddingFragment newInstance() {
        AddingFragment fragment = new AddingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_adding, container, false);
        Button savebtn = (Button) v.findViewById(R.id.savebtn);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText eText = (EditText) getActivity().findViewById(R.id.plain_text_input);
                if (eText.getText().toString().trim().length() > 0 ){
                MainActivity.cArray2.add(eText.getText().toString());
                setFragment();}else {
                    Toast.makeText(getActivity(),"Type some thing",Toast.LENGTH_LONG ).show();}
            }
        });
        return v;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
    private void setFragment(){
        MainActivity.fragment = new CommentFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer , MainActivity.fragment).addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }
}
