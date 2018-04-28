package com.duokan.reader.ui.reading;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.dt;
import com.duokan.core.ui.et;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.reading.FixedPageClipView.ClipIndicator;

public class iz extends ActivatedController {
    /* renamed from: a */
    private final dt f10414a;
    /* renamed from: b */
    private final et f10415b;
    /* renamed from: c */
    private final FixedPageClipView f10416c;
    /* renamed from: d */
    private ClipIndicator f10417d = ClipIndicator.UNKNOW;

    public iz(IFeature mFeature, su suVar, jc jcVar) {
        super(mFeature);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        View pageHeaderView = new PageHeaderView(getContext());
        pageHeaderView.setLeftTitle(C0247i.reading__shared__clip_pages);
        linearLayout.addView(pageHeaderView, new LayoutParams(-1, -2));
        this.f10416c = new FixedPageClipView(getContext(), suVar, new ja(this, jcVar));
        linearLayout.addView(this.f10416c, new LayoutParams(-1, -1));
        setContentView(linearLayout);
        this.f10415b = new et();
        this.f10414a = new dt();
        this.f10415b.m2041a(this.f10414a);
        this.f10415b.m2046b(this.f10416c);
        this.f10415b.m2042a(new jb(this));
    }
}
