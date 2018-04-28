package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.PageHeaderView;

public class mu extends LinearLayout {
    /* renamed from: a */
    kf f8968a = new kf(getContext());

    public mu(Context context) {
        super(context);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(C0252d.general__shared__eeeeee));
        View pageHeaderView = new PageHeaderView(getContext());
        pageHeaderView.setCenterTitle(C0258j.personal__reading_notes_view__title);
        pageHeaderView.setHasBackButton(true);
        addView(pageHeaderView);
        C0435s c0435s = (C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class);
        this.f8968a.m9955a(0, 0, 0, c0435s == null ? 0 : c0435s.getTheme().getPagePaddingBottom());
        addView(this.f8968a, new LayoutParams(-1, 0, 1.0f));
    }

    public DkWebListView getNoteSummaryListView() {
        return this.f8968a;
    }
}
