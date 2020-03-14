package com.xiey.anim;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EatFish mEatFish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEatFish = findViewById(R.id.eat_fish);
    }

    public void start(View view) {
        mEatFish.startAnimation();
    }

    public void over(View view) {
        mEatFish.stopAnimation();
    }

    private void showDialog() {
        new LoadDialog(MainActivity.this)
                .builder()
                .setContent("请稍后")
                .setCancelable(true)
                .setCanceledOnTouchOutside(true)
                .show();
    }

    public void dialog(View view) {
        showDialog();
    }
}
