package com.duokan.reader.domain.downloadcenter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.download.C0594d;
import com.duokan.reader.common.download.C0596e;
import com.duokan.reader.common.download.IDownloadTask;
import com.duokan.reader.common.download.IDownloadTask.TaskState;
import com.duokan.reader.common.download.IDownloadTask.TaskStatus;

public class DownloadService extends Service implements C0594d {
    public IBinder onBind(Intent intent) {
        return C0596e.m2757b();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (DkApp.get().isReady()) {
            m7807a();
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void onCreate() {
        super.onCreate();
        if (DkApp.get().isReady()) {
            C0596e.m2757b().m2764a((C0594d) this, Looper.getMainLooper());
            C1030r.m7946a().m7958a((C0594d) this);
            return;
        }
        stopSelf();
    }

    public void onDestroy() {
        super.onDestroy();
        if (DkApp.get().isReady()) {
            C0596e.m2757b().m2769b(this, Looper.getMainLooper());
            C1030r.m7946a().m7962b((C0594d) this);
        }
    }

    /* renamed from: a */
    public void mo1471a(IDownloadTask iDownloadTask) {
    }

    /* renamed from: a */
    public void mo1473a(IDownloadTask iDownloadTask, TaskStatus taskStatus) {
        m7807a();
    }

    /* renamed from: a */
    public void mo1472a(IDownloadTask iDownloadTask, TaskState taskState) {
        m7807a();
    }

    /* renamed from: a */
    private void m7807a() {
        if (!C0596e.m2757b().m2766a() && !C1030r.m7946a().m7964b()) {
            stopSelf();
        }
    }
}
