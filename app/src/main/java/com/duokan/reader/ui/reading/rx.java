package com.duokan.reader.ui.reading;

class rx implements Runnable {
    /* renamed from: a */
    final /* synthetic */ rw f10921a;

    rx(rw rwVar) {
        this.f10921a = rwVar;
    }

    public void run() {
        if (this.f10921a.f10920b.isMenuShowing()) {
            this.f10921a.f10920b.f9279c.mo2103b((Runnable) this);
        } else if (this.f10921a.f10920b.f9270J != null && this.f10921a.f10920b.f9270J.mo2382m()) {
            this.f10921a.f10920b.f9279c.mo2103b((Runnable) this);
        } else if (this.f10921a.f10920b.f9273M != null && this.f10921a.f10920b.f9273M.mo2295f()) {
            this.f10921a.f10920b.f9279c.mo2103b((Runnable) this);
        } else if (this.f10921a.f10919a != null) {
            this.f10921a.f10919a.run();
        }
    }
}
