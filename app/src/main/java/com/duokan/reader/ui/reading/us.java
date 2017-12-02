package com.duokan.reader.ui.reading;

import com.duokan.reader.ReaderFeature;

class us implements Runnable {
    final /* synthetic */ ur a;

    us(ur urVar) {
        this.a = urVar;
    }

    public void run() {
        if (this.a.a.a.G().ai()) {
            ((ReaderFeature) this.a.a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new en(this.a.a.getContext(), false), null);
        } else {
            ((ReaderFeature) this.a.a.getContext().queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(new et(this.a.a.getContext(), false), null);
        }
    }
}
