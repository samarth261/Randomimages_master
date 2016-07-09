package app.com.example.sumanthc.randomimages;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.File;
import java.util.ArrayList;

public class show extends AppCompatActivity {
    String path="/sdcard/ASD/Category";
    String[] list;

    //final RelativeLayout svrl=(RelativeLayout)findViewById(R.id.svrl);

    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        final RelativeLayout svrl=(RelativeLayout)findViewById(R.id.svrl);
        final String cat=getIntent().getStringExtra("Activity");

        path+="/"+cat+"/Items";
        File f=new File(path);
        list = f.list();
        for(int i=0;i<list.length;i++)
        {
            final int index=i;
            ImageButton img=new ImageButton(getApplicationContext());
            img.setBackground(Drawable.createFromPath(path+"/"+list[index]+"/Thumb.png"));
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(200,200);
            int l=50+((index%2==1)?240:0);
            int t=50+(index/2)*240;
            params.setMargins(l,t,0,0);
            svrl.addView(img,params);
            img.setClickable(true);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.putExtra("Category",list[index]);
                    intent.putExtra("Activity",cat);
                    intent.setClass(getApplicationContext(),show1.class);
                    startActivity(intent);
                }
            });

        }




    }}