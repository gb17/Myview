package com.ryanbrooks.expandablerecyclerviewsample.linear.vertical;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.ryanbrooks.expandablerecyclerviewsample.R;


/**
 * Custom parent ViewHolder. Any views should be found and set to public variables here to be
 * referenced in your custom ExpandableRecyclerAdapter later.
 * <p/>
 * Must extend ParentViewHolder
 */
public class VerticalParentViewHolder extends ParentViewHolder {

    private static final float INITIAL_POSITION = 0.0f;
    private static final float ROTATED_POSITION = 180f;
    private static final float PIVOT_VALUE = 0.5f;
    private static final long DEFAULT_ROTATE_DURATION_MS = 200;
    private static final boolean HONEYCOMB_AND_ABOVE = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;

    public TextView mDateTextView;
    public TextView mDayTextView;
    public TextView mMonthTextView;
    Typeface font;


    public TextView mAddOptionTextView;


    /**
     * Public constructor for the CustomViewHolder.
     *
     * @param itemView the view of the parent item. Find/modify views using this.
     */
    public VerticalParentViewHolder(View itemView) {
        super(itemView);

        mDateTextView = (TextView) itemView.findViewById(R.id.datetextview);
        mMonthTextView = (TextView) itemView.findViewById(R.id.monthtextview);
        mDayTextView = (TextView) itemView.findViewById(R.id.daytextview);
        mAddOptionTextView = (TextView) itemView.findViewById(R.id.addplus);


    }

    public void bind(int parentNumber, String parentText, String dayText, String monthtext, final Context context) {

        mDateTextView.setText(parentText);
        mMonthTextView.setText(monthtext);
        mDayTextView.setText(dayText);


        font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");
        mAddOptionTextView.setTypeface(font);

        mAddOptionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Dr Menu", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("NewApi")
    @Override
    public void setExpanded(boolean expanded) {
        super.setExpanded(expanded);
        if (!HONEYCOMB_AND_ABOVE) {
            return;
        }


    }

    @Override
    public void onExpansionToggled(boolean expanded) {
        super.onExpansionToggled(expanded);
        if (!HONEYCOMB_AND_ABOVE) {
            return;
        }


    }
}
