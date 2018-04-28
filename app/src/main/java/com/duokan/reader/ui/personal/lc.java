package com.duokan.reader.ui.personal;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.core.sys.ah;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.ui.bookshelf.hd;
import com.duokan.reader.ui.bookshelf.hv;
import com.duokan.reader.ui.general.DkWebListView.ListState;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class lc extends oa {
    /* renamed from: a */
    private final lb f8857a;
    /* renamed from: l */
    private final ne f8858l;
    /* renamed from: m */
    private final ks f8859m;
    /* renamed from: n */
    private final fy f8860n;
    /* renamed from: o */
    private final lx f8861o;
    /* renamed from: p */
    private final hv f8862p;
    /* renamed from: q */
    private kq f8863q;
    /* renamed from: r */
    private kq f8864r;
    /* renamed from: s */
    private kq f8865s;

    public lc(Context context, lb lbVar, hv hvVar) {
        int i;
        int i2 = 8;
        super(context, hvVar);
        if (C0709k.m3476a().m3508d() == null || C0709k.m3476a().m3508d().mo839i()) {
            this.b.setLeftTitle(getResources().getString(C0258j.surfing__shared__purchased));
        } else {
            this.b.setVisibility(8);
        }
        this.f8862p = hvVar;
        this.f8858l = new ld(this, context, hvVar);
        this.j = new lh(this);
        this.f8857a = lbVar;
        setBackgroundResource(C0252d.general__shared__ffffff);
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__purchased_bottom_view, this.e);
        View findViewById = inflate.findViewById(C0255g.bookshelf__purchased_view__gift);
        findViewById.setOnClickListener(new li(this));
        inflate.findViewById(C0255g.bookshelf__purchased_view__subscribe).setOnClickListener(new lj(this));
        if (C0709k.m3476a().m3501b().equals(AccountType.ANONYMOUS)) {
            inflate.setVisibility(8);
        } else {
            inflate.setVisibility(0);
        }
        if (C0709k.m3476a().m3501b().equals(AccountType.XIAOMI_GUEST)) {
            i = 8;
        } else {
            i = 0;
        }
        findViewById.setVisibility(i);
        View findViewById2 = inflate.findViewById(C0255g.bookshelf__purchased_view__divider);
        if (!C0709k.m3476a().m3501b().equals(AccountType.XIAOMI_GUEST)) {
            i2 = 0;
        }
        findViewById2.setVisibility(i2);
        this.f8859m = new ks(getContext());
        this.f8860n = new lk(this);
        m12154t();
        setAdapter(m12137a(this.f8860n.mo1942a()));
        setSearchAdapter(this.f8858l);
        this.f8861o = m12155u();
        this.f.setHatBodyView(this.f8861o);
    }

    /* renamed from: a */
    public void m12158a(List<DkCloudStoreBook> list) {
        if (getAdapter() == this.f8858l) {
            this.f8858l.m12169a((List) list);
        }
        m12153s();
    }

    /* renamed from: c */
    public boolean mo1939c() {
        hd d = mo1903d();
        if (getAdapter() == d && d.mo1954p()) {
            return d.mo1715g() == d.mo506c() - d.mo1959v();
        } else {
            return super.mo1939c();
        }
    }

    /* renamed from: r */
    private kq m12152r() {
        return new ll(this, getContext());
    }

    /* renamed from: a */
    public void m12157a(kq kqVar, boolean z) {
        boolean z2 = true;
        if (!kqVar.f8826f && !kqVar.f8827g) {
            boolean z3;
            kqVar.f8827g = true;
            kqVar.f8826f = true;
            DkUserPurchasedBooksManager a = DkUserPurchasedBooksManager.m5029a();
            if (this.f8857a.mo1932a() != PurchasedSortType.GROUP) {
                z3 = true;
            } else {
                z3 = false;
            }
            a.m5059a(z3, new lq(this, z, kqVar));
            DkUserPurchasedFictionsManager a2 = DkUserPurchasedFictionsManager.m5072a();
            if (this.f8857a.mo1932a() == PurchasedSortType.GROUP) {
                z2 = false;
            }
            a2.m5099a(z2, new ls(this, z, kqVar));
        }
    }

    /* renamed from: a */
    private kq m12137a(int i) {
        if (i == 0) {
            return this.f8863q;
        }
        if (i == 1) {
            return this.f8864r;
        }
        return this.f8865s;
    }

    /* renamed from: d */
    public kq mo1903d() {
        return (kq) getNormalAdapter();
    }

    /* renamed from: s */
    private void m12153s() {
        m12140a(mo1903d());
    }

    /* renamed from: a */
    private void m12140a(kq kqVar) {
        if (kqVar != null && !kqVar.f8826f && !kqVar.f8827g) {
            ah.m871b(new lu(this, new LinkedList(), new LinkedList(), new LinkedList(), kqVar));
        }
    }

    /* renamed from: a */
    private void m12144a(LinkedList<DkCloudStoreBook> linkedList, LinkedList<DkCloudStoreBook> linkedList2, LinkedList<DkCloudStoreBook> linkedList3) {
        int i = 0;
        DkCloudPurchasedFiction[] dkCloudPurchasedFictionArr = (DkCloudPurchasedFiction[]) DkUserPurchasedFictionsManager.m5072a().m5102b().toArray(new DkCloudPurchasedFiction[0]);
        for (DkCloudStoreBook dkCloudStoreBook : (DkCloudPurchasedBook[]) DkUserPurchasedBooksManager.m5029a().m5063b().toArray(new DkCloudPurchasedBook[0])) {
            if (dkCloudStoreBook.getBookSourceType() == DkStoreBookSourceType.GIFT && ai.m3980a().m3906b(dkCloudStoreBook.getBookUuid()) == null) {
                linkedList3.add(dkCloudStoreBook);
            } else {
                linkedList.add(dkCloudStoreBook);
            }
        }
        C0800c[] i2 = ai.m3980a().m3934i();
        int length = i2.length;
        while (i < length) {
            C0800c c0800c = i2[i];
            if (!c0800c.mo1038k() && c0800c.m4233i() != BookState.CLOUD_ONLY && c0800c.m4243p() == BookLimitType.NONE && c0800c.ak() && !c0800c.m4171X() && c0800c.aw()) {
                ListIterator listIterator = linkedList.listIterator();
                while (listIterator.hasNext()) {
                    DkCloudStoreBook dkCloudStoreBook2 = (DkCloudStoreBook) listIterator.next();
                    if (TextUtils.equals(c0800c.m4156I(), dkCloudStoreBook2.getBookUuid())) {
                        listIterator.remove();
                        linkedList2.add(dkCloudStoreBook2);
                        break;
                    }
                }
            }
            i++;
        }
        linkedList.addAll(Arrays.asList(dkCloudPurchasedFictionArr));
    }

    /* renamed from: a */
    private void m12139a(int i, boolean z) {
        PurchasedSortType purchasedSortType;
        hd a = m12137a(i);
        if (i == 0) {
            purchasedSortType = PurchasedSortType.TIME;
        } else if (i == 1) {
            purchasedSortType = PurchasedSortType.NAME;
        } else if (i == 2) {
            purchasedSortType = PurchasedSortType.GROUP;
        } else {
            purchasedSortType = PurchasedSortType.TIME;
        }
        this.f8857a.mo1934a(purchasedSortType);
        setAdapter(a);
        if (z) {
            m11523b(true);
        } else if (a.m12079n()) {
            a.m8785a(false);
        } else if (a.m8789l() != ListState.FIRST_LOADING && a.m8789l() != ListState.LOADING_MORE && a.m8789l() != ListState.LOADING_UPDATES) {
            m11523b(true);
        }
    }

    /* renamed from: t */
    private void m12154t() {
        this.f8863q = m12152r();
        this.f8864r = m12152r();
        this.f8865s = m12152r();
        if (this.f8863q != null) {
            this.f8863q.m12064a(new nn(getContext(), this.f8863q, this.f8859m, this.f8862p, this.f8860n));
        }
        if (this.f8864r != null) {
            this.f8864r.m12064a(new fr(getContext(), this.f8864r, this.f8859m, this.f8862p, this.f8860n));
        }
        if (this.f8865s != null) {
            this.f8865s.m12064a(new br(getContext(), this.f8865s, this.f8859m, this.f8862p, this.f8860n));
        }
    }

    /* renamed from: b */
    private void m12148b(kq kqVar) {
        if (this.f8863q != kqVar) {
            this.f8863q = m12152r();
            this.f8863q.m12064a(new nn(getContext(), this.f8863q, this.f8859m, this.f8862p, this.f8860n));
        }
        if (this.f8864r != kqVar) {
            this.f8864r = m12152r();
            this.f8864r.m12064a(new fr(getContext(), this.f8864r, this.f8859m, this.f8862p, this.f8860n));
        }
        if (this.f8865s != kqVar) {
            this.f8865s = m12152r();
            this.f8865s.m12064a(new br(getContext(), this.f8865s, this.f8859m, this.f8862p, this.f8860n));
        }
    }

    /* renamed from: a */
    private boolean m12145a(DkCloudStoreBook dkCloudStoreBook, String str) {
        if (dkCloudStoreBook.getTitle().toLowerCase().contains(str.toLowerCase())) {
            return true;
        }
        Object authorLine = dkCloudStoreBook.getAuthorLine();
        if (!TextUtils.isEmpty(authorLine) && authorLine.toLowerCase().contains(str.toLowerCase())) {
            return true;
        }
        authorLine = dkCloudStoreBook.getEditorLine();
        if (TextUtils.isEmpty(authorLine) || !authorLine.toLowerCase().contains(str.toLowerCase())) {
            return false;
        }
        return true;
    }

    /* renamed from: u */
    private lx m12155u() {
        ViewGroup lxVar = new lx(this, getContext());
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__book_group_title_view_v4, lxVar, true);
        TextView textView = (TextView) inflate.findViewById(C0255g.bookshelf__purchased_sort_group_view__time);
        TextView textView2 = (TextView) inflate.findViewById(C0255g.bookshelf__purchased_sort_group_view__name);
        TextView textView3 = (TextView) inflate.findViewById(C0255g.bookshelf__purchased_sort_group_view__group);
        ((LinearLayout) inflate.findViewById(C0255g.bookshelf__purchased_sort_group_view)).getChildAt(this.f8860n.mo1942a()).setSelected(true);
        textView.setOnClickListener(new le(this, textView, textView2, textView3));
        textView2.setOnClickListener(new lf(this, textView, textView2, textView3));
        textView3.setOnClickListener(new lg(this, textView, textView2, textView3));
        return lxVar;
    }

    /* renamed from: e */
    public void mo1940e() {
        if (this.f.getAdapter() == getNormalAdapter()) {
            this.f8861o.setVisibility(8);
        }
        super.mo1940e();
    }

    /* renamed from: f */
    public void mo1941f() {
        if (getAdapter() == this.f8858l) {
            this.f8861o.setVisibility(0);
        }
        super.mo1941f();
    }

    /* renamed from: a */
    public void mo1891a() {
        super.mo1891a();
        this.f8861o.setEnabled(false);
        if (!m11530k()) {
            this.f.setPullDownRefreshEnabled(false);
        }
    }

    /* renamed from: b */
    public void mo1892b() {
        super.mo1892b();
        this.f8861o.setEnabled(true);
        if (!m11530k()) {
            this.f.setPullDownRefreshEnabled(true);
        }
    }

    /* renamed from: g */
    public void m12164g() {
        m12139a(this.f8860n.mo1942a(), true);
    }

    /* renamed from: h */
    public List<DkCloudStoreBook> m12165h() {
        return mo1903d().mo1956s();
    }
}
