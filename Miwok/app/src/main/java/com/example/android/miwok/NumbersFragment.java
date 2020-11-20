package com.example.android.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumbersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumbersFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    private  MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NumbersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumbersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumbersFragment newInstance(String param1, String param2) {
        NumbersFragment fragment = new NumbersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> number=new ArrayList<>();
        number.add(new Word("one","Lutti",R.drawable.number_one,R.raw.number_one));
        number.add(new Word("two","otiiko",R.drawable.number_two,R.raw.number_two));
        number.add(new Word("three","tolookosu",R.drawable.number_three,R.raw.number_three));
        number.add(new Word("four","oyyisa",R.drawable.number_four,R.raw.number_four));
        number.add(new Word("five","massokka",R.drawable.number_five,R.raw.number_five));
        number.add(new Word("six","temmokka",R.drawable.number_six,R.raw.number_six));
        number.add(new Word("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        number.add(new Word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        number.add(new Word("nine","wo’e",R.drawable.number_nine,R.raw.number_nine));
        number.add(new Word("ten","na’aacha",R.drawable.number_ten,R.raw.number_ten));



        ArrayAdapter<Word> aa=new WordAdapter(getActivity(),number,R.color.category_numbers);
        ListView listView=(ListView) rootview.findViewById(R.id.list);
        listView.setAdapter(aa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("NumbersActivity", "Current word: " +number.get(i));

                releaseMediaPlayer();
                mMediaPlayer= MediaPlayer.create(getActivity(),number.get(i).getmSoundResourcesId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mOnCompletionListener);

            }
        });
        // Inflate the layout for this fragment
        return rootview;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}