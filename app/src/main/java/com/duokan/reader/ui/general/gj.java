package com.duokan.reader.ui.general;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.core.ui.C0343f;

class gj implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ gh f7280a;

    gj(gh ghVar) {
        this.f7280a = ghVar;
    }

    public void onClick(View view) {
        if (this.f7280a.f7274a instanceof C0343f) {
            ((C0343f) this.f7280a.f7274a).cancel();
        } else {
            this.f7280a.f7274a.dismiss();
        }
    }
}
