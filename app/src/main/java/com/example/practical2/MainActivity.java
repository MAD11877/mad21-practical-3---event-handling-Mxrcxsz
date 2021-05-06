package com.example.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    User user1 = new User("MAD",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus orci ligula, interdum ut tortor non, porttitor sagittis diam. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris in fringilla odio, vel posuere est. Proin pulvinar, ipsum sed posuere iaculis, turpis dui vulputate urna, eu porttitor ex lectus vel purus. Ut in nunc cursus, posuere orci ut, condimentum magna.",
            1,
            true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nameTxt = findViewById(R.id.nameTxt);
        nameTxt.setText(user1.getName() + " " + getIntent().getExtras().getString("key"));

        TextView desTxt = findViewById(R.id.desTxt);
        desTxt.setText(user1.getDescription());

        Button followBtn = findViewById(R.id.followBtn);
        if(user1.getFollowed()){
            followBtn.setText("Followed");
        }
        else{
            followBtn.setText("Follow");
        }
        followBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                user1.Change();
                if(user1.getFollowed()){
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_LONG).show();
                    followBtn.setText("Unfollow");
                }
                else{
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_LONG).show();
                    followBtn.setText("Follow");
                }
            }
        });

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent in = new Intent(MainActivity.this, MainActivity2.class);

                EditText txt = findViewById(R.id.input);
                String userInput = txt.getText().toString();

                startActivity(in);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}