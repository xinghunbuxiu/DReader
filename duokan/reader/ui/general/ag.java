package com.duokan.reader.ui.general;

import android.widget.EditText;

import com.duokan.core.sys.IdleStatus;

class ag implements IdleStatus {
    final /* synthetic */ af a;

    ag(af afVar) {
        this.a = afVar;
    }

    public boolean idleRun() {
        EditText focusedEditText = this.a.getFocusedEditText();
        if (focusedEditText != null) {
            ReaderUi.a(this.a.getContext(), focusedEditText);
        }
        return false;
    }
}
