package com.duokan.reader.domain.bookshelf;

import com.duokan.core.app.ManagedApp;
import com.duokan.reader.common.async.work.C0523c;
import com.duokan.reader.common.p036b.C0542e;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.micloud.C1068i;
import com.duokan.reader.domain.statistics.dailystats.C1167a;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import java.io.File;
import org.json.JSONException;

class jk implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f3392a;
    /* renamed from: b */
    final /* synthetic */ String f3393b;
    /* renamed from: c */
    final /* synthetic */ FlowChargingTransferChoice f3394c;
    /* renamed from: d */
    final /* synthetic */ it f3395d;

    jk(it itVar, String str, String str2, FlowChargingTransferChoice flowChargingTransferChoice) {
        this.f3395d = itVar;
        this.f3392a = str;
        this.f3393b = str2;
        this.f3394c = flowChargingTransferChoice;
    }

    public void run() {
        jp b = this.f3395d.f3365i;
        if (b != null) {
            C0542e.m2413b(ManagedApp.get().getTopActivity());
            C1068i a = b.f3405b.m8112a().m8232a(this.f3392a, "/Books", this.f3393b, 5);
            try {
                a.m2306u().put("book_upload_choice_at_flow_charging", this.f3394c == null ? FlowChargingTransferChoice.Default.name() : this.f3394c.name());
            } catch (JSONException e) {
            }
            a.m8218a(new File(this.f3392a).length());
            b.f3405b.m8112a().m8233a(a);
            b.f3405b.m8112a().m2358a((C0523c) a);
            if (C0559f.m2476b().m2484c() && !it.m4704d(a)) {
                b.f3405b.m8112a().m2360a((C0523c) a, false);
            }
            C1167a.m8671d().m8685c(this.f3393b);
        }
    }
}
