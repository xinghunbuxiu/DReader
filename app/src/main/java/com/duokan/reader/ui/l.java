package com.duokan.reader.ui;

import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.ui.general.fy;

class l extends fy {
    final /* synthetic */ i a;
    private final FrameLayout b;
    private final float d;

    public l(i iVar, y yVar, e eVar, float f) {
        this.a = iVar;
        super(iVar, yVar, eVar);
        this.d = f;
        this.b = new m(this, getContext(), iVar);
        this.b.setLayoutParams(new LayoutParams(-1, -1));
        View view = new View(getContext());
        view.setBackgroundColor(-16777216);
        view.setEnabled(false);
        view.setClickable(true);
        this.b.addView(view, new LayoutParams(-1, -1));
        this.b.addView(c(), new LayoutParams(-1, -1));
        setContentView(this.b);
        if (Float.compare(this.d, 1.0f) < 0) {
            this.b.setOnTouchListener(new n(this, iVar));
        }
    }

    public final float a() {
        return this.d;
    }

    protected boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return false;
        }
        return true;
    }

    protected boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return false;
        }
        return true;
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.b.removeAllViews();
    }
}
