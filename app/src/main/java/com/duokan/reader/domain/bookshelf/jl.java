package com.duokan.reader.domain.bookshelf;

import com.duokan.core.app.ManagedApp;
import com.duokan.reader.common.async.work.C0523c;
import com.duokan.reader.common.p036b.C0542e;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.domain.micloud.C1068i;
import com.duokan.reader.domain.statistics.dailystats.C1167a;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import java.io.File;
import java.util.List;
import org.json.JSONException;

class jl implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f3396a;
    /* renamed from: b */
    final /* synthetic */ FlowChargingTransferChoice f3397b;
    /* renamed from: c */
    final /* synthetic */ it f3398c;

    jl(it itVar, List list, FlowChargingTransferChoice flowChargingTransferChoice) {
        this.f3398c = itVar;
        this.f3396a = list;
        this.f3397b = flowChargingTransferChoice;
    }

    public void run() {
        jp b = this.f3398c.f3365i;
        if (b != null) {
            C0542e.m2413b(ManagedApp.get().getTopActivity());
            for (File file : this.f3396a) {
                C1068i a = b.f3405b.m8112a().m8232a(file.getAbsolutePath(), "/Books", file.getName(), 5);
                try {
                    a.m2306u().put("book_upload_choice_at_flow_charging", this.f3397b == null ? FlowChargingTransferChoice.Default.name() : this.f3397b.name());
                } catch (JSONException e) {
                }
                a.m8218a(file.length());
                b.f3405b.m8112a().m8233a(a);
                b.f3405b.m8112a().m2358a((C0523c) a);
                if (C0559f.m2476b().m2484c() && !it.m4704d(a)) {
                    b.f3405b.m8112a().m2360a((C0523c) a, false);
                }
                C1167a.m8671d().m8685c(file.getName());
            }
        }
    }
}
