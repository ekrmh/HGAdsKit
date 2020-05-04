package com.ekrmh.hgadskit.ads

import android.app.Activity
import android.content.Context
import com.ekrmh.hgadskit.ads.banner.*
import com.ekrmh.hgadskit.ads.interstitial.GoogleInterstitialAd
import com.ekrmh.hgadskit.ads.interstitial.HuaweiInterstitialAd
import com.ekrmh.hgadskit.ads.interstitial.InterstitialAd
import com.ekrmh.hgadskit.ads.rewarded.GoogleRewardedAd
import com.ekrmh.hgadskit.ads.rewarded.HuaweiRewardedAd
import com.ekrmh.hgadskit.ads.rewarded.RewardedAd
import com.ekrmh.hgadskit.utils.Utils

object AdsCreator {
    fun createBannerAd(
        context: Context,
        serviceType: ServiceType,
        huaweiAdId: String,
        googleAdId: String,
        bannerSize: BannerSize
    ): BannerAd{
        if (serviceType == ServiceType.HUAWEI)
            return HuaweiBannerAd(context, huaweiAdId, bannerSize)
        return GoogleBannerAd(context,googleAdId, bannerSize)
    }
    fun createRewardedAd(activity: Activity,
                         serviceType: ServiceType,
                         huaweiAdId: String,
                         googleAdId: String): RewardedAd {
        if (serviceType == ServiceType.HUAWEI)
            return HuaweiRewardedAd(activity, huaweiAdId)
        return GoogleRewardedAd(activity, googleAdId)
    }

    fun createInterstitialAd(
        context: Context,
        serviceType: ServiceType,
        huaweiAdId: String,
        googleAdId: String
    ): InterstitialAd {
        if (serviceType == ServiceType.HUAWEI)
            return HuaweiInterstitialAd(context, huaweiAdId)
        return GoogleInterstitialAd(context, googleAdId)
    }

    fun getServiceType(context: Context): ServiceType {
        return Utils.getServiceType(context)
    }
}