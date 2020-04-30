package com.ekrmh.hgadskit.utils

import android.content.Context
import com.ekrmh.hgadskit.ads.ServiceType
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.huawei.hms.api.HuaweiApiAvailability

object Utils {

    fun getServiceType(context: Context) =
        if (isGooglePlayServicesAvailable(context))
        ServiceType.GOOGLE
    else if (isHuaweiMobileServicesAvailable(context))
        ServiceType.HUAWEI
    else
        ServiceType.GOOGLE


    private fun isGooglePlayServicesAvailable(context: Context): Boolean {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == ConnectionResult.SUCCESS

    }

    private fun isHuaweiMobileServicesAvailable(context: Context): Boolean {
        return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context)  == com.huawei.hms.api.ConnectionResult.SUCCESS
    }
}