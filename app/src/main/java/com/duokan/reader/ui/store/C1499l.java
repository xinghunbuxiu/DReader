package com.duokan.reader.ui.store;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.PageHeaderView;
import org.apache.http.HttpStatus;

/* renamed from: com.duokan.reader.ui.store.l */
class C1499l extends DkWebListView {
    /* renamed from: a */
    final /* synthetic */ C1497j f11450a;
    /* renamed from: b */
    private final PageHeaderView f11451b;
    /* renamed from: c */
    private final Paint f11452c;
    /* renamed from: d */
    private final int f11453d;

    public C1499l(C1497j c1497j, Context context) {
        this.f11450a = c1497j;
        super(context);
        setBackgroundResource(C0252d.store__shared__bg);
        C0435s c0435s = (C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class);
        m9955a(0, 0, 0, c0435s == null ? 0 : c0435s.getTheme().getPagePaddingBottom());
        this.f11452c = new Paint();
        this.f11452c.setStrokeWidth(0.0f);
        this.f11452c.setColor(Color.rgb(HttpStatus.SC_MULTI_STATUS, HttpStatus.SC_MULTI_STATUS, HttpStatus.SC_MULTI_STATUS));
        setPullDownRefreshEnabled(false);
        this.f11451b = new PageHeaderView(getContext());
        this.f11451b.setHasBackButton(true);
        this.f11451b.setLeftTitle(c1497j.getString(C0258j.store__change_log_view__title));
        setTitleView(this.f11451b);
        setAdapter(new C1500m(this, c1497j));
        this.f11453d = (AnimUtils.m1932b(getContext(), 15.0f) + (getResources().getDrawable(C0254f.store__change_log_view__icon1).getIntrinsicWidth() / 2)) - 1;
    }

    protected void dispatchDraw(Canvas canvas) {
        if (getAdapter().mo506c() > 0) {
            canvas.drawLine((float) this.f11453d, (float) this.f11451b.getHeight(), (float) (this.f11453d + 1), (float) getHeight(), this.f11452c);
        }
        super.dispatchDraw(canvas);
    }
}
