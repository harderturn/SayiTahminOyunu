package com.burakkacar.sinavprojesiburak.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.burakkacar.sinavprojesiburak.Fragments.FragmentKarsilama;
import com.burakkacar.sinavprojesiburak.SingleFragmentActivity;

public class MainActivity extends SingleFragmentActivity {

    public static Intent newInstance(Context context)
    {
        return new Intent(context,MainActivity.class);
    }

    @Override
    protected Fragment CreateFragment() {
        return new FragmentKarsilama();
    }
}
