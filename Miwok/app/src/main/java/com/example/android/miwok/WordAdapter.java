package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int mColorResources;

    public WordAdapter(Activity context, List<Word> objects,int colour){
        super(context,0,objects);
        mColorResources=colour;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentWord=getItem(position);
        TextView itemMiok=(TextView)listItemView.findViewById(R.id.item_miok);
        itemMiok.setText(currentWord.getMiowkTranslation());


        TextView itemDefault=(TextView)listItemView.findViewById((R.id.item_english));
        itemDefault.setText(currentWord.getDefaultTranslation());

        ImageView itemId = (ImageView) listItemView.findViewById(R.id.images);


       if(currentWord.hasImages()){
           itemId.setImageResource(currentWord.getmImageResourcesId());
           itemId.setVisibility(View.VISIBLE);
       }
       else itemId.setVisibility(View.GONE);

       View textContainer= listItemView.findViewById(R.id.learning_path);
       int color=ContextCompat.getColor(getContext(),mColorResources);
       textContainer.setBackgroundColor(color);

        return  listItemView;
    }
}
