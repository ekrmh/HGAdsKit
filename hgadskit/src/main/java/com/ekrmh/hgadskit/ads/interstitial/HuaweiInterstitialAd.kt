package com.ekrmh.hgadskit.ads.interstitial

import android.content.Context
import com.huawei.hms.ads.AdListener
import com.huawei.hms.ads.AdParam

class HuaweiInterstitialAd(
    context: Context,
    adId: String
) : InterstitialAd{

    private val interstitialAd = com.huawei.hms.ads.InterstitialAd(context).also {
        it.adId = adId
    }

    override fun loadAd() {
        val adParam = AdParam.Builder().build()
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
            override fun onAdFailed(p0: Int) {
                super.onAdFailed(p0)
                listener.onAdFailed(p0)
            }
            override fun onAdLeave() {
                super.onAdLeave()
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