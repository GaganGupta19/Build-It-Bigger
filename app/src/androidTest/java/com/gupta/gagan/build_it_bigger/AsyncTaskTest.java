package com.gupta.gagan.build_it_bigger;

import android.test.AndroidTestCase;
import android.test.UiThreadTest;

import com.gupta.gagan.build_it_bigger.Utility.AsyncJokesProvider;
import com.gupta.gagan.build_it_bigger.Utility.JokeListener;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Gagan on 10/14/2016.
 */

public class AsyncTaskTest extends AndroidTestCase implements JokeListener {

        private CountDownLatch signal;
        private String joke = null;
        private AsyncJokesProvider asyncJokesProvider;

        public AsyncTaskTest(){
            signal = new CountDownLatch(1);
            asyncJokesProvider = new AsyncJokesProvider(this);
        }

        @UiThreadTest
        public void testAsync() throws InterruptedException {
            asyncJokesProvider.getJoke();
            signal.await(10, TimeUnit.SECONDS);
            assertTrue("Yes! Joke Received", joke != null);
        }

        @Override
        public void fetch_joke(String joke) {
            this.joke = joke;
            signal.countDown();
        }

}
