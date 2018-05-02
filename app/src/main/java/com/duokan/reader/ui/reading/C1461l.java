package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.View;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.af;

/* renamed from: com.duokan.reader.ui.reading.l */
class C1461l extends af {
    /* renamed from: a */
    final /* synthetic */ String f10544a;
    /* renamed from: b */
    final /* synthetic */ C1460k f10545b;

    C1461l(C1460k c1460k, Context context, String str) {
        this.f10545b = c1460k;
        this.f10544a = str;
        super(context);
    }

    public void cancel() {
        if (this.f10545b.f10485c.getText().toString().equals(this.f10544a)) {
            super.cancel();
            return;
        }
        View focusedEditText = getFocusedEditText();
        if (focusedEditText != null) {
            ReaderUi.m10161a(getContext(), focusedEditText);
        }
        this.f10545b.m14531b();
    }

    public boolean onBack() {
        if (this.f10545b.f10485c.getText().toString().equals(this.f10544a)) {
            return super.onBack();
        }
        this.f10545b.m14531b();
        return true;
    }
}
