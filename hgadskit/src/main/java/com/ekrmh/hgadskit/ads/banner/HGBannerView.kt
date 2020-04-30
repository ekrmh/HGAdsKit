package com.ekrmh.hgadskit.ads.banner

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.ekrmh.hgadskit.R
import com.ekrmh.hgadskit.ads.AdsCreator
import com.ekrmh.hgadskit.utils.Utils
import kotlinx.android.synthetic.main.component_hg_banner_view.view.*

class HGBannerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private lateinit var view: View
    private lateinit var bannerAds: BannerAd

    init {
        initView()
    }

    private fun initView() {
        /**
         *  Inflate view
         */
        view = View.inflate(context, R.layout.component_hg_banner_view, this)
    }

    fun initializeAd(huaweiAdId: String, googleAdId: String, bannerSize: BannerSize){
        val serviceType = Utils.getServiceType(context)
        bannerAds =
            AdsCreator.createBannerAd(context, serviceType, huaweiAdId, googleAdId, bannerSize)
        view.banner_root.addView(bannerAds.getView())
    }

    fun loadAd() {
        if(!::bannerAds.isInitialized)
            throw Exception("bannerAds can not be null. Firstly call initializeAd() method.")
        bannerAds.loadAd()
    }

    fun setAdListener(bannerListener: BannerListener){
        bannerAds.setBannerListener(bannerListener)
    }
}