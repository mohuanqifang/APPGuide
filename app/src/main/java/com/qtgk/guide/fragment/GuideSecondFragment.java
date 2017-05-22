package com.qtgk.guide.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qtgk.guide.R;

public class GuideSecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, container, false);
        ImageView mImageView = (ImageView) view.findViewById(R.id.imageview);
        mImageView.setImageResource(R.mipmap.ic_launcher);
        return view;
    }

}
