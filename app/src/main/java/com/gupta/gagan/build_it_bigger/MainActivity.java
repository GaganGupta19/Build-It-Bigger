package com.gupta.gagan.build_it_bigger;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ActionViewTarget;
import com.gupta.gagan.jokescreen.JokeScreen;
import com.spark.submitbutton.SubmitButton;

public class MainActivity extends AppCompatActivity {

    SubmitButton mButton;
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUserInterface();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler myHandler = new Handler();
                myHandler.postDelayed(mMyRunnable, 1500);
            }
        });
    }
    private Runnable mMyRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            intentWindow();
        }
    };

    void setUserInterface() {
        Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/Inconsolata.otf");

        mButton = (SubmitButton) findViewById(R.id.button);
        mButton.setTypeface(tf);
        mButton.setTextSize(17);

        mTextView = (TextView) findViewById(R.id.mtextView);
        mTextView.setTypeface(tf);
        mTextView.setTextSize(15);

    }

    public void intentWindow(){
        Intent intent = new Intent(this, JokeScreen.class);
        startActivity(intent);
    }
}
