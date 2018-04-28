package com.duokan.reader.ui.reading;

import com.duokan.reader.ReaderFeature;

class vf implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ve f11054a;

    vf(ve veVar) {
        this.f11054a = veVar;
    }

    public void run() {
        if (this.f11054a.f11053a.f11043a.mo1992G().ak()) {
            ((ReaderFeature) this.f11054a.f11053a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new er(this.f11054a.f11053a.getContext(), false), null);
        } else {
            ((ReaderFeature) this.f11054a.f11053a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new ex(this.f11054a.f11053a.getContext(), false), null);
        }
    }
}
