package com.mark.christmasgamess

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback


class ChooseGame : AppCompatActivity() {
    private lateinit var coursesGV: RecyclerView
    private var rewardedInterstitialAd: RewardedInterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_game)
        coursesGV = findViewById(R.id.gridView)
        val courseModelArrayList: ArrayList<gamedata> = ArrayList<gamedata>()

        courseModelArrayList.add(gamedata( R.drawable.orig,"3D Santa Run","https://raizensoft.com/test/web-app/sr3d/preview/"))
        courseModelArrayList.add(gamedata( R.drawable.santahat,"3D Santa Hat","https://raizensoft.com/test/web-app/sh3d/preview/"))
        courseModelArrayList.add(gamedata(R.drawable.sanaskater,"Santa - The Skater ","https://mazaplabs.com/games/game02-santa_the_skater"))
        courseModelArrayList.add(gamedata(R.drawable.christmastree,"Christmas Tree - Create Video or Image","https://previews.customer.envatousercontent.com/files/422938085/index.html"))
        courseModelArrayList.add(gamedata(R.drawable.collectthegift,"Collect the Gifts ","https://previews.customer.envatousercontent.com/files/315712486/01/index.html"))
        courseModelArrayList.add(gamedata(R.drawable.protectthegifts,"Protect The Gifts ","https://previews.customer.envatousercontent.com/files/315712486/03/index.html"))
        courseModelArrayList.add(gamedata(R.drawable.coloringbook,"Christmas coloring book","https://previews.customer.envatousercontent.com/files/342350057/index.html"))
        courseModelArrayList.add(gamedata(R.drawable.santafly,"Flying Santa - Christmas Fun Game","https://mazaplabs.com/games/game31-flying_santa/"))

        courseModelArrayList.shuffle()
        val layoutManager = GridLayoutManager(this, 2)

        val adapterx = MyGamesAdapter(courseModelArrayList,this@ChooseGame)
        coursesGV.adapter=adapterx
        coursesGV.layoutManager=layoutManager
        loadAd()
    }
    fun loadAd() {
        // Use the test ad unit ID to load an ad.
        RewardedInterstitialAd.load(this@ChooseGame, "ca-app-pub-5439240748780768/6971499859",
            AdRequest.Builder().build(), object : RewardedInterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: RewardedInterstitialAd) {
                    rewardedInterstitialAd = ad
                    Log.e("TAG", "Ad was loaded.")
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    Log.e("TAG", loadAdError.toString())
                }
            })
    }
}