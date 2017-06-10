// Adapter LIst view example arranging in ascending and descending order

package com.example.admin.adapt;
//importing package
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
        //main class extending AppCompactActivity and View.ON ClickListner

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        //defining adapter
    ArrayAdapter<String> adapt;
        //defineing listview and button
    ListView l;
    Button ascencding,descending;
        //arrays define
    String subjects[] ={"osama", "sakib", "mj", "ilfs"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //referind component with id
        l = (ListView) findViewById(R.id.listV1);
        ascencding=(Button)findViewById(R.id.but1);
        descending=(Button)findViewById(R.id.but2);


         adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subjects);
        l.setAdapter(adapt);
        //applying on click listner
        ascencding.setOnClickListener(this);
        descending.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //logic with the button click
        if(ascencding==v){
            Arrays.sort(subjects);
         //notify after operation
            adapt.notifyDataSetChanged();


        }
        if(v==descending){
            Arrays.sort(subjects);
            List<String> list= Arrays.asList(subjects);
            Collections.reverse(list);
            adapt.notifyDataSetChanged();
        }
    }
}



