package com.duokan.reader.ui.p049a;

import android.widget.EditText;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.store.C1176a;
import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.PageHeaderView;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.duokan.reader.ui.a.n */
public class C1228n extends ActivatedController {
    /* renamed from: a */
    private final DkWebListView f5726a;
    /* renamed from: b */
    private final EditText f5727b;
    /* renamed from: c */
    private final List<DkStoreAbsBook> f5728c = new LinkedList();

    public C1228n(IFeature mFeature, C1221u c1221u) {
        super(mFeature);
        setContentView(C0256h.discovery__edit_feed_search_view);
        PageHeaderView pageHeaderView = (PageHeaderView) findViewById(C0255g.discovery__edit_feed_search_view__header);
        pageHeaderView.setHasBackButton(false);
        pageHeaderView.setCenterTitle(C0258j.discovery__edit_feed_search_view__header);
        pageHeaderView.m10144a(getString(C0258j.general__shared__cancel)).setOnClickListener(new C1229o(this, c1221u));
        this.f5726a = (DkWebListView) findViewById(C0255g.discovery__edit_feed_search_view__list);
        this.f5727b = (EditText) findViewById(C0255g.discovery__edit_feed_search_view__title);
        this.f5727b.addTextChangedListener(new C1230p(this));
        this.f5726a.setPullDownRefreshEnabled(false);
        this.f5726a.setAdapter(new C1231q(this));
        this.f5726a.setOnItemClickListener(new C1232r(this, c1221u));
        this.f5726a.setOnScrollListener(new C1233s(this));
        this.f5726a.m9954a();
        dv.m1915a(this.f5727b);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        dv.m1909a(getContext());
    }

    /* renamed from: a */
    private void m8776a(String str, int i, int i2) {
        C1176a.m8695a().m8701a(str, i, i2, new C1234t(this, str));
    }
}
