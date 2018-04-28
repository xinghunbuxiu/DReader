package com.duokan.reader.ui.general;

class jc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ja f7429a;

    jc(ja jaVar) {
        this.f7429a = jaVar;
    }

    public void run() {
        if (this.f7429a.f7427f == this) {
            super.dismiss();
            this.f7429a.f7427f = null;
        }
    }
}
