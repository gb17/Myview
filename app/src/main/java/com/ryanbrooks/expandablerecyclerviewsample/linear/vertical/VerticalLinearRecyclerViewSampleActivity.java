package com.ryanbrooks.expandablerecyclerviewsample.linear.vertical;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.ryanbrooks.expandablerecyclerviewsample.PLANDATA;
import com.ryanbrooks.expandablerecyclerviewsample.R;
import com.ryanbrooks.expandablerecyclerviewsample.Sync;

import java.util.ArrayList;
import java.util.List;

/**
 * Sample Activity for the vertical linear RecyclerView sample.
 * Uses ButterKnife to inject view resources.
 *
 * @author Ryan Brooks
 * @version 1.0
 * @since 5/27/2015
 */
public class VerticalLinearRecyclerViewSampleActivity extends AppCompatActivity implements ExpandableRecyclerAdapter.ExpandCollapseListener, SearchView.OnQueryTextListener {

    private static final int NUM_TEST_DATA_ITEMS = 20;

    private VerticalExpandableAdapter mExpandableAdapter;

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private SearchView mSearchView;

    List<VerticalParent> verticalParentList;

    public static Intent newIntent(Context context) {
        return new Intent(context, VerticalLinearRecyclerViewSampleActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_linear_recycler_view_sample);

        mToolbar = (Toolbar) findViewById(R.id.activity_vertical_linear_recycler_view_sample_toolbar);
        setupToolbar();

        mSearchView = (SearchView) findViewById(R.id.searchView);
        mSearchView.setOnQueryTextListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.activity_vertical_linear_recycler_view_sample_recyclerView);




        Sync sync = new Sync();
        sync.executeRequestforjson(false);

        // Create a n ew adapter with 20 test data items
        mExpandableAdapter = new VerticalExpandableAdapter(this, setUpTestData(NUM_TEST_DATA_ITEMS));
        // Attach this activity to the Adapter as the ExpandCollapseListener
        mExpandableAdapter.setExpandCollapseListener(this);


        mRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(1));
        // Set the RecyclerView's adapter to the ExpandableAdapter we just created
        mRecyclerView.setAdapter(mExpandableAdapter);
        // Set the layout manager to a LinearLayout manager for vertical list
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    /**
     * Save the instance state of the adapter to keep expanded/collapsed states when rotating or
     * pausing the activity.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mExpandableAdapter.onSaveInstanceState(outState);
    }

    /**
     * Load the expanded/collapsed states of the adapter back into the view when done rotating or
     * resuming the activity.
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mExpandableAdapter.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onListItemExpanded(int position) {
        String toastMessage = getString(R.string.item_expanded, position);
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListItemCollapsed(int position) {
        String toastMessage = getString(R.string.item_collapsed, position);
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Method to set up test data used in the RecyclerView.
     * <p/>
     * Each child list item contains a string.
     * Each parent list item contains a number corresponding to the number of the parent and a string
     * that contains a message.
     * Each parent also contains a list of children which is generated in this. Every odd numbered
     * parent gets one child and every even numbered parent gets two children.
     *
     * @return A List of Objects that contains all parent items. Expansion of children are handled in the adapter
     */
    private List<VerticalParent> setUpTestData(int numItems) {
        verticalParentList = new ArrayList<>();


        List<PLANDATA> DATEPL = PLANDATA.findWithQuery(PLANDATA.class, "Select  *  from PLANDATA WHERE BU=?  groupby PLANDATE", "2");

        PLANDATA.findAll(PLANDATA.class);
   

        for (int i = 0; i <DATEPL.size(); i++) {
            List<VerticalChild> childItemList = new ArrayList<>();


            for (int j = 0; j < 5; j++) {

                VerticalChild verticalChild = new VerticalChild();
                if (i == 2 && j == 3) {
                    verticalChild.setmDrNameText("Dr Gaurav");
                    verticalChild.setmDrSpclText("Cardiologist");
                    verticalChild.setmDrClassText("Unclassified");
                    verticalChild.setmDrTimeText("11:30");
                } else {
                    verticalChild.setmDrNameText("Dr Name");
                    verticalChild.setmDrSpclText("Neurologist");
                    verticalChild.setmDrClassText("Class B");
                    verticalChild.setmDrTimeText("11:30");
                }
                childItemList.add(verticalChild);

            }
            VerticalParent verticalParent = new VerticalParent();
            verticalParent.setChildItemList(childItemList);
            verticalParent.setParentNumber(i);
            verticalParent.setParentText("17");
            verticalParent.setmDayText("TUE");
            verticalParent.setMmonthText("JUNE");

            if (i == 2) {
                verticalParent.setParentNumber(i);
                verticalParent.setParentText("19");
                verticalParent.setmDayText("Fri");
                verticalParent.setMmonthText("JUNE");
            }


            verticalParent.setInitiallyExpanded(true);

            verticalParentList.add(verticalParent);
        }

        return verticalParentList;
    }


    public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

        private final int mVerticalSpaceHeight;

        public VerticalSpaceItemDecoration(int mVerticalSpaceHeight) {
            this.mVerticalSpaceHeight = mVerticalSpaceHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.bottom = mVerticalSpaceHeight;
        }


    }


    @Override
    public boolean onQueryTextChange(String query) {
        final List<VerticalParent> filteredModelList = filter(verticalParentList, query);
        mExpandableAdapter = new VerticalExpandableAdapter(this, filteredModelList);
        mExpandableAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mExpandableAdapter);
//
//
//        //  mExpandableAdapter.animateTo(filteredModelList);
//
//        mRecyclerView.scrollToPosition(0);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private List<VerticalParent> filter(List<VerticalParent> models, String query) {
        query = query.toLowerCase();
        final List<VerticalParent> filteredModelList = new ArrayList<>();
        for (VerticalParent model : models) {
            final String text = model.getParentText().toLowerCase();
            for (int i = 0; i < model.getChildItemList().size(); i++) {
                VerticalChild verticalChild = model.getChildItemList().get(i);
                String text2 = verticalChild.getmDrNameText().toLowerCase();
                String text3 = verticalChild.getmDrClassText().toLowerCase();
                String text4 = verticalChild.getmDrSpclText().toLowerCase();
                if (text.contains(query) || text2.contains(query) || text3.contains(query) || text4.contains(query)) {
                    filteredModelList.add(model);
                    break;
                }
            }
        }
        return filteredModelList;
    }
}
