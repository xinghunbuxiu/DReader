package com.duokan.core.diagnostic;

import android.os.Handler;
import android.os.Looper;

import com.duokan.core.sys.TaskHandler;

class d extends Thread {
    public boolean isStop;
    final WebLog log;
    private StackTraceElement[] stackTrace;

    private d(WebLog aVar) {
        this.log = aVar;
        this.isStop = false;
        this.stackTrace = new StackTraceElement[0];
    }

    public void run() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (!this.isStop) {
            e eVar = new e(this);
            handler.post(eVar);
            try {
                Thread.sleep(5000);
                if (!eVar.a) {
                    handler.removeCallbacks(eVar);
                    StackTraceElement[] stackTraceElementArr = this.stackTrace;
                    this.stackTrace = TaskHandler.getThread().getStackTrace();
                    if (this.stackTrace.length == stackTraceElementArr.length) {
                        Object obj = 1;
                        for (int i = 0; i < this.stackTrace.length; i++) {
                            if (!this.stackTrace[i].equals(stackTraceElementArr[i])) {
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
