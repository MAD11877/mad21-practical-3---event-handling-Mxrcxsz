package com.example.practical2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this)
                .setTitle("Profile")
                .setMessage("MADness")
                .setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int i){
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int i){
                        Random ran = new Random();
                        int x = 0;
                        String value = "";
                        for(int y = 0; y < 10; y++){
                            x = ran.nextInt(10);
                            value += String.valueOf(x);
                        }

                        Intent in = new Intent(ListActivity.this, MainActivity.class);
                        in.putExtra("key",value);

                        startActivity(in);
                    }
                });


        ImageView img = findViewById(R.id.imageView2);
        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });
    }
}