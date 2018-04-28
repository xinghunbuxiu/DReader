package com.duokan.reader.ui.store;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.common.async.p035a.C0517a;

class az implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0517a f11340a;
    /* renamed from: b */
    final /* synthetic */ ay f11341b;

    az(ay ayVar, C0517a c0517a) {
        this.f11341b = ayVar;
        this.f11340a = c0517a;
    }

    public void onClick(View view) {
        this.f11341b.dismiss();
        this.f11340a.mo730a(null);
    }
}
