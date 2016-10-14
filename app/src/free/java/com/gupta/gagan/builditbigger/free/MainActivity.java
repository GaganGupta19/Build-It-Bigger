package com.gupta.gagan.builditbigger.free;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.gupta.gagan.build_it_bigger.R;
import com.gupta.gagan.build_it_bigger.Utility.AsyncJokesProvider;
import com.gupta.gagan.build_it_bigger.Utility.JokeListener;
import com.gupta.gagan.jokescreen.JokeScreen;
import com.spark.submitbutton.SubmitButton;

public class MainActivity extends AppCompatActivity implements JokeListener {

    private SubmitButton mButton;
    private TextView mTextView;
    private ProgressBar spinner;
    private AdView mAdView;
    private PublisherInterstitialAd mPublisherInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("FREE","FREE");
        setUserInterface();
        generateBannerAd();

        mPublisherInterstitialAd = new PublisherInterstitialAd(this);
        mPublisherInterstitialAd.setAdUnitId(this.getResources().getString(R.string.interstitial_ad_unit_id));

        /* Anonymous method call to close and start intent for jokescreen activity */
        mPublisherInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed(){
                generateInterstitialAd();
                new AsyncJokesProvider(MainActivity.this).getJoke();
                spinner.setVisibility(View.VISIBLE);
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateInterstitialAd();
                Handler hs = new Handler();
                spinner.setVisibility(View.VISIBLE);
                hs.postDelayed(runnable, 1000);
            }
        });
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(mPublisherInterstitialAd.isLoaded())
                mPublisherInterstitialAd.show();
            else
                new AsyncJokesProvider(MainActivity.this).getJoke();
        }
    };

    void setUserInterface() {
        Typeface tf = Typeface.createFromAsset(this.getAssets(), "fonts/Inconsolata.otf");

        spinner = (ProgressBar) findViewById(R.id.progressBar1);
        spinner.setVisibility(View.INVISIBLE);

        mButton = (SubmitButton) findViewById(R.id.button);
        mButton.setTypeface(tf);
        mButton.setTextSize(17);

        mTextView = (TextView) findViewById(R.id.mtextView);
        mTextView.setTypeface(tf);
        mTextView.setTextSize(15);
                /* Banner Ad*/
        mAdView = (AdView) findViewById(R.id.adView);

    }

    @Override
    public void onResume() {
        super.onResume();
        spinner.setVisibility(View.INVISIBLE);
    }
    protected void generateBannerAd(){
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }

    protected void generateInterstitialAd(){
        PublisherAdRequest adRequest = new PublisherAdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mPublisherInterstitialAd.loadAd(adRequest);
    }

    @Override
    public void fetch_joke(String joke) {
        Intent intent = new Intent(this, JokeScreen.class);
        intent.putExtra("joke", joke);
        startActivity(intent);
    }
}