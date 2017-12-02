package com.duokan.reader.ui.surfing;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class b implements OnTouchListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.a.h != null) {
            return this.a.a(this.a.h, motionEvent, this.a.h.equals(this.a.b));
        }
        if (motionEvent.getX() <= ((float) (view.getWidth() / 2))) {
            return this.a.a(this.a.d, motionEvent, false);
        }
        return this.a.a(this.a.b, motionEvent, true);
    }
}
