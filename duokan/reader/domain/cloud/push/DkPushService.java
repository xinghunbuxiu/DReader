package com.duokan.reader.domain.cloud.push;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;

public class DkPushService extends Service {
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null && TextUtils.equals(intent.getAction(), "com.xiaomi.xmsf.push.SCAN")) {
            z.a().c();
        }
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
