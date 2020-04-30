package com.ekrmh.hgadskit.ads.interstitial

interface InterstitialListener {
    fun onAdFailed(errorCode: Int)
    fun onAdClosed()
    fun onAdClicked()
    fun onAdLeave()
    fun onAdOpened()
    fun onAdImpression()
    fun onAdLoaded()
}