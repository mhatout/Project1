package com.example.muhammad.ratingassistant;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

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
    public void save(String fileName , ArrayList<String> array) throws IOException {
        FileOutputStream fout= new FileOutputStream (fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(array);
        fout.close();
    }
    public void read(String fileName ) throws IOException, ClassNotFoundException {
        FileInputStream fin= new FileInputStream (fileName);
        ObjectInputStream ois = new ObjectInputStream(fin);
        String[] array= (String[]) ois.readObject();
        cArray2 = new ArrayList<>(Arrays.asList(array));
        fin.close();
    }
}
