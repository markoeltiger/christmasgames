package com.mark.christmasgamess;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;

public class MainActivity extends AppCompatActivity {
    private RewardedInterstitialAd rewardedInterstitialAd;

    private static final String PREFS_NAME = "MyPrefs";
Button playbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                System.out.print("Initialization Done");
            }

        });
        AdView adView = new AdView(this);

        adView.setAdSize(AdSize.BANNER);

        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        playbutton=findViewById(R.id.Playbutton);
        SharedPreferences pref = MainActivity.this.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor= pref.edit();




        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean firstRun = pref.getBoolean("firstRun", true);
                if(firstRun)
                {
                    Log.i("onCreate: ","first time" );
                    editor.putBoolean("firstRun",false);
                    editor.commit();
                    if (isNetworkAvailable(MainActivity.this)){


                        Intent intent = new Intent(MainActivity.this, ChooseGame.class);
                        startActivity(intent);
}
                    else {
                        Toast.makeText(MainActivity.this,"Please Connect network for first time...",Toast.LENGTH_LONG).show();

                    }
                }
                else
                {
                    Log.i("onCreate: ","second time");

                    Intent intent = new Intent(
                            MainActivity.this, ChooseGame.class);
                    startActivity(intent);

                }



            }
        });


    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}