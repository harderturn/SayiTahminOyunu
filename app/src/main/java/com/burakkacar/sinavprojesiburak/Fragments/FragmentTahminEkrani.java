package com.burakkacar.sinavprojesiburak.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.burakkacar.sinavprojesiburak.R;

import java.util.Random;

/**
 * Created by MuhammedBurak on 4.1.2017.
 */

public class FragmentTahminEkrani extends Fragment
{
    int kalanHak = 10;
    int gizliSayi = 0;
    int tahminEdilen = 0;
    int denemeSayisi = 1;
    TextView txtKalanHak;
    EditText editTextGirilenSayi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tahmin,container,false);

        txtKalanHak = (TextView) view.findViewById(R.id.txt_kalan_hak);

        Random r = new Random();
        gizliSayi = r.nextInt(100);
        txtKalanHak.setText(getResources().getString(R.string.kalan_hak)+" "+kalanHak);

        editTextGirilenSayi = (EditText)view.findViewById(R.id.editText_girilen_sayi);
        editTextGirilenSayi.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    kontrolEt();
                }
                return false;
            }
        });


        return view;
    }

    public void kontrolEt()
    {
        editTextGirilenSayi = (EditText)getActivity().findViewById(R.id.editText_girilen_sayi);

        if (!editTextGirilenSayi.getText().toString().equals(""))
        {
            tahminEdilen = Integer.valueOf(String.valueOf(editTextGirilenSayi.getText()));
            if (tahminEdilen == gizliSayi && kalanHak>0)
            {
                Toast.makeText(getActivity(),R.string.tahmin_dogru,Toast.LENGTH_LONG).show();
                hakGuncelle(true);

            }
            else if(tahminEdilen != gizliSayi && kalanHak>0)
            {
                Toast.makeText(getActivity(),R.string.tahmin_yanlis,Toast.LENGTH_SHORT).show();
                hakGuncelle(false);
                editTextGirilenSayi.setText("");
            }
            else if(kalanHak<=0)
            {
                txtKalanHak.setText(getResources().getString(R.string.haklar_bitti));
                Toast.makeText(getActivity(),"Doğru cevap: "+String.valueOf(gizliSayi),Toast.LENGTH_SHORT).show();
            }
        }
        else // Hatalı giriş yapıldığında
        {
            Toast.makeText(getActivity(),"Hatalı giriş yaptınız !",Toast.LENGTH_SHORT).show();
        }
    }

    public void hakGuncelle(boolean dogruMu)
    {
        txtKalanHak = (TextView)getActivity().findViewById(R.id.txt_kalan_hak);

        if (dogruMu)
        {
            txtKalanHak.setText(denemeSayisi+" "+getResources().getString(R.string.tahmin_sayisi));
        }
        else
        {
            kalanHak--;
            if (kalanHak==0)
            {
                txtKalanHak.setText(getResources().getString(R.string.haklar_bitti));
                Toast.makeText(getActivity(),"Doğru cevap: "+String.valueOf(gizliSayi),Toast.LENGTH_SHORT).show();
            }
            else
            {
                denemeSayisi++;
                txtKalanHak.setText(getResources().getString(R.string.kalan_hak)+" "+kalanHak);
            }
        }
    }
}
