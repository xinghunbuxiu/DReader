package com.duokan.reader.domain.downloadcenter;

import android.app.IntentService;
import android.content.Intent;

import com.duokan.reader.DkApp;

public class DownloadNotificationService extends IntentService {
    public DownloadNotificationService() {
        super(DownloadNotificationService.class.getName());
    }

    public DownloadNotificationService(String str) {
        super(str);
    }

    protected void onHandleIntent(Intent intent) {
        DkApp.get().runWhenAppReady(new n(this, intent));
    }
}
