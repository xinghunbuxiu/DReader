package com.duokan.reader.domain.ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.duokan.core.app.x;
import com.duokan.reader.ui.reading.sh;

public class AppDownloadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.getAction().equals("com.xiaomi.market.DOWNLOAD_INSTALL_RESULT")) {
                sh shVar = (sh) x.a(context).queryFeature(sh.class);
                if (shVar != null && shVar.bk() != null) {
                    switch (intent.getIntExtra("errorCode", -1)) {
                        case 2:
                            shVar.bk().c(intent.getStringExtra("packageName"));
                            return;
                        case 3:
                            shVar.bk().d(intent.getStringExtra("packageName"));
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
