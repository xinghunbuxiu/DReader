package com.duokan.reader.ui.store;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.duokan.c.d;
import com.duokan.c.g;
import com.duokan.c.j;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.common.webservices.duokan.DkStoreBookTocInfo;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.ITheme;

public class h extends DkWebListView {
    private final bo a;
    private DkStoreBookTocInfo[] b;

    public h(Context context) {
        this(context, null);
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        setBackgroundResource(d.store__shared__bg);
        ITheme sVar = (ITheme) MyContextWrapper.getFeature(getContext()).queryFeature(ITheme.class);
        a(0, 0, 0, sVar == null ? 0 : sVar.getTheme().getPagePaddingBottom());
        View pageHeaderView = new PageHeaderView(getContext());
        pageHeaderView.setLeftTitle(getContext().getString(j.store__book_toc_view__title));
        setTitleView(pageHeaderView);
        setPullDownRefreshEnabled(false);
        b(com.duokan.c.h.store__book_toc_title_view);
        this.a = new i(this);
        setAdapter(this.a);
    }

    public void setBookName(String str) {
        ((TextView) getHatBodyView().findViewById(g.store__book_toc_title_view__name)).setText(str);
    }

    public void setBookToc(DkStoreBookTocInfo[] dkStoreBookTocInfoArr) {
        this.b = dkStoreBookTocInfoArr;
        this.a.a(false);
    }

    public DkWebListView getListView() {
        return this;
    }
}
