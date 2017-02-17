package com.edu.chb.handdraw2;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.EmbossMaskFilter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
//import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {

    EmbossMaskFilter emboss;
    BlurMaskFilter blur;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emboss = new EmbossMaskFilter(new float[]{1.5f, 1.5f, 1.5f}, 0.6f, 6, 4.2f);
        blur = new BlurMaskFilter(8, Blur.NORMAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = new MenuInflater(this);
        //状态R.menu.context对应的菜单，并添加到menu中
        inflator.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        DrawView dv = (DrawView)findViewById(R.id.draw);
        //判断单击的是哪个菜单项，并有针对性地做出响应
        switch(item.getItemId()){
            case R.id.red:
                dv.paint.setColor(Color.RED);
                item.setChecked(true);
                break;
            case R.id.green:
                dv.paint.setColor(Color.GREEN);
                item.setChecked(true);
                break;
            case R.id.blue:
                dv.paint.setColor(Color.BLUE);
                item.setChecked(true);
                break;
            case R.id.width_1:
                dv.paint.setStrokeWidth(1);
                break;
            case R.id.width_3:
                dv.paint.setStrokeWidth(3);
                break;
            case R.id.width_5:
                dv.paint.setStrokeWidth(5);
                break;
            case R.id.blur:
                dv.paint.setMaskFilter(blur);
                break;
            case R.id.emboss:
                dv.paint.setMaskFilter(emboss);
                break;
        }
        return true;
    }
}



