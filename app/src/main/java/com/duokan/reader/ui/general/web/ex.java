package com.duokan.reader.ui.general.web;

import android.widget.EditText;
import com.duokan.reader.ui.general.ReaderUi;

class ex implements Runnable {
    /* renamed from: a */
    final /* synthetic */ EditText f7809a;
    /* renamed from: b */
    final /* synthetic */ ew f7810b;

    ex(ew ewVar, EditText editText) {
        this.f7810b = ewVar;
        this.f7809a = editText;
    }

    public void run() {
        ReaderUi.m10162a(this.f7810b.f7808e.f7793b.f7581b.getContext(), this.f7809a);
    }
}
