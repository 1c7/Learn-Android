package com.example.agoodob.appmonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 2016/2/28
 *
 */
public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equals(action)){
            Toast.makeText(context, "你安装了新 APP", Toast.LENGTH_SHORT).show();

        } else if ("android.intent.action.PACKAGE_REPLACED".equals(action)){
            Toast.makeText(context, "你更新了一个 APP", Toast.LENGTH_SHORT).show();

        } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)){
            Toast.makeText(context, "你删掉了一个 APP", Toast.LENGTH_SHORT).show();

        }
    }
}
