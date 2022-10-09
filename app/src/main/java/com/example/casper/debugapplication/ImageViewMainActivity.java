package com.example.casper.debugapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewMainActivity extends AppCompatActivity {
    private Button buttonPrevious,buttonNext; //不能在这里定义，不然app会闪退
    private ImageView imageViewFunny;

    private int[] imageIDArray = {R.drawable.funny_1, R.drawable.funny_2
            , R.drawable.funny_3, R.drawable.funny_4, R.drawable.funny_5
            , R.drawable.funny_6
    };
    private int imageIDArrayCurrentIndex=0;

    public ImageViewMainActivity( ) {    //构造函数没什么用其实可以删掉
        imageIDArrayCurrentIndex = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_main);

        buttonPrevious = (Button)findViewById(R.id.button_previous);
//        buttonNext =(Button) findViewById(R.id.buttonHelloEn);    这里找的是另外一个布局的id，找不到的也找错了
        buttonNext =(Button) findViewById(R.id.button_next);
        imageViewFunny = (ImageView)findViewById(R.id.image_view_funny);

        buttonPrevious.setOnClickListener(new MyButtonClickListener());
        buttonNext.setOnClickListener(new MyButtonClickListener());

    }

    private class MyButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (((Button) view).getText().equals("下一个") ) {  //这里的string比较不能用==需要用equals或者用按钮组件比较
                imageIDArrayCurrentIndex ++;       //需要处理数组下标越界问题
                if(imageIDArrayCurrentIndex==6)
                    imageIDArrayCurrentIndex=0;
            } else {
                imageIDArrayCurrentIndex --; //需要处理数组下标问题
                if(imageIDArrayCurrentIndex==-1)
                    imageIDArrayCurrentIndex=5;
            }
            imageViewFunny.setImageResource(imageIDArray[imageIDArrayCurrentIndex]);
        }
    }
}