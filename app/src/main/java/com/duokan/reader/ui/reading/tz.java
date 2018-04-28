package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.C0901g;

class tz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ty f11001a;

    tz(ty tyVar) {
        this.f11001a = tyVar;
    }

    public void run() {
        if (!this.f11001a.f11000c.f.mo1994K()) {
            C0901g b = this.f11001a.f10999b.mo1240h().mo1267b(this.f11001a.f10998a);
            if (b != null) {
                this.f11001a.f11000c.f9690q.setText(b.mo1202e());
            } else {
                this.f11001a.f11000c.f9690q.setText(this.f11001a.f11000c.f.mo1992G().ay());
            }
        }
    }
}
