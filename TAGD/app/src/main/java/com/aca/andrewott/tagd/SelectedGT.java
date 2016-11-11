package com.aca.andrewott.tagd;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindDrawable;

/**
 * Created by andrewott on 10/31/16.
 */

public class SelectedGT extends AppCompatActivity {

    /*
    ImageView mImageGamerPic;
    TextView mTextGSDisplay;
    TextView mTextGTDisplay;
    */

    Button mBtnTAG;
    Button mBtnSubmitCom;
    Button mBtnSeeAllCom;
    Context mContext;

    EditText mEditComment;
    EditText mEditGameName;
    TextView mTxtEnterTAG;

    @BindDrawable(R.drawable.textfield_shape_greyandgreen)
    Drawable mTxtViewBackground;



    //TODO Initialize these dudes
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview_user_activity);

        mContext = getApplicationContext();

        mEditComment = (EditText) findViewById(R.id.editComment);
        mEditGameName = (EditText) findViewById(R.id.editGameName);

        mBtnTAG = (Button) findViewById(R.id.btnTAG);

        /*
        mImageGamerPic = (ImageView) findViewById(R.id.imageGamerPic);
        mTextGSDisplay = (TextView) findViewById(R.id.txtGSDisplay);
        mTextGTDisplay = (TextView) findViewById(R.id.txtGTDisplay);
        */

        //TODO These are probs not getting used
        //mTxtViewComment = (TextView) findViewById(R.id.txtViewComment);
        //mTxtViewGame = (TextView) findViewById(R.id.txtViewGame);

        //TODO more changes; set background image of textview "mTxtViewComment"; initialize holding messages.
        mBtnSubmitCom = (Button) findViewById(R.id.btnSubmitCom);
        mBtnSubmitCom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String comment = mEditComment.getText().toString();
                String game = mEditGameName.getText().toString();

                FragmentManager fm = getSupportFragmentManager();
                Fragment frag = fm.findFragmentById(R.id.container);

                if (frag == null) {
                    frag = new DialogNewComment();

                    Bundle args = new Bundle();
                    args.putString("comment", comment);
                    args.putString("game", game);
                    frag.setArguments(args);
                    fm.beginTransaction()
                            .add(R.id.container, frag)
                            .commit();
                }

                mEditComment.setText("");
                mEditGameName.setText("");
                mEditComment.requestFocus();

            }
        });

        mBtnSeeAllCom = (Button) findViewById(R.id.btnSeeAllCom);
        mBtnSeeAllCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent = new Intent (getApplicationContext(), SeeAllComments.class);
                // startActivity(intent);

                //TODO Temporary toast for release
                Context context = getApplicationContext();
                CharSequence text = "No Additional Comments Found";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        mTxtEnterTAG = (TextView) findViewById(R.id.txtEnterTAG);
        mTxtEnterTAG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SelectedGT.this);
                builder.setTitle(R.string.app_name);
                builder.setIcon(R.mipmap.tagdlogo);
                builder.setMessage("This feature will be available soon!")
                        .setCancelable(false)
                        .setPositiveButton("Okay!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                                Intent intent = new Intent(getApplicationContext(), SelectedGT.class);
                                startActivity(intent);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }

        });
    }
}

