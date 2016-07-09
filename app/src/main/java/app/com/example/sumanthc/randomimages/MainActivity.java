package app.com.example.sumanthc.randomimages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String path="/sdcard/ASD/category/items";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bn1 = (Button) findViewById(R.id.button1);
        Button bn2 = (Button) findViewById(R.id.button2);
        Button bn3 = (Button) findViewById(R.id.button3);
        Button bn4 = (Button) findViewById(R.id.button4);
        bn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,show.class);
                i.putExtra("Activity","Fruits");
                startActivity(i);
            }
        });
        bn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,show.class);
                i.putExtra("Activity","Vehicles");
                startActivity(i);
            }
        });
    }
}
