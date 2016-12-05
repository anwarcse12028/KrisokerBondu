package com.wadud.anwar.krisokerbondu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;


public class BazarDorFragment extends Fragment  {

    private Button dp,dk,sp,sk;
    WebView webView;
    LinearLayout linearLayout;
    int check=1 ;


     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View rootView = inflater.inflate(R.layout.fragment_bazar_dor, container, false);
         View rootView = inflater.inflate(R.layout.fragment_bazar_dor,container,false);

         dk = (Button)rootView.findViewById(R.id.dhakaKusra);
         dp = (Button)rootView.findViewById(R.id.dhakaPikary);
         sp = (Button)rootView.findViewById(R.id.sylhetKusra);
         sp = (Button)rootView.findViewById(R.id.sylhetPikary);
         linearLayout = (LinearLayout)rootView.findViewById(R.id.linearLayout);
         webView = (WebView)rootView.findViewById(R.id.displayWeb);

         dk.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 linearLayout.setVisibility(View.GONE);
                 webView.setVisibility(View.VISIBLE);
                 webView.getSettings().setJavaScriptEnabled(true);
                 webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + "http://www.dam.gov.bd/damweb/dailyprice/dhaka_mrp.pdf");

             }
         });


         dp.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 linearLayout.setVisibility(View.GONE);
                 webView.setVisibility(View.VISIBLE);
                 webView.getSettings().setJavaScriptEnabled(true);
                 webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + "http://www.dam.gov.bd/damweb/dailyprice/dhaka_wrp.pdf");

             }
         });


             return  rootView;

    }




    public void onBackPressed() {
        if(linearLayout.getVisibility() == View.GONE) {
            webView.setVisibility(View.GONE);
            linearLayout.setVisibility(View.VISIBLE);
        }else{
            check = 0;
        }


    }


}
