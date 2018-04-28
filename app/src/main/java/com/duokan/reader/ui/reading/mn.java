package com.duokan.reader.ui.reading;

import android.view.View;

class mn implements Runnable {
    /* renamed from: a */
    final /* synthetic */ View f10629a;
    /* renamed from: b */
    final /* synthetic */ mm f10630b;

    mn(mm mmVar, View view) {
        this.f10630b = mmVar;
        this.f10629a = view;
    }

    public void run() {
        this.f10629a.setVisibility(4);
    }
}
