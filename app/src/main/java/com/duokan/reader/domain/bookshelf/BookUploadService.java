package com.duokan.reader.domain.bookshelf;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.async.work.C0537r;

public class BookUploadService extends Service implements C0537r {
    /* renamed from: a */
    private Binder f2678a = new Binder();

    public IBinder onBind(Intent intent) {
        return this.f2678a;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (DkApp.get().isReady()) {
            m3709b();
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void onCreate() {
        super.onCreate();
        if (DkApp.get().isReady()) {
            it.m4692a().m4715a((C0537r) this);
        } else {
            stopSelf();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (DkApp.get().isReady()) {
            it.m4692a().m4728b((C0537r) this);
        }
    }

    /* renamed from: a */
    public void mo948a() {
        m3709b();
    }

    /* renamed from: b */
    private void m3709b() {
        if (it.m4692a().m4734e().isEmpty()) {
            stopSelf();
        }
    }
}
