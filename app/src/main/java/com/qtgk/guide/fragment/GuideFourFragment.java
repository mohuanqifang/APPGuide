package com.qtgk.guide.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qtgk.guide.MainActivity;
import com.qtgk.guide.R;

public class GuideFourFragment extends Fragment {

    private SharedPreferences mSharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreferences = getActivity().getSharedPreferences("guide", Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide_end, container, false);
        ImageView mImageView = (ImageView) view.findViewById(R.id.imageview_end);
        mImageView.setImageResource(R.mipmap.ic_launcher);
        (view.findViewById(R.id.tv_express)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
                SharedPreferences.Editor mEditor = mSharedPreferences.edit();
                mEditor.putBoolean("launcher", false);
                mEditor.commit();
            }
        });
        return view;
    }
}
