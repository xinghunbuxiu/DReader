package com.duokan.reader.ui.surfing;

import android.view.View;

import com.duokan.core.app.FeatureListening;
import com.duokan.core.app.Inavigate;
import com.duokan.core.ui.er;

public interface af extends Inavigate, FeatureListening {
    void a(View view, Runnable runnable);

    void a(View view, boolean z, Runnable runnable);

    void a(er erVar);

    void a(boolean z, String str);

    void b(View view);

    void c(View view);

    void k();

    void m();

    void n();

    void o();

    void p();
}
