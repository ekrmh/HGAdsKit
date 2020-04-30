package com.ekrmh.hgadskit.ads.interstitial

interface InterstitialAd {
        fun loadAd()
        fun isLoaded(): Boolean
        fun show()
        fun setAdListener(listener: InterstitialListener)
}