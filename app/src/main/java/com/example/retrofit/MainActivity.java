package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

@SuppressLint("NonConstantResourceId")
public class MainActivity extends AppCompatActivity
{
    private FrameLayout kontener;
    private Button bProdukcja, bPotrzeby, bZamowienia, bReklamacje, bProjekty, bPomysly;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Kontener na fragmenty
        kontener = findViewById(R.id.kontener);

        //PRODUKCJA
        bProdukcja = findViewById(R.id.btn_produkcja);
        bProdukcja.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showFragmentPRODUKCJA();
                setBtnBackground(bProdukcja);
            }
        });

        //POTRZEBY
        bPotrzeby = findViewById(R.id.btn_potrzeby);
        bPotrzeby.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setBtnBackground(bPotrzeby);
            }
        });

        //ZAMÓWIENIA
        bZamowienia = findViewById(R.id.btn_zamowienia);
        bZamowienia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setBtnBackground(bZamowienia);
            }
        });

        //REKLAMACJE
        bReklamacje = findViewById(R.id.btn_reklamacje);
        bReklamacje.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setBtnBackground(bReklamacje);
            }
        });

        //PROJEKTY
        bProjekty = findViewById(R.id.btn_projekty);
        bProjekty.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setBtnBackground(bProjekty);
            }
        });

        //POMYSLY
        bPomysly = findViewById(R.id.btn_pomysly);
        bPomysly.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setBtnBackground(bPomysly);
            }
        });

        //Domyślnie klik na przycisk PRODUKCJA
        bProdukcja.performClick();
    }

    //Fragment z danymi PRODUKCJA
    private void showFragmentPRODUKCJA()
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.kontener, new ProdukcjaFragment(),"VisibleFragment").commit();
    }

    //Funkcja do ustawiania koloru przycisku
    private void setBtnBackground(Button button)
    {
        bProdukcja.setBackground(AppCompatResources.getDrawable(this, R.drawable.button_background_default));
        bPotrzeby.setBackground(AppCompatResources.getDrawable(this, R.drawable.button_background_default));
        bZamowienia.setBackground(AppCompatResources.getDrawable(this, R.drawable.button_background_default));
        bReklamacje.setBackground(AppCompatResources.getDrawable(this, R.drawable.button_background_default));
        bProjekty.setBackground(AppCompatResources.getDrawable(this, R.drawable.button_background_default));
        bPomysly.setBackground(AppCompatResources.getDrawable(this, R.drawable.button_background_default));

        switch(button.getId())
        {
            case R.id.btn_produkcja:
                bProdukcja.setBackground(AppCompatResources.getDrawable(this, R.drawable.button_background_selected));
                break;

            case R.id.btn_potrzeby:
                bPotrzeby.setBackground(AppCompatResources.getDrawable(this, R.drawable.button_background_selected));
                break;

            case R.id.btn_zamowienia:
                bZamowienia.setBackground(AppCompatResources.getDrawable(this, R.drawable.button_background_selected));
                break;

            case R.id.btn_reklamacje:
                bReklamacje.setBackground(AppCompatResources.getDrawable(this, R.drawable.button_background_selected));
                break;

            case R.id.btn_projekty:
                bProjekty.setBackground(AppCompatResources.getDrawable(this, R.drawable.button_background_selected));
                break;

            case R.id.btn_pomysly:
                bPomysly.setBackground(AppCompatResources.getDrawable(this, R.drawable.button_background_selected));
                break;
        }
    }
}