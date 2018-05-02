package com.duokan.reader.domain.p044b;

import android.app.Activity;
import android.content.Context;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.statistics.dailystats.C1167a;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.ap;

/* renamed from: com.duokan.reader.domain.b.k */
class C0790k extends ap {
    /* renamed from: a */
    final /* synthetic */ Activity f2645a;
    /* renamed from: b */
    final /* synthetic */ C0793n f2646b;
    /* renamed from: c */
    final /* synthetic */ C0781b f2647c;

    C0790k(C0781b c0781b, Context context, Activity activity, C0793n c0793n) {
        this.f2647c = c0781b;
        this.f2645a = activity;
        this.f2646b = c0793n;
        super(context);
    }

    protected void onOk() {
        if (C0559f.m2476b().m2485d()) {
            this.f2647c.m3687a(FlowChargingTransferChoice.NoTransfer);
            this.f2647c.m3658a(this.f2645a);
        } else {
            ap c0791l = new C0791l(this, this.f2645a);
            c0791l.setTitle(C0247i.f403x951330c1);
            c0791l.setPrompt(C0247i.f402x6fc181b);
            c0791l.setCancelLabel(C0247i.general__shared__cancel);
            c0791l.setOkLabelResid(C0247i.general__shared__confirm);
            c0791l.setCancelOnTouchOutside(false);
            c0791l.setCancelOnBack(false);
            c0791l.show();
        }
        this.f2646b.mo2475a();
        super.onOk();
    }

    protected void onCancel() {
        this.f2647c.m3658a(this.f2645a);
        C1167a.m8671d().m8687d("c");
        this.f2646b.mo2476b();
        super.onCancel();
    }
}
