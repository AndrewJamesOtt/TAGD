package com.aca.andrewott.tagd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by andrewott on 10/31/16.
 */

public class DialogNewComment extends Fragment {

    String mComment;
    String mGameName;

    TextView mCommentTextView;
    TextView mGameTextView;

    public DialogNewComment() {

    }

    public static DialogNewComment newInstance(String comment, String game){
        DialogNewComment frag = new DialogNewComment();

        Bundle args = new Bundle();
        args.putString("game", game);
        args.putString("comment", comment);
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGameName = getArguments().getString("game");
        mComment = getArguments().getString("comment");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_new_comment, container, false);

        mCommentTextView = (TextView) view.findViewById(R.id.commentTextView);
        mGameTextView = (TextView) view.findViewById(R.id.gameTextView);

        mCommentTextView.setText(mComment);
        mGameTextView.setText(mGameName);

        return view;
    }
}







