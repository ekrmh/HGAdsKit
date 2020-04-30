package com.ekrmh.hgadskit.ads.rewarded



interface RewardedListener {
    fun onRewardAdClosed()
    fun onRewardAdOpened()
    fun onRewarded(reward: Reward?)
    fun onRewardAdFailedToShow(e: Int)
}