package com.bignerdranch.android.criminalintent;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by vongr on 3/28/2016.
 */
public class ZoomInFragment extends DialogFragment {

    private static final String ARG_PICTURE = "picture";

    private ImageView mImageView;

    public static ZoomInFragment newInstance(File picture) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PICTURE, picture);

        ZoomInFragment fragment = new ZoomInFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        File picture = (File) getArguments().getSerializable(ARG_PICTURE);
        Bitmap bitmap = PictureUtils.getScaledBitmap(picture.getPath(), getActivity());

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_picture, null);

        mImageView = (ImageView) v.findViewById(R.id.dialog_picture_image_view);
        mImageView.setImageBitmap(bitmap);
            return new AlertDialog.Builder(getActivity())
                    .setView(v)
                    .create();
    }
}
