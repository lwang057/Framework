package com.lwang.framework.app;

import android.content.Context;
import android.content.Intent;

import com.lwang.framework.ui.activity.TestActivity;

/**
 * AppNavigate.class
 *
 * @author lwang
 * @date 2017/10/21.
 */

public class AppNavigate {

    public void goToTestActivity(Context context) {

        if (context != null) {
            Intent intent = new Intent(context, TestActivity.class);
            intent.putExtra("aaa", "This Act is TestActivity");
            context.startActivity(intent);
        }
    }

}
