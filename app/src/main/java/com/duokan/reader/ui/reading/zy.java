package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.be;

class zy implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ zx f11289a;

    zy(zx zxVar) {
        this.f11289a = zxVar;
    }

    public void onClick(View view) {
        Object trim = this.f11289a.f11288g.getEditableText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            be.m10286a(this.f11289a.getContext(), C0258j.reading__send_error_view__toast, 1).show();
            return;
        }
        ReaderUi.m10161a(this.f11289a.getContext(), this.f11289a.f11288g);
        this.f11289a.m15234a((String) trim);
        this.f11289a.f11287f.setEnabled(false);
    }
}
