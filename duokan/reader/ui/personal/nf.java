package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.PageHeaderView;

public class nf extends jr {
    private final PageHeaderView a = new PageHeaderView(getContext());

    public nf(MyContextWrapper mContext, boolean z) {
        super(mContext);
        this.a.setLeftTitle(j.personal__personal_redeems_view__title);
        this.a.setHasBackButton(true);
        setTitleView(this.a);
    }

    public PageHeaderView getHeaderView() {
        return this.a;
    }

    public DkWebListView getRedeemView() {
        return this;
    }
}
