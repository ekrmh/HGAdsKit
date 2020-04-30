package com.ekrmh.hgadskit.ads.rewarded

import android.app.Activity
import com.huawei.hms.ads.AdParam
import com.huawei.hms.ads.reward.*


class HuaweiRewardedAd(
    val activity: Activity,
    adId: String
): RewardedAd {

    private val rewardedAd = RewardAd(activity, adId)

    override fun loadAd(success: (() -> Unit)?, failure: ((e: Int) -> Unit)?) {
        rewardedAd.loadAd(AdParam.Builder().build(), object : RewardAdLoadListener() {
            override fun onRewardedLoaded() {
                super.onRewardedLoaded()
                success?.invoke()
            }

            override fun onRewardAdFailedToLoad(p0: Int) {
                super.onRewardAdFailedToLoad(p0)
                failure?.invoke(p0)
            }
        })

    }
    override fun isLoaded(): Boolean {
        return rewardedAd.isLoaded
    }

    override fun show(rewardedListener: RewardedListener?) {
        var listener: RewardAdStatusListener? =null
        rewardedListener?.let {
            listener = object: RewardAdStatusListener() {
                override fun onRewardAdFailedToShow(p0: Int) {
                    super.onRewardAdFailedToShow(p0)
                    rewardedListener.onRewardAdFailedToShow(p0)
                }

                override fun onRewardAdClosed() {
                    super.onRewardAdClosed()
                    rewardedListener.onRewardAdClosed()
                }

                override fun onRewardAdOpened() {
                    super.onRewardAdOpened()
                    rewardedListener.onRewardAdOpened()
                }

                override fun onRewarded(p0: com.huawei.hms.ads.reward.Reward?) {
                    super.onRewarded(p0)
                    var reward: Reward? = null
                    p0?.let {
                        reward = Reward(
                            it.amount,
                            it.name
                        )
                    }
                    rewardedListener.onRewarded(reward)
                }
            }
        }
        rewardedAd.show(activity, listener)
    }
}