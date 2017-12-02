package com.duokan.reader.ui.personal;

import android.graphics.Rect;

class gs implements Runnable {
    final /* synthetic */ fl a;

    gs(fl flVar) {
        this.a = flVar;
    }

    public void run() {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        boolean globalVisibleRect = this.a.u.getGlobalVisibleRect(rect);
        if (this.a.u.getLocalVisibleRect(rect2) && globalVisibleRect && rect2.height() == this.a.u.getHeight() && this.a.a.getPageCount() == 0) {
            this.a.a(rect);
        }
    }
}
