package com.example.fisherieserudition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    static ArrayList<PdfModel> list;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

         list = new ArrayList<>();
        list.add(new PdfModel(R.drawable.bg4,"photo1"));
        list.add(new PdfModel(R.drawable.bg4,"Photo2"));
        list.add(new PdfModel(R.drawable.bg4,"Photo3"));
        list.add(new PdfModel(R.drawable.bg4,"Photo4"));
        list.add(new PdfModel(R.drawable.bg4,"Photo5"));
        list.add(new PdfModel(R.drawable.bg4,"Photo6"));
        list.add(new PdfModel(R.drawable.bg4,"Photo7"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view,int position) {

                Intent intent = new Intent(MainActivity.this, PdfDisplay.class);
                intent.putExtra("position",position);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"Main Activity Click" , Toast.LENGTH_SHORT).show();

            }
        };

        PdfAdapter adapter = new PdfAdapter(list,this, itemClickListener);
          recyclerView.setAdapter(adapter);
    }

}

//    ListView myListView = findViewById(R.id.myListView);
//    ArrayList<String> grocery = new ArrayList<>();
//        grocery.add("Bhindi");
//                grocery.add("Pen");
//                grocery.add("Apples");
//                grocery.add("Tea Leaves");
//
//                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, grocery);
//        myListView.setAdapter(arrayAdapter);
//
//        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//@Override
//public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//        String text = "Item" + position+ " " + ((TextView) view).getText().toString();
//        Toast.makeText(MainActivity.this,text , Toast.LENGTH_SHORT).show();
//
//        }
//        });
