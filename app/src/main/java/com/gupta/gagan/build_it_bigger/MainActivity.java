package com.gupta.gagan.build_it_bigger;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ActionViewTarget;
import com.gupta.gagan.build_it_bigger.Utility.AsyncJokesProvider;
import com.gupta.gagan.build_it_bigger.Utility.JokeListener;
import com.gupta.gagan.jokescreen.JokeScreen;
import com.spark.submitbutton.SubmitButton;

public class MainActivity extends AppCompatActivity implements JokeListener{

    SubmitButton mButton;
    TextView mTextView;
    private ProgressBar spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUserInterface();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler hs = new Handler();
                spinner.setVisibility(View.VISIBLE);
                hs.postDelayed(runnable, 1000);
            }
        });
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            new AsyncJokesProvider(MainActivity.this).getJoke();
        }
    };

    void setUserInterface() {
        Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/Inconsolata.otf");

        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.INVISIBLE);

        mButton = (SubmitButton) findViewById(R.id.button);
        mButton.setTypeface(tf);
        mButton.setTextSize(17);

        mTextView = (TextView) findViewById(R.id.mtextView);
        mTextView.setTypeface(tf);
        mTextView.setTextSize(15);

    }
    @Override
    public void onResume(){
        super.onResume();
        spinner.setVisibility(View.INVISIBLE);
    }

    @Override
    public void fetch_joke(String joke){
        Intent intent = new Intent(this, JokeScreen.class);
        startActivity(intent);
    }
}
