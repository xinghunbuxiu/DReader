package com.duokan.reader.domain.downloadcenter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;

import com.duokan.reader.DkApp;
import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;
import com.duokan.reader.common.download.d;
import com.duokan.reader.common.download.e;

public class DownloadService extends Service implements d {
    public IBinder onBind(Intent intent) {
        return e.b();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (DkApp.get().isReady()) {
            a();
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void onCreate() {
        super.onCreate();
        if (DkApp.get().isReady()) {
            e.b().a((d) this, Looper.getMainLooper());
            r.a().a((d) this, Looper.getMainLooper());
            return;
        }
        stopSelf();
    }

    public void onDestroy() {
        super.onDestroy();
        if (DkApp.get().isReady()) {
            e.b().b(this, Looper.getMainLooper());
            r.a().b(this, Looper.getMainLooper());
        }
    }

    public void a(IDownloadTask iDownloadTask) {
    }

    public void a(IDownloadTask iDownloadTask, TaskStatus taskStatus) {
        a();
    }

    public void a(IDownloadTask iDownloadTask, TaskState taskState) {
        a();
    }

    private void a() {
        if (!e.b().a() && !r.a().b()) {
            stopSelf();
        }
    }
}
