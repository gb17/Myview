package com.ryanbrooks.expandablerecyclerviewsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.ryanbrooks.expandablerecyclerviewsample.linear.vertical.VerticalLinearRecyclerViewSampleActivity;

/**
 * Main Activity that contains navigation for sample application.
 *
 * @author Ryan Brooks
 * @version 1.0
 * @since 5/27/2015
 */
public class MainActivity extends AppCompatActivity {

    private Button mVerticalSampleButton;
    private Button mHorizontalSampleButton;
    private Button mGridSampleButton;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(VerticalLinearRecyclerViewSampleActivity.newIntent(MainActivity.this));

    }


}
