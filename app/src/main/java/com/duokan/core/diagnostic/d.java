package com.duokan.core.diagnostic;

import android.os.Handler;
import android.os.Looper;

import com.duokan.core.sys.t;

class d extends Thread {
    public boolean a;
    final /* synthetic */ a b;
    private StackTraceElement[] c;

    private d(a aVar) {
        this.b = aVar;
        this.a = false;
        this.c = new StackTraceElement[0];
    }

    public void run() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (!this.a) {
            Runnable eVar = new e(this);
            handler.post(eVar);
            try {
                Thread.sleep(5000);
                if (!eVar.a) {
                    handler.removeCallbacks(eVar);
                    StackTraceElement[] stackTraceElementArr = this.c;
                    this.c = t.b().getStackTrace();
                    if (this.c.length == stackTraceElementArr.length) {
                        Object obj = 1;
                        for (int i = 0; i < this.c.length; i++) {
                            if (!this.c[i].equals(stackTraceElementArr[i])) {
                                obj = null;
                                break;
                            }
                        }
                        if (obj != null) {
                        }
                    }
                    this.b.b(LogLevel.WARNING, "anr", "ANR detected!");
                    c c = this.b.g;
                    if (c != null) {
                        c.onAnr();
                    }
                }
            } catch (InterruptedException e) {
                return;
            } catch (Throwable th) {
            }
        }
    }
}
