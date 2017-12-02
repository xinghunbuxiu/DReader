package com.duokan.reader.ui.a;

import android.widget.EditText;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.store.a;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.PageHeaderView;

import java.util.LinkedList;
import java.util.List;

public class n extends e {
    private final DkWebListView a;
    private final EditText b;
    private final List c = new LinkedList();

    public n(y yVar, u uVar) {
        super(yVar);
        setContentView(h.discovery__edit_feed_search_view);
        PageHeaderView pageHeaderView = (PageHeaderView) findViewById(g.discovery__edit_feed_search_view__header);
        pageHeaderView.setHasBackButton(false);
        pageHeaderView.setCenterTitle(j.discovery__edit_feed_search_view__header);
        pageHeaderView.a(getString(j.general__shared__cancel)).setOnClickListener(new o(this, uVar));
        this.a = (DkWebListView) findViewById(g.discovery__edit_feed_search_view__list);
        this.b = (EditText) findViewById(g.discovery__edit_feed_search_view__title);
        this.b.addTextChangedListener(new p(this));
        this.a.setPullDownRefreshEnabled(false);
        this.a.setAdapter(new q(this));
        this.a.setOnItemClickListener(new r(this, uVar));
        this.a.setOnScrollListener(new s(this));
        this.a.a();
        dv.a(this.b);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        dv.a(getContext());
    }

    private void a(String str, int i, int i2) {
        a.a().a(str, i, i2, new t(this, str));
    }
}
