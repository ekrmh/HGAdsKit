package com.ekrmh.hgadskit.ads.interstitial

import android.content.Context
import com.ekrmh.hgadskit.ads.AdsCreator
import com.ekrmh.hgadskit.utils.Utils

class HGInterstitialAd(val context: Context){

    private lateinit var interstitialAd: InterstitialAd

    fun initializeAd(huaweiAdId: String, googleAdId: String) {
        val serviceType = Utils.getServiceType(context)
        interstitialAd = AdsCreator.createInterstitialAd(context, serviceType, huaweiAdId, googleAdId)
    }

    fun loadAd() {
        if(!::interstitialAd.isInitialized)
            throw Exception("interstitialAd can not be null. Firstly call initializeAd() method.")
        interstitialAd.loadAd()
    }

    fun setAdListener(listener: InterstitialListener){
        interstitialAd.setAdListener(listener)
    }

    fun showAd(){
        if (interstitialAd.isLoaded())
            interstitialAd.show()
    }
}