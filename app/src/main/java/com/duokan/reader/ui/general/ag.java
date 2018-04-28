package com.duokan.reader.ui.general;

import android.widget.EditText;
import com.duokan.core.sys.IdleHandlerListener;

class ag implements IdleHandlerListener {
    /* renamed from: a */
    final /* synthetic */ af f6929a;

    ag(af afVar) {
        this.f6929a = afVar;
    }

    public boolean idleRun() {
        EditText focusedEditText = this.f6929a.getFocusedEditText();
        if (focusedEditText != null) {
            ReaderUi.m10162a(this.f6929a.getContext(), focusedEditText);
        }
        return false;
    }
}
