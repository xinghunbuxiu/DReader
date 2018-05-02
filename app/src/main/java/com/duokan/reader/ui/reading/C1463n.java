package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.duokan.reader.ui.reading.n */
class C1463n implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1460k f10654a;

    C1463n(C1460k c1460k) {
        this.f10654a = c1460k;
    }

    public void onClick(View view) {
        if (this.f10654a.f10486d != null) {
            this.f10654a.f10486d.mo2508a(this.f10654a.f10485c.getText().toString());
        }
        this.f10654a.f10484b.dismiss();
    }
}
