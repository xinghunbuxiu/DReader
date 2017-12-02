package com.duokan.reader.ui.store;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.duokan.c.d;
import com.duokan.c.j;
import com.duokan.core.app.x;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.cloud.DkCloudFictionChapter;
import com.duokan.reader.domain.store.DkStoreFictionDetail;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.dk;
import com.duokan.reader.ui.general.expandable.StateExpandableAdapter;
import com.duokan.reader.ui.s;

public class bc extends HatGridView {
    private StateExpandableAdapter a;
    private DkStoreFictionDetail b = null;
    private DkCloudFictionChapter[] c = new DkCloudFictionChapter[0];

    public bc(Context context) {
        super(context);
        setBackgroundColor(getResources().getColor(d.store__shared__bg));
        View pageHeaderView = new PageHeaderView(getContext());
        pageHeaderView.setLeftTitle(j.store__fiction_chapter_view__title1);
        setTitleView(pageHeaderView);
        Drawable dkVar = new dk(getResources().getColor(d.general__shared__bcbcbc));
        dkVar.a(0);
        int b = dv.b(getContext(), 15.0f);
        dkVar.a(b, b);
        setRowDivider(dkVar);
        s sVar = (s) x.a(getContext()).queryFeature(s.class);
        b(0, 0, 0, sVar == null ? 0 : sVar.getTheme().getPagePaddingBottom());
        setOnItemClickListener(new bd(this));
        this.a = new bf(this);
        setAdapter(this.a);
    }

    public void a(DkStoreFictionDetail dkStoreFictionDetail, DkCloudFictionChapter[] dkCloudFictionChapterArr) {
        this.b = dkStoreFictionDetail;
        this.c = dkCloudFictionChapterArr;
        this.a.h();
        this.a.g();
    }

    public void a(boolean z) {
        if (z) {
            dv.a((View) this, new bg(this, this.a.a() - 1));
        } else {
            this.a.f(0);
        }
    }
}
