package com.example.muhammad.ratingassistant;

import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.muhammad.ratingassistant.adapters.MyAdapter;
import com.example.muhammad.ratingassistant.fragments.AddingFragment;
import com.example.muhammad.ratingassistant.fragments.CommentFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static CommentFragment fragment;
    public static ArrayList<String>cArray2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String[]cArray = getResources().getStringArray(R.array.commentSampels);
        cArray2 = new ArrayList<String>(Arrays.asList(cArray));
        setFragment();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddingFragment frag = new AddingFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer , frag).addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
            }
        });
    }
    private void setFragment(){

        fragment = new CommentFragment();
        FragmentManager frag = getSupportFragmentManager();
        FragmentTransaction fragTransaction = frag.beginTransaction();
        fragTransaction.replace(R.id.fragmentContainer , fragment).addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }
}
