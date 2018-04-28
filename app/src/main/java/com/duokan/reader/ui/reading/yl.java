package com.duokan.reader.ui.reading;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.duokan.p024c.C0255g;
import com.duokan.reader.ui.general.PagesView;

public class yl extends wy {
    /* renamed from: n */
    private fs f11196n = null;
    /* renamed from: o */
    private final View f11197o = findViewById(C0255g.reading__reading_view__chapter_info);
    /* renamed from: p */
    private final TextView f11198p = ((TextView) findViewById(C0255g.reading__reading_view__chapter_name));
    /* renamed from: q */
    private final TextView f11199q = ((TextView) findViewById(C0255g.reading__reading_view__chapter_index));

    public yl(Context context, xo xoVar) {
        super(context, xoVar);
    }

    protected fm getFixedPagesView() {
        return null;
    }

    protected fs getFlowPagesView() {
        return this.f11196n;
    }

    public PagesView getShowingPagesView() {
        return this.f11196n;
    }

    public hd getShowingDocPresenter() {
        return this.f11196n;
    }

    /* renamed from: a */
    public void mo2257a() {
        this.f11196n = new yg(getContext());
        this.b.addView(this.f11196n, new LayoutParams(-1, -1));
    }

    /* renamed from: a */
    public void m15171a(int i, String str, String str2) {
        this.f11197o.setVisibility(i);
        if (!TextUtils.isEmpty(str)) {
            this.f11198p.setVisibility(0);
            this.f11198p.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f11199q.setVisibility(0);
            this.f11199q.setText(str2);
        }
    }
}
