package com.duokan.reader.ui.personal;

import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.PageHeaderView;

public class nt extends kf {
    /* renamed from: a */
    private final PageHeaderView f9018a = new PageHeaderView(getContext());

    public nt(AppContext appContext, boolean z) {
        super(appContext);
        this.f9018a.setLeftTitle(C0258j.personal__personal_redeems_view__title);
        this.f9018a.setHasBackButton(true);
        setTitleView(this.f9018a);
    }

    public PageHeaderView getHeaderView() {
        return this.f9018a;
    }

    public DkWebListView getRedeemView() {
        return this;
    }
}
