package com.ekrmh.hgadskit.ads.banner

import android.view.View

interface BannerAd {
    fun getView(): View
    fun loadAd()
    fun setBannerListener(bannerListener: BannerListener)
}