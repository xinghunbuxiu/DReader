package com.duokan.reader.domain.ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.duokan.core.app.x;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.ui.reading.sh;

public class AppInstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            CharSequence action = intent.getAction();
            sh shVar;
            if (TextUtils.equals(action, "android.intent.action.PACKAGE_ADDED")) {
                if (TextUtils.equals("com.tencent.mm", intent.getData().getSchemeSpecificPart())) {
                    ThirdWeiXin.asyncResetInstalledStatus();
                }
                shVar = (sh) x.a(context).queryFeature(sh.class);
                if (shVar != null && shVar.bk() != null) {
                    shVar.bk().a(intent.getData().getSchemeSpecificPart());
                }
            } else if (TextUtils.equals(action, "android.intent.action.PACKAGE_REMOVED")) {
                if (TextUtils.equals("com.tencent.mm", intent.getData().getSchemeSpecificPart())) {
                    ThirdWeiXin.asyncResetInstalledStatus();
                }
                shVar = (sh) x.a(context).queryFeature(sh.class);
                if (shVar != null && shVar.bk() != null) {
                    shVar.bk().b(intent.getData().getSchemeSpecificPart());
                }
            }
        } catch (Throwable th) {
        }
    }
}
