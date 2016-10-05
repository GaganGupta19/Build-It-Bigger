package com.gupta.gagan.build_it_bigger;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ActionViewTarget;
import com.spark.submitbutton.SubmitButton;

public class MainActivity extends AppCompatActivity {

    SubmitButton mButton;
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUserInterface();
    }

    void setUserInterface() {
        mButton = (SubmitButton) findViewById(R.id.button);
        Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/Inconsolata.otf");
        mButton.setTypeface(tf);
        mButton.setTextSize(17);
        mTextView = (TextView) findViewById(R.id.mtextView);
        mTextView.setTypeface(tf);
        mTextView.setTextSize(15);
    }
}
