package com.ekrmh.hgadskit.ads.banner

import android.content.Context
import android.view.View
import com.huawei.hms.ads.AdListener
import com.huawei.hms.ads.AdParam
import com.huawei.hms.ads.BannerAdSize.*
import com.huawei.hms.ads.banner.BannerView


class HuaweiBannerAd(
    context: Context,
    adId: String,
    bannerSize: BannerSize
): BannerAd{

    private val bannerView = BannerView(context).also {
        it.adId = adId
        it.bannerAdSize = when(bannerSize){
                    BannerSize.BANNER_SIZE_320_50 -> BANNER_SIZE_320_50
                    BannerSize.BANNER_SIZE_320_100  -> BANNER_SIZE_320_100
                    BannerSize.BANNER_SIZE_300_250  -> BANNER_SIZE_300_250
                    BannerSize.BANNER_SIZE_360_57  -> BANNER_SIZE_360_57
                    BannerSize.BANNER_SIZE_360_144  -> BANNER_SIZE_360_144
                    BannerSize.BANNER_SIZE_SMART -> BANNER_SIZE_SMART
        }
    }

    override fun getView(): View {
        return bannerView
    }

    override fun loadAd() {
        val adParam = AdParam.Builder()
            .build()
        bannerView.loadAd(adParam)
    }

    override fun setBannerListener(bannerListener: BannerListener) {
        bannerView.adListener = object : AdListener() {
            override fun onAdImpression() {
                super.onAdImpression()
                bannerListener.onAdImpression()
            }
            override fun onAdFailed(p0: Int) {
                super.onAdFailed(p0)
                bannerListener.onAdFailed(p0)
            }
            override fun onAdLeave() {
                super.onAdLeave()
                bannerListener.onAdLeave()
            }
            override fun onAdClicked() {
                super.onAdClicked()
                bannerListener.onAdClicked()
            }
            override fun onAdClosed() {
                super.onAdClosed()
                bannerListener.onAdClosed()
            }
            override fun onAdOpened() {
                super.onAdOpened()
                bannerListener.onAdOpened()
            }
            override fun onAdLoaded() {
                super.onAdLoaded()
                bannerListener.onAdLoaded()
            }
        }
    }

}