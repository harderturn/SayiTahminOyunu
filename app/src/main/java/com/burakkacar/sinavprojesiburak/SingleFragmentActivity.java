package com.burakkacar.sinavprojesiburak;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by MuhammedBurak on 4.1.2017.
 */

public abstract class SingleFragmentActivity extends FragmentActivity
{
    protected abstract Fragment CreateFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.my_container);

        if (fragment==null)
        {
            fragment = CreateFragment();
            fm.beginTransaction()
                    .add(R.id.my_container,fragment)
                    .commit();
        }
    }
}
