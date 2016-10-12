package com.gupta.gagan.jokescreen;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.udacity.example.jokes.JokeGenerator;

public class JokeScreen extends AppCompatActivity {

    TextView mJokeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_screen);
        initializeUI();
    }

    public void initializeUI(){
        Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Inconsolata.otf");
        mJokeView = (TextView) findViewById(R.id.mJokeView);
        mJokeView.setTypeface(tf);
        mJokeView.setText(new JokeGenerator().generateJoke());
        mJokeView.setTextSize(15);
    }
}
