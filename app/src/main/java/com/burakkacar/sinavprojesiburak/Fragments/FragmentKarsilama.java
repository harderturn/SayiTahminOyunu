package com.burakkacar.sinavprojesiburak.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.burakkacar.sinavprojesiburak.R;

/**
 * Created by MuhammedBurak on 4.1.2017.
 */

public class FragmentKarsilama extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_karsilama,container,false);
        TextView textView = (TextView) view.findViewById(R.id.mTxtBaslat);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTahminEkrani tahminEkrani = new FragmentTahminEkrani();

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.my_container,tahminEkrani)
                        .commit();
            }
        });



        return view;
    }
}
