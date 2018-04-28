package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.hb;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;

public class xp extends wx {
    /* renamed from: a */
    private final View f11152a;
    /* renamed from: b */
    private final View f11153b;
    /* renamed from: c */
    private final su f11154c = ((su) getContext().queryFeature(su.class));

    public xp(IFeature mFeature) {
        super(mFeature);
        View inflate = LayoutInflater.from(getContext()).inflate(C0245g.reading__reading_viewtype_view, null);
        inflate.setLayoutParams(new LayoutParams(ReaderEnv.get().forHd() ? dv.m1932b(getContext(), 240.0f) : -1, -2));
        setContentView(inflate);
        this.f11152a = findViewById(C0244f.reading__reading_viewtype_view__single_page);
        this.f11153b = findViewById(C0244f.reading__reading_viewtype_view__scroll);
        this.f11152a.setOnClickListener(new xq(this));
        this.f11153b.setOnClickListener(new xs(this));
    }

    protected void onActive(boolean z) {
        m15070a();
        super.onActive(z);
    }

    /* renamed from: a */
    private final void m15070a() {
        boolean z;
        boolean z2 = true;
        hb b = this.f11154c.mo2095b();
        View view = this.f11152a;
        if (b.m4624e() == PageScaleType.MATCH_INSIDE) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        View view2 = this.f11153b;
        if (b.m4624e() != PageScaleType.MATCH_WIDTH) {
            z2 = false;
        }
        view2.setSelected(z2);
    }
}
