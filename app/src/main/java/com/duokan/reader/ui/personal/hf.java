package com.duokan.reader.ui.personal;

import android.graphics.Rect;

class hf implements Runnable {
    /* renamed from: a */
    final /* synthetic */ fz f8649a;

    hf(fz fzVar) {
        this.f8649a = fzVar;
    }

    public void run() {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        boolean globalVisibleRect = this.f8649a.f8593t.getGlobalVisibleRect(rect);
        if (this.f8649a.f8593t.getLocalVisibleRect(rect2) && globalVisibleRect && rect2.height() == this.f8649a.f8593t.getHeight() && this.f8649a.f8574a.getPageCount() == 0) {
            this.f8649a.m11843a(rect);
        }
    }
}
