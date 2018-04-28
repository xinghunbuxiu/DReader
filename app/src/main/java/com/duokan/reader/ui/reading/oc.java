package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.sys.af;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.ap;

class oc implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ nu f10730a;

    oc(nu nuVar) {
        this.f10730a = nuVar;
    }

    public void onClick(View view) {
        C0800c G = this.f10730a.f10700b.mo1992G();
        if (G.ak() && !G.al()) {
            if (G.m4170W()) {
                G.ac();
            } else if (!G.mo1038k() || (!G.m4172Y() && !G.m4173Z())) {
                ((bm) this.f10730a.f10700b).mo2190c();
            } else if (C0559f.m2476b().m2484c()) {
                ap apVar = new ap(this.f10730a.getContext());
                apVar.setOkLabelResid(C0258j.general__shared__continue);
                apVar.setCancelLabel(C0258j.general__shared__cancel);
                apVar.setTitle(C0258j.bookshelf__book__download_dialog__title);
                apVar.setPrompt(C0258j.bookshelf__book__download_dialog__serial_prompt);
                apVar.open(new od(this, G));
            } else {
                G.m4201a(true, new af(Boolean.valueOf(true)));
            }
            this.f10730a.m14779f();
        }
    }
}
