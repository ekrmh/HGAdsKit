package com.ekrmh.hgadskit.ads.rewarded

import android.app.Activity
import com.ekrmh.hgadskit.ads.AdsCreator
import com.ekrmh.hgadskit.utils.Utils

class HGRewardedAd(private val activity: Activity) {

    private lateinit var rewardedAd: RewardedAd

    fun initializeAd(huaweiAdId: String, googleAdId: String) {
        val serviceType = Utils.getServiceType(activity)
        rewardedAd = AdsCreator.createRewardedAd(activity, serviceType, huaweiAdId, googleAdId)
    }

    fun loadAd(success: (() -> Unit)? = null, failure: ((e: Int) -> Unit)? = null) {
        if(!::rewardedAd.isInitialized)
            throw Exception("bannerAds can not be null. Firstly call initializeAd() method.")
        rewardedAd.loadAd(success, failure)
    }

    fun showAd(listener: RewardedListener?=null){
        if (rewardedAd.isLoaded())
            rewardedAd.show(listener)
    }
}