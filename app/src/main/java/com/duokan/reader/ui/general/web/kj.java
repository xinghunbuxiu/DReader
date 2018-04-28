package com.duokan.reader.ui.general.web;

import android.content.Intent;
import com.duokan.core.app.AppManage;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.ad.C0748e;
import java.util.concurrent.Callable;

class kj implements Callable<Boolean> {
    /* renamed from: a */
    final /* synthetic */ String f8100a;
    /* renamed from: b */
    final /* synthetic */ ci f8101b;

    kj(ci ciVar, String str) {
        this.f8101b = ciVar;
        this.f8100a = str;
    }

    public /* synthetic */ Object call() {
        return m11264a();
    }

    /* renamed from: a */
    public Boolean m11264a() {
        if (!ReaderEnv.get().onMiui()) {
            return Boolean.valueOf(false);
        }
        C0748e a = C0748e.m3555a(this.f8100a);
        if (a == null) {
            return Boolean.valueOf(false);
        }
        Intent launchIntentForPackage = this.f8101b.f7581b.getContext().getPackageManager().getLaunchIntentForPackage(a.f2533r);
        if (launchIntentForPackage == null) {
            return Boolean.valueOf(false);
        }
        AppManage.getCurrentActivity(this.f8101b.f7581b.getContext()).startActivity(launchIntentForPackage);
        return Boolean.valueOf(true);
    }
}
