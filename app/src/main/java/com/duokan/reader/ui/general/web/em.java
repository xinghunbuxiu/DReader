package com.duokan.reader.ui.general.web;

import android.widget.EditText;

import com.duokan.reader.ui.general.ReaderUi;

class em implements Runnable {
    final /* synthetic */ EditText a;
    final /* synthetic */ el b;

    em(el elVar, EditText editText) {
        this.b = elVar;
        this.a = editText;
    }

    public void run() {
        ReaderUi.a(this.b.e.b.b.getContext(), this.a);
    }
}
