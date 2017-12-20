package com.example.a4.bigfatthumbsup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by A4 on 12/18/2017.
 */

public class Counselling extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.counselling_frag,container,false);
    }
    @Override
    public void onResume() {
        super.onResume();
        /*((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Filing FIR");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setSubtitle(null);*/
    }
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        view.findViewById(R.id.textView4).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(),"Counelling_frag",Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
