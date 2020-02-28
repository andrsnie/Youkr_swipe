/*
 * Created by andrSnie on 2.01.20 3:17
 * Copyright (c) 2020. All rights reserved.
 */

package angel.andrsnie.youkr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Word} objects.
 */
class WordAdapter extends ArrayAdapter<Word>  {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /** Resource ID for the text color for this list of words */
    private int mColorTextId;

    /** Icons color for this list of words */
    private boolean mIconBlack;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Word}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     * @param colorTextId is the resource ID for the text color for this list of words
     * @param iconBlack is for the icons color for this list of words
     */
    WordAdapter(Context context, ArrayList<Word> words, int colorResourceId, int colorTextId, boolean iconBlack) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
        mColorTextId = colorTextId;
        mIconBlack = iconBlack;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        int colorText = ContextCompat.getColor(getContext(), mColorTextId);

        // Find the TextView in the list_item.xml layout with the ID youkr_text_view.
        TextView youkrTextView = (TextView) listItemView.findViewById(R.id.youkr_text_view);
        // Get the Ukr translation from the currentWord object and set this text on
        // the Ukr TextView.
        if (currentWord != null)
            youkrTextView.setText(currentWord.getYoukrTranslationId());
            else youkrTextView.setText(null);

        youkrTextView.setTextColor(colorText);

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        if (currentWord != null)
            defaultTextView.setText(currentWord.getDefaultTranslationId());
            else defaultTextView.setText(null);

        defaultTextView.setTextColor(colorText);

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentWord != null && currentWord.getImageResourceId() != -1) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentWord.getImageResourceId());
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Find the ImageView in the list_item.xml layout with the ID ic
        ImageView ic = (ImageView) listItemView.findViewById(R.id.ic);
        if (currentWord != null) {
            // Display the provided icons based on the resource ID and boolean mIconBlack
            if (mIconBlack)
                ic.setImageResource(R.drawable.ic_play_arrow_black);
                else ic.setImageResource(R.drawable.ic_play_arrow);
        }

        // Return the whole list item layout so that it can be shown in
        // the ListView.
        return listItemView;
    }
}