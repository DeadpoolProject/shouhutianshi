package liangkang.com.shouhutianshi.utils;

import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by luying on 16/6/15.
 */
public class DeviceUtils {
    public static boolean isTablet(Context c) {
        return (c.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;

    }
}
