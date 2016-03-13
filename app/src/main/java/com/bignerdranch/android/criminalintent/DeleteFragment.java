package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by vongr on 3/12/2016.
 */
public class DeleteFragment extends DialogFragment {

    private static final String ARG_NAME = "name";

    public static DeleteFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_NAME, name);

        DeleteFragment fragment = new DeleteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String name = (String) getArguments().getSerializable(ARG_NAME);
        String deleteConfirmation=getResources().getString(R.string.delete_confirmation);
        String questionMark=getResources().getString(R.string.question_mark);

        return new AlertDialog.Builder(getActivity())
                .setTitle(deleteConfirmation+name+questionMark)
                .setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sendResult(Activity.RESULT_CANCELED);
                            }
                        })
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sendResult(Activity.RESULT_OK);
                            }
                        })
                .create();
    }

    private void sendResult(int resultCode) {
        if (getTargetFragment() == null) {
            return;
        }

        Intent intent = new Intent();

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
