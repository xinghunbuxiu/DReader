package com.duokan.reader.ui.general.web;

import android.content.Intent;
import android.net.Uri;
import com.duokan.core.app.AppManage;
import java.util.List;
import java.util.concurrent.Callable;

class ki implements Callable<Boolean> {
    /* renamed from: a */
    final /* synthetic */ String f8098a;
    /* renamed from: b */
    final /* synthetic */ ci f8099b;

    ki(ci ciVar, String str) {
        this.f8099b = ciVar;
        this.f8098a = str;
    }

    public /* synthetic */ Object call() {
        return m11263a();
    }

    /* renamed from: a */
    public Boolean m11263a() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.f8098a));
        List queryIntentActivities = this.f8099b.f7581b.getContext().getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return Boolean.valueOf(false);
        }
        AppManage.getCurrentActivity(this.f8099b.f7581b.getContext()).startActivity(intent);
        return Boolean.valueOf(true);
    }
}
