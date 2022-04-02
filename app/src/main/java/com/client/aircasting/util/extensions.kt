package com.client.aircasting.util

import android.app.Activity
import android.content.Context
import android.location.LocationManager
import android.os.Build
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.TextView
import com.client.aircasting.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MapStyleOptions

fun Context.areLocationServicesOn(): Boolean {
    val manager = getSystemService(Context.LOCATION_SERVICE) as LocationManager?
    return manager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)
}

fun styleGoogleMap(map: GoogleMap, context: Context) {
    map.setMapStyle(
        MapStyleOptions.loadRawResourceStyle(
            context, R.raw.map_style
        )
    )
}

fun labelFormat(value: Float?): String {
    return "%d".format(value?.toInt())
}

fun TextView.setAppearance(context: Context, res: Int) {
    if (Build.VERSION.SDK_INT < 23) {
        setTextAppearance(context, res)
    } else {
        setTextAppearance(res)
    }
}

fun adjustMenuVisibility(
    activity: Activity,
    isFollowingTab: Boolean,
    followingSessionsNumber: Int = 0
) {
    val visibility =
        if (isFollowingTab && followingSessionsNumber >= 2) View.VISIBLE else View.INVISIBLE
    //TODO - Hide the appbar
}

fun isValidEmail(target: String): Boolean {
    return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches())
}
