package com.duokan.reader.ui.reading;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.as;
import com.duokan.core.ui.bu;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.er;
import com.duokan.core.ui.es;

import org.apache.http.HttpStatus;

public class acr extends er {
    final /* synthetic */ TextSelectionController a;
    private final bu c = new bu();
    private final dt d = new dt();
    private final as e = new as();

    public acr(TextSelectionController textSelectionController, Activity activity, sh shVar) {
        this.a = textSelectionController;
        this.d.a(UTools.getScaledPagingTouchSlop(activity));
    }

    protected void a(View view, boolean z) {
        this.c.b(view, z);
        this.d.b(view, z);
        this.e.b(view, z);
        this.e.b(this.e.a() + HttpStatus.SC_MULTIPLE_CHOICES);
        if (!z) {
            c(this.a.d());
        }
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, es esVar) {
        if (!(esVar instanceof es)) {
            b(false);
        } else if (this.a.e.aE()) {
            b(false);
        } else if (c() && !e()) {
            if (this.a.d()) {
                Point point = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
                Rect rect = new Rect(0, 0, view.getWidth(), view.getHeight());
                this.a.b(Math.min(point.x, rect.width()), Math.min(point.y, rect.height()), motionEvent.getAction(), view);
                this.e.b(view, motionEvent, z, new act(this));
            } else {
                this.c.b(view, motionEvent, z, new acs(this, motionEvent));
            }
            if (!this.a.g()) {
                this.d.b(view, motionEvent, z, new acu(this));
            }
        }
    }
}
