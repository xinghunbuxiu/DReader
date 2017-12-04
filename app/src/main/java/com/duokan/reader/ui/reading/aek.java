package com.duokan.reader.ui.reading;

import android.os.SystemClock;

import com.duokan.core.sys.TaskHandler;

class aek implements Runnable {
    public final int a;
    public long b = 0;
    public long c = 0;
    final /* synthetic */ adm d;

    public aek(adm com_duokan_reader_ui_reading_adm, int i) {
        this.d = com_duokan_reader_ui_reading_adm;
        this.a = i;
        this.b = SystemClock.uptimeMillis() + ((long) i);
    }

    public int a() {
        int i;
        if (this.c != 0) {
            i = (int) (this.b - this.c);
        } else {
            i = (int) (this.b - SystemClock.uptimeMillis());
        }
        return Math.max(0, i);
    }

    public void b() {
        if (this.d.k != null) {
            this.d.k.c();
        }
        this.d.k = this;
        TaskHandler.PostTask(this, this.b);
    }

    public void c() {
        TaskHandler.removeCallbacks(this);
        if (this.d.k == this) {
            this.d.k = null;
        }
    }

    public void d() {
        if (this.c == 0) {
            this.c = SystemClock.uptimeMillis();
            TaskHandler.removeCallbacks(this);
        }
    }

    public void e() {
        if (this.c != 0) {
            this.b += SystemClock.uptimeMillis() - this.c;
            this.c = 0;
            if (this.d.k == this) {
                TaskHandler.PostTask(this, this.b);
            }
        }
    }

    public void run() {
        if (this.d.k == this) {
            this.d.k = null;
            this.d.b();
        }
    }
}
