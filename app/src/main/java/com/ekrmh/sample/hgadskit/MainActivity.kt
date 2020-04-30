package com.ekrmh.sample.hgadskit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.ekrmh.hgadskit.ads.banner.BannerSize
import com.ekrmh.hgadskit.ads.interstitial.HGInterstitialAd
import com.ekrmh.hgadskit.ads.interstitial.InterstitialListener
import com.ekrmh.hgadskit.ads.rewarded.HGRewardedAd
import com.ekrmh.hgadskit.ads.rewarded.RewardedListener
import com.ekrmh.hgadskit.ads.rewarded.Reward
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showBannerAd()
        showRewardedAd()
        showInterstitialAd()
    }

    private fun showRewardedAd() {
        buttonRewarded.setOnClickListener {
            val rewardedAd = HGRewardedAd(this)
            rewardedAd.initializeAd(
                "testx9dtjwj8hp",
                "ca-app-pub-3940256099942544/5224354917"
            )
            rewardedAd.loadAd({
                Toast.makeText(this, "Rewarded Ad Load Success", Toast.LENGTH_SHORT).show()

                rewardedAd.showAd(object: RewardedListener {
                    override fun onRewardAdClosed() {
                        Log.d(TAG, "onRewardAdClosed")
                    }
                    override fun onRewardAdOpened() {
                        Log.d(TAG, "onRewardAdOpened")
                    }
                    override fun onRewarded(reward: Reward?) {
                        Log.d(TAG, "onRewarded: ${reward?.name} - ${reward?.amount}")
                    }
                    override fun onRewardAdFailedToShow(e: Int) {
                        Log.d(TAG, "onRewardAdFailedToShow: $e")
                    }
                })

            }, {
                Toast.makeText(this, "Rewarded Ad Load Fail", Toast.LENGTH_SHORT).show()
            })

        }
    }

    private fun showBannerAd() {
        bannerAd.initializeAd(
            "testw6vs28auh3",
            "ca-app-pub-3940256099942544/6300978111",
            BannerSize.BANNER_SIZE_300_250
        )
        bannerAd.loadAd()
    }

    private fun showInterstitialAd() {
        buttonInterstitial.setOnClickListener {
            val interstitialAd = HGInterstitialAd(this)

            // Video test ids
            // Google: ca-app-pub-3940256099942544/8691691433
            // Huawei: testb4znbuh3n2
            interstitialAd.initializeAd(
                "teste9ih9j0rc3",
                "ca-app-pub-3940256099942544/1033173712"
            )
            interstitialAd.setAdListener(object: InterstitialListener {
                override fun onAdFailed(errorCode: Int) {

                }

                override fun onAdClosed() {
                }

                override fun onAdClicked() {
                }

                override fun onAdLeave() {
                }

                override fun onAdOpened() {
                }

                override fun onAdImpression() {
                }

                override fun onAdLoaded() {
                    // Ad loaded
                    interstitialAd.showAd()
                }

            })
            interstitialAd.loadAd()

        }

    }
}
