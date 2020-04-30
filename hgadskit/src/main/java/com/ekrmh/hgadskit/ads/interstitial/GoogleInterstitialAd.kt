package com.ekrmh.hgadskit.ads.interstitial

import android.content.Context
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest

class GoogleInterstitialAd(
    context: Context,
    adId: String
) : InterstitialAd{

    private val interstitialAd = com.google.android.gms.ads.InterstitialAd(context).also {
        it.adUnitId = adId
    }

    override fun loadAd() {
        val adParam = AdRequest.Builder().build()
        interstitialAd.loadAd(adParam)
    }

    override fun isLoaded(): Boolean {
        return interstitialAd.isLoaded
    }

    override fun show() {
        interstitialAd.show()
    }

    override fun setAdListener(listener: InterstitialListener) {
        val adListener = object : AdListener() {
            override fun onAdImpression() {
                super.onAdImpression()
                listener.onAdImpression()
            }

            override fun onAdFailedToLoad(p0: Int) {
                super.onAdFailedToLoad(p0)
                listener.onAdFailed(p0)
            }

            override fun onAdLeftApplication() {
                super.onAdLeftApplication()
                listener.onAdLeave()
            }

            override fun onAdClicked() {
                super.onAdClicked()
                listener.onAdClicked()
            }
            override fun onAdClosed() {
                super.onAdClosed()
                listener.onAdClosed()
            }
            override fun onAdOpened() {
                super.onAdOpened()
                listener.onAdOpened()
            }
            override fun onAdLoaded() {
                super.onAdLoaded()
                listener.onAdLoaded()
            }
        }
        interstitialAd.adListener = adListener
    }
}