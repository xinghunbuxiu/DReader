package com.duokan.reader.ui.reading;

import com.duokan.b.i;
import com.duokan.reader.domain.ad.b;

class f implements b {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public void a() {
        if (this.a.d != null) {
            this.a.d.setText(i.general__shared__downloading);
        }
    }

    public void b() {
    }

    public void c() {
        if (this.a.d != null) {
            this.a.d.setText(i.general__shared__installed);
        }
    }

    public void d() {
        if (this.a.d != null) {
            if (this.a.b.g != 6 || this.a.b.v == null || this.a.b.v.isEmpty()) {
                this.a.d.setText(i.general__shared__download);
            } else {
                this.a.d.setText(i.general__shared__click_download);
            }
        }
    }

    public void e() {
        if (this.a.d != null) {
            this.a.d.setText(i.general__shared__install_start);
        }
    }

    public void a(int i) {
    }
}
