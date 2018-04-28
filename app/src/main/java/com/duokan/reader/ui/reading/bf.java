package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class bf implements OnTouchListener {
    /* renamed from: a */
    final /* synthetic */ bd f9829a;

    bf(bd bdVar) {
        this.f9829a = bdVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        this.f9829a.f9824a.m14487a();
        return true;
    }
}
