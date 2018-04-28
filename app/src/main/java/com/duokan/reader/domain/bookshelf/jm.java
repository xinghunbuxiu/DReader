package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.micloud.C1068i;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import org.json.JSONException;

class jm implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1068i f3399a;
    /* renamed from: b */
    final /* synthetic */ FlowChargingTransferChoice f3400b;
    /* renamed from: c */
    final /* synthetic */ it f3401c;

    jm(it itVar, C1068i c1068i, FlowChargingTransferChoice flowChargingTransferChoice) {
        this.f3401c = itVar;
        this.f3399a = c1068i;
        this.f3400b = flowChargingTransferChoice;
    }

    public void run() {
        jp b = this.f3401c.f3365i;
        if (b != null) {
            try {
                this.f3399a.m2306u().put("book_upload_choice_at_flow_charging", this.f3400b == null ? FlowChargingTransferChoice.Default.name() : this.f3400b.name());
            } catch (JSONException e) {
            }
            b.f3405b.m8112a().m8233a(this.f3399a);
            b.f3405b.m8112a().m2358a(this.f3399a);
            if (C0559f.m2476b().m2484c() && !it.m4704d(this.f3399a)) {
                b.f3405b.m8112a().m2360a(this.f3399a, false);
            }
        }
    }
}
