package com.duokan.reader.ui.reading;

import android.graphics.Bitmap.Config;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.domain.document.ad;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class GifFrameLoader {
    /* renamed from: b */
    private static GifFrameLoader f9095b = null;
    /* renamed from: a */
    private boolean f9096a = false;
    /* renamed from: c */
    private final Semaphore f9097c = new Semaphore(0, true);
    /* renamed from: d */
    private final LinkedList<kf> f9098d = new LinkedList();

    enum FrameStatus {
        DIRTY,
        MARKED,
        READY,
        SHOW,
        DELETE
    }

    /* renamed from: a */
    public static GifFrameLoader m12418a() {
        if (f9095b == null) {
            f9095b = new GifFrameLoader();
        }
        return f9095b;
    }

    /* renamed from: a */
    public void m12423a(ad adVar, int i, int i2, int i3) {
        synchronized (this) {
            kf kfVar;
            for (int i4 = 0; i4 < this.f9098d.size(); i4++) {
                kfVar = (kf) this.f9098d.get(i4);
                if (kfVar.f10495d == FrameStatus.DIRTY && kfVar.f10493b.getWidth() == i2 && kfVar.f10493b.getHeight() == i3) {
                    kfVar.f10492a = i;
                    kfVar.f10494c = adVar;
                    kfVar.f10495d = FrameStatus.MARKED;
                    break;
                }
            }
            kfVar = null;
            if (kfVar == null) {
                kfVar = new kf(this);
                kfVar.f10492a = i;
                kfVar.f10494c = adVar;
                kfVar.f10493b = C0544a.m2447c(i2, i3, Config.ARGB_8888);
                kfVar.f10495d = FrameStatus.MARKED;
                this.f9098d.addFirst(kfVar);
            }
            if (!this.f9096a) {
                this.f9096a = true;
                new kg().start();
            }
            this.f9097c.release();
        }
    }

    /* renamed from: a */
    public void m12422a(ad adVar) {
        synchronized (this) {
            Collection linkedList = new LinkedList();
            for (int i = 0; i < this.f9098d.size(); i++) {
                kf kfVar = (kf) this.f9098d.get(i);
                if (kfVar.f10494c == adVar || !kfVar.f10494c.mo1395j()) {
                    kfVar.f10495d = FrameStatus.DELETE;
                    kfVar.f10493b.recycle();
                    linkedList.add(kfVar);
                }
            }
            this.f9098d.removeAll(linkedList);
            if (this.f9098d.size() == 0) {
                this.f9096a = false;
                this.f9097c.release();
            }
        }
    }

    /* renamed from: b */
    public kf m12424b(ad adVar, int i, int i2, int i3) {
        synchronized (this) {
            for (int i4 = 0; i4 < this.f9098d.size(); i4++) {
                kf kfVar = (kf) this.f9098d.get(i4);
                if (kfVar.f10495d == FrameStatus.READY && kfVar.f10493b.getWidth() == i2 && kfVar.f10493b.getHeight() == i3) {
                    return kfVar;
                }
            }
            return null;
        }
    }
}
