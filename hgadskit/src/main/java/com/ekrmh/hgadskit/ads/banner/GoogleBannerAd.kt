package com.ekrmh.hgadskit.ads.banner

import android.content.Context
import android.view.View
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

class GoogleBannerAd(
    context: Context,
    adId: String,
    bannerSize: BannerSize
): BannerAd{

    private val bannerView = AdView(context).also {
        it.adUnitId = adId
        it.adSize = when(bannerSize){
            BannerSize.BANNER_SIZE_320_50 -> AdSize.BANNER
            BannerSize.BANNER_SIZE_320_100  -> AdSize.LARGE_BANNER
            BannerSize.BANNER_SIZE_300_250  -> AdSize.MEDIUM_RECTANGLE
            BannerSize.BANNER_SIZE_360_57  -> AdSize.FULL_BANNER
            BannerSize.BANNER_SIZE_360_144  -> AdSize.LEADERBOARD
            BannerSize.BANNER_SIZE_SMART -> AdSize.SMART_BANNER
        }
    }

    override fun getView(): View {
        return bannerView
    }

    override fun loadAd() {
        val adParam = AdRequest.Builder()
            .build()
        bannerView.loadAd(adParam)
    }

    override fun setBannerListener(bannerListener: BannerListener) {
        bannerView.adListener = object : AdListener() {
            override fun onAdImpression() {
                super.onAdImpression()
                bannerListener.onAdImpression()
            }

            override fun onAdFailedToLoad(p0: Int) {
                super.onAdFailedToLoad(p0)
                bannerListener.onAdFailed(p0)

            }

            override fun onAdLeftApplication() {
                super.onAdLeftApplication()
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