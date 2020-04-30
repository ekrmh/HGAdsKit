package com.ekrmh.hgadskit.ads.banner

interface BannerListener {
    fun onAdLoaded()
    fun onAdImpression()
    fun onAdFailed(errorCode: Int)
    fun onAdOpened()
    fun onAdClicked()
    fun onAdLeave()
    fun onAdClosed()
}