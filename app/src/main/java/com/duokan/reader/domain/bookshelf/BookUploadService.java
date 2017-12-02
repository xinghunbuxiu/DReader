package com.duokan.reader.domain.bookshelf;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.duokan.reader.DkApp;
import com.duokan.reader.common.async.work.r;

public class BookUploadService extends Service implements r {
    private Binder a = new Binder();

    public IBinder onBind(Intent intent) {
        return this.a;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (DkApp.get().isReady()) {
            b();
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void onCreate() {
        super.onCreate();
        if (DkApp.get().isReady()) {
            iz.a().a((r) this);
        } else {
            stopSelf();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (DkApp.get().isReady()) {
            iz.a().b((r) this);
        }
    }

    public void a() {
        b();
    }

    private void b() {
        if (iz.a().g().isEmpty()) {
            stopSelf();
        }
    }
}
