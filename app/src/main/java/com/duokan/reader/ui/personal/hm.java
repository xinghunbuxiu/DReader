package com.duokan.reader.ui.personal;

import android.view.View;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;
import com.duokan.reader.ReaderFeature;

class hm implements cg {
    /* renamed from: a */
    boolean f8661a = false;
    /* renamed from: b */
    final /* synthetic */ View f8662b;
    /* renamed from: c */
    final /* synthetic */ fz f8663c;

    hm(fz fzVar, View view) {
        this.f8663c = fzVar;
        this.f8662b = view;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
        boolean z2 = false;
        if (z && this.f8662b.getHeight() != 0) {
            int max = Math.max(this.f8662b.getHeight() - Math.max(0, (scrollable.getViewportBounds().top + this.f8662b.getHeight()) - this.f8663c.f8577d.getHeight()), 0);
            if (this.f8663c.f8599z != max) {
                this.f8663c.f8599z = max;
                this.f8662b.invalidate();
            }
            this.f8663c.f8577d.invalidate();
            if ((this.f8663c.f8599z < this.f8663c.f8597x && !this.f8661a) || (this.f8663c.f8599z == this.f8663c.f8597x && this.f8661a)) {
                if (!this.f8661a) {
                    z2 = true;
                }
                this.f8661a = z2;
                ((ReaderFeature) this.f8663c.getContext().queryFeature(ReaderFeature.class)).updateSystemUi(true);
            }
        }
    }
}
