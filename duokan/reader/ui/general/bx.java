package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.ui.f;
import com.duokan.reader.DkApp;

public class bx extends f {
    private final dq a;
    private ib b;

    public bx(Context context) {
        super(context);
        if (DkApp.get().forHd()) {
            this.a = new fi(this);
        } else {
            this.a = new gn(this);
        }
    }

    public bx(Context context, boolean z) {
        super(context);
        if (z) {
            this.a = new fi(this);
        } else if (DkApp.get().forHd()) {
            this.a = new fi(this);
        } else {
            this.a = new gn(this);
        }
    }

    public void a(Rect rect) {
        if (this.a instanceof fi) {
            ((fi) this.a).a(rect);
        } else {
            show();
        }
    }

    public void a(View view) {
        if (this.a instanceof fi) {
            ((fi) this.a).a(view);
        } else {
            show();
        }
    }

    public final int a(String str) {
        int childCount = this.a.a().getChildCount();
        View a = a(str, childCount != 0);
        a.setOnClickListener(new by(this, childCount));
        this.a.a().addView(a, childCount, new LayoutParams(-1, -2));
        return childCount;
    }

    public void a(ib ibVar) {
        this.b = ibVar;
    }

    private View a(String str, boolean z) {
        return this.a.a(str, 0, z);
    }
}
