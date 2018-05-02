package com.duokan.reader.ui.store;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.duokan.DkStoreBookTocInfo;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.bo;

/* renamed from: com.duokan.reader.ui.store.h */
public class C1495h extends DkWebListView {
    /* renamed from: a */
    private final bo f11443a;
    /* renamed from: b */
    private DkStoreBookTocInfo[] f11444b;

    public C1495h(Context context) {
        this(context, null);
    }

    public C1495h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11444b = null;
        setBackgroundResource(C0252d.store__shared__bg);
        C0435s c0435s = (C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class);
        m9955a(0, 0, 0, c0435s == null ? 0 : c0435s.getTheme().getPagePaddingBottom());
        View pageHeaderView = new PageHeaderView(getContext());
        pageHeaderView.setLeftTitle(getContext().getString(C0258j.store__book_toc_view__title));
        setTitleView(pageHeaderView);
        setPullDownRefreshEnabled(false);
        m9961b(C0256h.store__book_toc_title_view);
        this.f11443a = new C1496i(this);
        setAdapter(this.f11443a);
    }

    public void setBookName(String str) {
        ((TextView) getHatBodyView().findViewById(C0255g.store__book_toc_title_view__name)).setText(str);
    }

    public void setBookToc(DkStoreBookTocInfo[] dkStoreBookTocInfoArr) {
        this.f11444b = dkStoreBookTocInfoArr;
        this.f11443a.m8785a(false);
    }

    public DkWebListView getListView() {
        return this;
    }
}
