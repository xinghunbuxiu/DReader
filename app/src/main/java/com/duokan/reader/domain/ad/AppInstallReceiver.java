package com.duokan.reader.domain.ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.duokan.core.app.AppContext;
import com.duokan.reader.domain.account.oauth.ThirdWeiXin;
import com.duokan.reader.ui.reading.su;

public class AppInstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            CharSequence action = intent.getAction();
            su suVar;
            if (TextUtils.equals(action, "android.intent.action.PACKAGE_ADDED")) {
                if (TextUtils.equals("com.tencent.mm", intent.getData().getSchemeSpecificPart())) {
                    ThirdWeiXin.asyncResetInstalledStatus();
                }
                suVar = (su) AppContext.getAppContext(context).queryFeature(su.class);
                if (suVar != null && suVar.bl() != null) {
                    suVar.bl().m12758a(intent.getData().getSchemeSpecificPart());
                }
            } else if (TextUtils.equals(action, "android.intent.action.PACKAGE_REMOVED")) {
                if (TextUtils.equals("com.tencent.mm", intent.getData().getSchemeSpecificPart())) {
                    ThirdWeiXin.asyncResetInstalledStatus();
                }
                suVar = (su) AppContext.getAppContext(context).queryFeature(su.class);
                if (suVar != null && suVar.bl() != null) {
                    suVar.bl().m12760b(intent.getData().getSchemeSpecificPart());
                }
            }
        } catch (Throwable th) {
        }
    }
}
