package com.duokan.reader.ui.store;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.UmengManager;
import com.duokan.reader.common.webservices.duokan.C0646t;
import com.duokan.reader.domain.store.C1176a;
import java.util.LinkedList;

/* renamed from: com.duokan.reader.ui.store.j */
public class C1497j extends ActivatedController {
    /* renamed from: a */
    private final String f11446a;
    /* renamed from: b */
    private final LinkedList<C0646t> f11447b = new LinkedList();
    /* renamed from: c */
    private final C1499l f11448c;

    public C1497j(IFeature mFeature, String str) {
        super(mFeature);
        this.f11446a = str;
        this.f11448c = new C1499l(this, getContext());
        setContentView(this.f11448c);
        UmengManager.get().onEvent("V2_STORE_BOOK_DETAILPAGE_ACTION", "RevisionHistory");
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            m15397a(0);
        }
    }

    /* renamed from: a */
    private void m15397a(int i) {
        C1176a.m8695a().m8700a(this.f11446a, i, 10, new C1498k(this));
    }
}
