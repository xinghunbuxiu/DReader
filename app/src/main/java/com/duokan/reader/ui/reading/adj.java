package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.duokan.core.app.AppContext;
import com.duokan.reader.DkApp;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.bb;
import java.util.HashMap;

public class adj extends FrameLayout {
    /* renamed from: a */
    private boolean f9515a = false;
    /* renamed from: b */
    private final mb f9516b;
    /* renamed from: c */
    private final zb f9517c;

    public adj(Context context, C1447x c1447x) {
        super(context);
        this.f9516b = new mb(DkApp.get().noDensityScaleContext(context));
        this.f9517c = new zb(AppContext.getAppContext(context), new adk(this, c1447x));
        addView(this.f9516b);
        addView(this.f9517c.getContentView());
        this.f9516b.setVisibility(4);
        setBackgroundColor(0);
    }

    protected void onDetachedFromWindow() {
        try {
            HashMap i = this.f9517c.m15217i();
            if (i.get("Action1") == "MARK" && !i.containsKey("Action2")) {
                i.put("Action2", "NONE");
            }
            if (i.containsKey("Action1")) {
                UmengManager.get().onEvent("READING_TEXT_MENU_STATS_V1", i);
            }
            this.f9517c.m15217i().clear();
        } catch (Throwable th) {
        }
        super.onDetachedFromWindow();
    }

    /* renamed from: a */
    public void m13362a(View view, Point point, Point point2) {
        this.f9516b.setVisibility(0);
        this.f9516b.setSourceView(view);
        this.f9516b.m14631a(point, point2);
        this.f9516b.invalidate();
        this.f9517c.m15213e();
    }

    /* renamed from: a */
    public void m13364a(Rect[] rectArr) {
        String b;
        this.f9516b.setVisibility(4);
        su readingFeature = getReadingFeature();
        as aa = readingFeature.aa();
        bb selection = getReadingFeature().getSelection();
        if (aa.mo1332l().m5813a((ay) selection)) {
            b = aa.mo1303b(selection);
        } else {
            b = readingFeature.getDocument().m5902a(selection);
        }
        this.f9517c.mo2520a(b, this.f9515a, new adl(this, rectArr));
    }

    /* renamed from: a */
    public void m13363a(boolean z) {
        this.f9515a = z;
    }

    /* renamed from: a */
    public void m13361a() {
        this.f9516b.setVisibility(4);
        this.f9517c.m15213e();
    }

    /* renamed from: b */
    public boolean m13365b() {
        return getParent() != null;
    }

    private su getReadingFeature() {
        return (su) AppContext.getAppContext(getContext()).queryFeature(su.class);
    }
}
