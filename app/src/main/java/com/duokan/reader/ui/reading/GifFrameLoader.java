package com.duokan.reader.ui.reading;

import android.graphics.Bitmap.Config;

import com.duokan.reader.common.bitmap.a;
import com.duokan.reader.domain.document.ad;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class GifFrameLoader {
    private static GifFrameLoader b = null;
    private boolean a = false;
    private final Semaphore c = new Semaphore(0, true);
    private final LinkedList d = new LinkedList();

    enum FrameStatus {
        DIRTY,
        MARKED,
        READY,
        SHOW,
        DELETE
    }

    public static GifFrameLoader a() {
        if (b == null) {
            b = new GifFrameLoader();
        }
        return b;
    }

    public void a(ad adVar, int i, int i2, int i3) {
        synchronized (this) {
            jv jvVar;
            for (int i4 = 0; i4 < this.d.size(); i4++) {
                jvVar = (jv) this.d.get(i4);
                if (jvVar.d == FrameStatus.DIRTY && jvVar.b.getWidth() == i2 && jvVar.b.getHeight() == i3) {
                    jvVar.a = i;
                    jvVar.c = adVar;
                    jvVar.d = FrameStatus.MARKED;
                    break;
                }
            }
            jvVar = null;
            if (jvVar == null) {
                jvVar = new jv(this);
                jvVar.a = i;
                jvVar.c = adVar;
                jvVar.b = a.c(i2, i3, Config.ARGB_8888);
                jvVar.d = FrameStatus.MARKED;
                this.d.addFirst(jvVar);
            }
            if (!this.a) {
                this.a = true;
                new jw().start();
            }
            this.c.release();
        }
    }

    public void a(ad adVar) {
        synchronized (this) {
            Collection linkedList = new LinkedList();
            for (int i = 0; i < this.d.size(); i++) {
                jv jvVar = (jv) this.d.get(i);
                if (jvVar.c == adVar || !jvVar.c.j()) {
                    jvVar.d = FrameStatus.DELETE;
                    jvVar.b.recycle();
                    linkedList.add(jvVar);
                }
            }
            this.d.removeAll(linkedList);
            if (this.d.size() == 0) {
                this.a = false;
                this.c.release();
            }
        }
    }

    public jv b(ad adVar, int i, int i2, int i3) {
        synchronized (this) {
            for (int i4 = 0; i4 < this.d.size(); i4++) {
                jv jvVar = (jv) this.d.get(i4);
                if (jvVar.d == FrameStatus.READY && jvVar.b.getWidth() == i2 && jvVar.b.getHeight() == i3) {
                    return jvVar;
                }
            }
            return null;
        }
    }
}
