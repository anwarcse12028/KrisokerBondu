package com.wadud.anwar.krisokerbondu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MulPataFragment extends Fragment {

    String textFile;
    TextView textView;

    public MulPataFragment(){

    }

    public  MulPataFragment(String textFile){
        this.textFile = textFile;
    }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_mul_pata, container, false);
       textView = (TextView)rootView.findViewById(R.id.mulpataTextView);
       textView.setText(textFile);

        return rootView;
    }

}
