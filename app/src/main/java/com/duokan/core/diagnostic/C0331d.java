package com.duokan.core.diagnostic;

import android.os.Handler;
import android.os.Looper;

import com.duokan.core.sys.UThread;


public class C0331d extends Thread {


    final WebLog webLog;
    public boolean isRun = false;
    private StackTraceElement[] traceElements;

    private C0331d(WebLog webLog) {
        this.webLog = webLog;
        this.isRun = false;
        this.traceElements = new StackTraceElement[0];
    }

    public void run() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (!this.isRun) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    isRun = true;
                }
            };
            handler.post(runnable);
            try {
                Thread.sleep(5000);
                if (!isRun) {
                    handler.removeCallbacks(runnable);
                    StackTraceElement[] stackTraceElementArr = this.traceElements;
                    this.traceElements = UThread.getCurrentThread().getStackTrace();
                    if (this.traceElements.length == stackTraceElementArr.length) {
                        Object obj = 1;
                        for (int i = 0; i < this.traceElements.length; i++) {
                            if (!this.traceElements[i].equals(stackTraceElementArr[i])) {
                                obj = null;
                                break;
                            }
                        }
                        if (obj != null) {
                        }
                    }
                    this.webLog.printAllStackTraceString(LogLevel.WARNING, "anr", "ANR detected!");
                    IOnAnr c = this.webLog.onAnr;
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
