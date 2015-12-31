package com.ryanbrooks.expandablerecyclerviewsample.linear.vertical;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.ryanbrooks.expandablerecyclerviewsample.R;


/**
 * Custom child ViewHolder. Any views should be found and set to public variables here to be
 * referenced in your custom ExpandableAdapter later.
 * <p/>
 * Must extend ChildViewHolder.
 *
 * @author Ryan Brooks
 * @version 1.0
 * @since 5/27/2015
 */
public class VerticalChildViewHolder extends ChildViewHolder {

    public TextView mDrNameTextView;
    public TextView mDrSpclTextView;
    public TextView mDrClassTextView;
    public TextView mDrtimeTextView;
    //tick
    public TextView mDrtick1TextView;
    public TextView mDrtick2TextView;
    public TextView mDrtick3TextView;

    public ImageView mDrImageView;

    public TextView mMenuforDrTextView;
    Typeface font;

    /**
     * Public constructor for the custom child ViewHolder
     *
     * @param itemView the child ViewHolder's view
     */
    public VerticalChildViewHolder(View itemView) {
        super(itemView);

        mDrNameTextView = (TextView) itemView.findViewById(R.id.drnametextview);
        mDrSpclTextView = (TextView) itemView.findViewById(R.id.drspcltextview);
        mDrClassTextView = (TextView) itemView.findViewById(R.id.drclasstextview);

        mDrtimeTextView = (TextView) itemView.findViewById(R.id.drtimetextview);
        mDrtick1TextView = (TextView) itemView.findViewById(R.id.tick1);
        mDrtick2TextView = (TextView) itemView.findViewById(R.id.tick2);
        mDrImageView = (ImageView) itemView.findViewById(R.id.dr_image);
        mMenuforDrTextView = (TextView) itemView.findViewById(R.id.menufordr);
    }

    public void bind(String childText, String Drspclity, String DrClass, String Drtime, final Context context) {
        font = Typeface.createFromAsset(context.getAssets(),
                "fontawesome-webfont.ttf");

        mMenuforDrTextView.setTypeface(font);
        mDrNameTextView.setText(childText);
        mDrSpclTextView.setText(Drspclity);
        mDrClassTextView.setText(DrClass);
        mDrtimeTextView.setText(Drtime);


        mMenuforDrTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Hotlinks", Toast.LENGTH_SHORT).show();
            }
        });
    }
}