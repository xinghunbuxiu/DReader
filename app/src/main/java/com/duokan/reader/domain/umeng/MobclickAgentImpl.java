package com.duokan.reader.domain.umeng;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;

import java.util.HashMap;
import java.util.Map;

public class MobclickAgentImpl implements UmengAgent {
    public MobclickAgentImpl() {
        MobclickAgent.enableEncrypt(true);
    }

    public void onResume(Context context) {
        MobclickAgent.onResume(context);
    }

    public void onPause(Context context) {
        MobclickAgent.onPause(context);
    }

    public void onEvent(Context context, String str) {
        MobclickAgent.onEvent(context, str);
    }

    public void onEvent(Context context, String str, String str2) {
        MobclickAgent.onEvent(context, str, str2);
    }

    public void onEvent(Context context, String str, HashMap hashMap) {
        MobclickAgent.onEvent(context, str, (Map) hashMap);
    }

    public void setDebugMode(boolean z) {
        MobclickAgent.setDebugMode(z);
    }

    public void reportError(Context context, String str) {
        MobclickAgent.reportError(context, str);
    }
}
