package com.test.imageviewclicktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.test.imageviewclicktest.utils.Polygon;
import com.test.imageviewclicktest.weight.ClickImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ClickImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ClickImageView) findViewById(R.id.image);

        List<Polygon> polygons = new ArrayList<>();
        Polygon polygon = new Polygon("00");
        polygon.add(42.28571429f, 34.57627119f);
        polygon.add(50.14285714f, 34.57627119f);
        polygon.add(50.14285714f, 46.18644068f);
        polygon.add(42.28571429f, 46.18644068f);
        polygons.add(polygon);



        Polygon polygon1 = new Polygon("11");
        polygon1.add(32.14285714f, 28.30508475f);
        polygon1.add(64.71428571f, 28.30508475f);
        polygon1.add(64.71428571f, 32.96610169f);
        polygon1.add(39.28571429f, 32.96610169f);
        polygons.add(polygon1);



        Polygon polygon2 = new Polygon("22");
        polygon2.add(40.85714286f, 47.88135593f);
        polygon2.add(69.57142857f, 47.88135593f);
        polygon2.add(69.57142857f, 55.93220339f);
        polygon2.add(40.85714286f, 55.93220339f);
        polygons.add(polygon2);


        image.setPolygons(polygons);


        image.setOnViewClickListener(new ClickImageView.OnViewClick() {
            @Override
            public void onClick(String id) {
                Toast.makeText(MainActivity.this , id , Toast.LENGTH_SHORT).show();
            }
        });



    }
}
