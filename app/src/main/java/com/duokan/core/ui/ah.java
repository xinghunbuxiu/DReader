package com.duokan.core.ui;

import android.view.View;

class ah implements OnItemLongPressListener {
    /* renamed from: a */
    final /* synthetic */ ao f900a;
    /* renamed from: b */
    final /* synthetic */ HatGridView f901b;

    ah(HatGridView hatGridView, ao aoVar) {
        this.f901b = hatGridView;
        this.f900a = aoVar;
    }

    /* renamed from: a */
    public void onItemLongPress(ay ayVar, View view, int i) {
        this.f900a.mo1751a(this.f901b, view, i);
    }
}
