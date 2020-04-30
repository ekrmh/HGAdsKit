package com.ekrmh.hgadskit.ads.rewarded

interface RewardedAd {
    fun loadAd(success: (() -> Unit)? = null, failure: ((e: Int) -> Unit)? = null)
    fun isLoaded(): Boolean
    fun show(rewardedListener: RewardedListener?=null)
}