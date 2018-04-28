package com.duokan.reader.ui.store;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.dk;
import com.duokan.reader.ui.general.expandable.StateExpandableAdapter;

public class bc extends HatGridView {
    /* renamed from: a */
    private StateExpandableAdapter f11357a;
    /* renamed from: b */
    private DkStoreFictionDetail f11358b = null;
    /* renamed from: c */
    private DkCloudFictionChapter[] f11359c = new DkCloudFictionChapter[0];

    public bc(Context context) {
        super(context);
        setBackgroundColor(getResources().getColor(C0252d.store__shared__bg));
        View pageHeaderView = new PageHeaderView(getContext());
        pageHeaderView.setLeftTitle(C0258j.store__fiction_chapter_view__title1);
        setTitleView(pageHeaderView);
        Drawable dkVar = new dk(getResources().getColor(C0252d.general__shared__bcbcbc));
        dkVar.m10476a(0);
        int b = dv.m1932b(getContext(), 15.0f);
        dkVar.m10477a(b, b);
        setRowDivider(dkVar);
        C0435s c0435s = (C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class);
        m1250b(0, 0, 0, c0435s == null ? 0 : c0435s.getTheme().getPagePaddingBottom());
        setOnItemClickListener(new bd(this));
        this.f11357a = new bf(this);
        setAdapter(this.f11357a);
    }

    /* renamed from: a */
    public void m15312a(DkStoreFictionDetail dkStoreFictionDetail, DkCloudFictionChapter[] dkCloudFictionChapterArr) {
        this.f11358b = dkStoreFictionDetail;
        this.f11359c = dkCloudFictionChapterArr;
        this.f11357a.mo2529h();
        this.f11357a.mo1715g();
    }

    /* renamed from: a */
    public void m15313a(boolean z) {
        if (z) {
            dv.m1921a((View) this, new bg(this, this.f11357a.mo486a() - 1));
        } else {
            this.f11357a.m10356f(0);
        }
    }
}
