package com.ekrmh.hgadskit.ads.rewarded

import android.app.Activity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdCallback
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class GoogleRewardedAd(
    val activity: Activity,
    adId: String
): com.ekrmh.hgadskit.ads.rewarded.RewardedAd {

    private val rewardedAd = RewardedAd(activity, adId)

    override fun loadAd(success: (() -> Unit)?, failure: ((e: Int) -> Unit)?) {
        rewardedAd.loadAd(AdRequest.Builder().build(), object : RewardedAdLoadCallback() {
            override fun onRewardedAdFailedToLoad(p0: Int) {
                super.onRewardedAdFailedToLoad(p0)
                failure?.invoke(p0)

            }

            override fun onRewardedAdLoaded() {
                super.onRewardedAdLoaded()
                success?.invoke()
            }
        })

    }
    override fun isLoaded(): Boolean {
        return rewardedAd.isLoaded
    }

    override fun show(rewardedListener: RewardedListener?) {
        var listener: RewardedAdCallback? =null
        rewardedListener?.let {
            listener = object: RewardedAdCallback() {
                override fun onUserEarnedReward(p0: RewardItem) {
                    var reward: com.ekrmh.hgadskit.ads.rewarded.Reward? = null
                    val let = p0?.let {
                        reward = com.ekrmh.hgadskit.ads.rewarded.Reward(
                            it.amount,
                            it.type
                        )
                    }
                    rewardedListener.onRewarded(reward)
                }

                override fun onRewardedAdFailedToShow(p0: Int) {
                    super.onRewardedAdFailedToShow(p0)
                    rewardedListener.onRewardAdFailedToShow(p0)
                }

                override fun onRewardedAdClosed() {
                    super.onRewardedAdClosed()
                    rewardedListener.onRewardAdClosed()
                }

                override fun onRewardedAdOpened() {
                    super.onRewardedAdOpened()
                    rewardedListener.onRewardAdOpened()
                }
            }

        }
        rewardedAd.show(activity, listener)
    }

}