package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class agi implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ agh f9759a;

    agi(agh agh) {
        this.f9759a = agh;
    }

    public void onClick(View view) {
        this.f9759a.m13704u();
        if (this.f9759a.m13689n().isPlaying()) {
            this.f9759a.m13689n().pause();
            this.f9759a.b.mo2428b();
            this.f9759a.f9751s = true;
            this.f9759a.m13698o();
        } else if (this.f9759a.f9750r) {
            this.f9759a.m13689n().start();
            this.f9759a.b.mo2429c();
            this.f9759a.f9751s = false;
            this.f9759a.m13698o();
        } else {
            this.f9759a.m13703t();
        }
    }
}
