package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;

import com.duokan.core.app.x;
import com.duokan.reader.DkApp;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.bb;

import java.util.HashMap;

public class acw extends FrameLayout {
    private boolean a = false;
    private final lr b;
    private final yo c;

    public acw(Context context, x xVar) {
        super(context);
        this.b = new lr(DkApp.get().noDensityScaleContext(context));
        this.c = new yo(x.a(context), new acx(this, xVar));
        addView(this.b);
        addView(this.c.getContentView());
        this.b.setVisibility(4);
        setBackgroundColor(0);
    }

    protected void onDetachedFromWindow() {
        try {
            HashMap i = this.c.i();
            if (i.get("Action1") == "MARK" && !i.containsKey("Action2")) {
                i.put("Action2", "NONE");
            }
            if (i.containsKey("Action1")) {
                UmengManager.get().onEvent("READING_TEXT_MENU_STATS_V1", i);
            }
            this.c.i().clear();
        } catch (Throwable th) {
        }
        super.onDetachedFromWindow();
    }

    public void a(View view, Point point, Point point2) {
        this.b.setVisibility(0);
        this.b.setSourceView(view);
        this.b.a(point, point2);
        this.b.invalidate();
        this.c.e();
    }

    public void a(Rect[] rectArr) {
        String b;
        this.b.setVisibility(4);
        sh readingFeature = getReadingFeature();
        as aa = readingFeature.aa();
        bb selection = getReadingFeature().getSelection();
        if (aa.l().a((ay) selection)) {
            b = aa.b(selection);
        } else {
            b = readingFeature.getDocument().a(selection);
        }
        this.c.a(b, this.a, new acy(this, rectArr));
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void a() {
        this.b.setVisibility(4);
        this.c.e();
    }

    public boolean b() {
        return getParent() != null;
    }

    private sh getReadingFeature() {
        return (sh) x.a(getContext()).queryFeature(sh.class);
    }
}
