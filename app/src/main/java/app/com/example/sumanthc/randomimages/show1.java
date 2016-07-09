package app.com.example.sumanthc.randomimages;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.File;
import java.util.Random;

public class show1 extends AppCompatActivity {
    String path = "/sdcard/ASD/Category";
    String[] list;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show1);
        Button bn = (Button) findViewById(R.id.button2);
        img = (ImageView) findViewById(R.id.imageView);

        String subcategory = getIntent().getStringExtra("Category");
        String category = getIntent().getStringExtra("Activity");

        path += "/" + category + "/Items/" + subcategory;
        File f = new File(path);
        list = f.list();
        list=getOnlyImgs(list);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Random r = new Random();
                int i = r.nextInt(list.length );
                i++;
                img.setBackground(Drawable.createFromPath(path + "/img" + i + ".png"));

            }
        });


    }

    private String[] getOnlyImgs(String[] list) {
        String tempList[];
        int counter = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].startsWith("img")) {
                if (list[i].endsWith("outline.png")) {
                    //don't do anything
                }
                else {
                    counter++;
                }
            }
        }

        tempList = new String[counter];
        int j = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].startsWith("img")) {
                if (list[i].endsWith("outline.png")) {
                    //don't do anything ..... duh..
                } else {
                    tempList[j] = list[i];
                    j++;
                }
            }
        }

        list = tempList;
        return list;
    }
}
