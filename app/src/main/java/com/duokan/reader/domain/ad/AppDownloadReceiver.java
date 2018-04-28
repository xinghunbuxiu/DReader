package com.duokan.reader.domain.ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.duokan.core.app.AppContext;
import com.duokan.reader.ui.reading.su;

public class AppDownloadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.getAction().equals("com.xiaomi.market.DOWNLOAD_INSTALL_RESULT")) {
                su suVar = (su) AppContext.getAppContext(context).queryFeature(su.class);
                if (suVar != null && suVar.bl() != null) {
                    switch (intent.getIntExtra("errorCode", -1)) {
                        case 2:
                            suVar.bl().m12762c(intent.getStringExtra("packageName"));
                            return;
                        case 3:
                            suVar.bl().m12764d(intent.getStringExtra("packageName"));
                            return;
                        default:
                            return;
                    }
                }
            }
        } catch (Throwable th) {
        }
    }
}
