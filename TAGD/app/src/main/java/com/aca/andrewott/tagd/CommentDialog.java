package com.aca.andrewott.tagd;

import android.widget.Button;

/**
 * Created by andrewott on 10/31/16.
 */

public class CommentDialog {

    Button mSendComment;

    private String mGamerTag;
    private String mComment;

    public Button getSendComment() {
        return mSendComment;
    }

    public void setSendComment(Button sendComment) {
        mSendComment = sendComment;
    }

    public String getGamerTag() {
        return mGamerTag;
    }

    public void setGamerTag(String gamerTag) {
        mGamerTag = gamerTag;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        mComment = comment;
    }
}
