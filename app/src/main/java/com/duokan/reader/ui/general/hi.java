package com.duokan.reader.ui.general;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.duokan.core.ui.dv;

class hi implements OnTouchListener {
    final /* synthetic */ hd a;
    final /* synthetic */ int b;
    final /* synthetic */ hg c;

    hi(hg hgVar, hd hdVar, int i) {
        this.c = hgVar;
        this.a = hdVar;
        this.b = i;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            View b = this.c.b();
            Rect rect = (Rect) dv.g.a();
            rect.set(b.getLeft(), b.getTop(), b.getRight(), b.getBottom());
            boolean z = !rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            dv.g.a(rect);
            if (z && (this.b & 1) == 1) {
                this.c.requestDetach();
            }
        }
        if ((this.b & 2) == 2) {
            return true;
        }
        return false;
    }
}
