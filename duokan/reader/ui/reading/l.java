package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.View;

import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.af;

class l extends af {
    final /* synthetic */ String a;
    final /* synthetic */ k b;

    l(k kVar, Context context, String str) {
        this.b = kVar;
        this.a = str;
        super(context);
    }

    public void cancel() {
        if (this.b.c.getText().toString().equals(this.a)) {
            super.cancel();
            return;
        }
        View focusedEditText = getFocusedEditText();
        if (focusedEditText != null) {
            ReaderUi.a(getContext(), focusedEditText);
        }
        this.b.b();
    }

    public boolean onBack() {
        if (this.b.c.getText().toString().equals(this.a)) {
            return super.onBack();
        }
        this.b.b();
        return true;
    }
}
