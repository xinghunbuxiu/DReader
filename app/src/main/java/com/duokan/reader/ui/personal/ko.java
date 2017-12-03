package com.duokan.reader.ui.personal;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.core.sys.ah;
import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import com.duokan.reader.ui.bookshelf.gw;
import com.duokan.reader.ui.bookshelf.ho;
import com.duokan.reader.ui.general.DkWebListView.ListState;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class ko extends nm {
    private final kn a;
    private final mq k;
    private final ke l;
    private final fk m;
    private final lj n;
    private final ho o;
    private kc p;
    private kc q;
    private kc r;

    public ko(Context context, kn knVar, ho hoVar) {
        int i;
        int i2 = 8;
        super(context, hoVar);
        if (i.f().c() == null || i.f().c().i()) {
            this.b.setLeftTitle(getResources().getString(j.surfing__shared__purchased));
        } else {
            this.b.setVisibility(8);
        }
        this.o = hoVar;
        this.k = new kp(this, context, hoVar);
        this.i = new kt(this);
        this.a = knVar;
        setBackgroundResource(d.general__shared__ffffff);
        View inflate = LayoutInflater.from(getContext()).inflate(h.bookshelf__purchased_bottom_view, this.d);
        View findViewById = inflate.findViewById(g.bookshelf__purchased_view__gift);
        findViewById.setOnClickListener(new ku(this));
        inflate.findViewById(g.bookshelf__purchased_view__subscribe).setOnClickListener(new kv(this));
        if (i.f().a().equals(AccountType.ANONYMOUS)) {
            inflate.setVisibility(8);
        } else {
            inflate.setVisibility(0);
        }
        if (i.f().a().equals(AccountType.XIAOMI_GUEST)) {
            i = 8;
        } else {
            i = 0;
        }
        findViewById.setVisibility(i);
        View findViewById2 = inflate.findViewById(g.bookshelf__purchased_view__divider);
        if (!i.f().a().equals(AccountType.XIAOMI_GUEST)) {
            i2 = 0;
        }
        findViewById2.setVisibility(i2);
        this.l = new ke(getContext());
        this.m = new kw(this);
        t();
        setAdapter(a(this.m.a()));
        setSearchAdapter(this.k);
        this.n = u();
        this.e.setHatBodyView(this.n);
    }

    public void a(List list) {
        if (getAdapter() == this.k) {
            this.k.a(list);
        }
        s();
    }

    public boolean c() {
        gw d = d();
        if (getAdapter() == d && d.p()) {
            return d.g() == d.c() - d.v();
        } else {
            return super.c();
        }
    }

    private kc r() {
        return new kx(this, getContext());
    }

    public void a(kc kcVar, boolean z) {
        boolean z2 = true;
        if (!kcVar.f && !kcVar.g) {
            boolean z3;
            kcVar.g = true;
            kcVar.f = true;
            DkUserPurchasedBooksManager a = DkUserPurchasedBooksManager.a();
            if (this.a.a() != PurchasedSortType.GROUP) {
                z3 = true;
            } else {
                z3 = false;
            }
            a.a(z3, new lc(this, z, kcVar));
            DkUserPurchasedFictionsManager a2 = DkUserPurchasedFictionsManager.a();
            if (this.a.a() == PurchasedSortType.GROUP) {
                z2 = false;
            }
            a2.a(z2, new le(this, z, kcVar));
        }
    }

    private kc a(int i) {
        if (i == 0) {
            return this.p;
        }
        if (i == 1) {
            return this.q;
        }
        return this.r;
    }

    public kc d() {
        return (kc) getNormalAdapter();
    }

    private void s() {
        a(d());
    }

    private void a(kc kcVar) {
        if (kcVar != null && !kcVar.f && !kcVar.g) {
            ah.b(new lg(this, new LinkedList(), new LinkedList(), new LinkedList(), kcVar));
        }
    }

    private void a(LinkedList linkedList, LinkedList linkedList2, LinkedList linkedList3) {
        int i = 0;
        DkCloudPurchasedFiction[] dkCloudPurchasedFictionArr = (DkCloudPurchasedFiction[]) DkUserPurchasedFictionsManager.a().b().toArray(new DkCloudPurchasedFiction[0]);
        for (DkCloudStoreBook dkCloudStoreBook : (DkCloudPurchasedBook[]) DkUserPurchasedBooksManager.a().b().toArray(new DkCloudPurchasedBook[0])) {
            if (dkCloudStoreBook.getBookSourceType() == DkStoreBookSourceType.GIFT && ai.a().b(dkCloudStoreBook.getBookUuid()) == null) {
                linkedList3.add(dkCloudStoreBook);
            } else {
                linkedList.add(dkCloudStoreBook);
            }
        }
        c[] i2 = ai.a().i();
        int length = i2.length;
        while (i < length) {
            c cVar = i2[i];
            if (!cVar.k() && cVar.i() != BookState.CLOUD_ONLY && cVar.p() == BookLimitType.NONE && cVar.ai() && !cVar.V() && cVar.au()) {
                ListIterator listIterator = linkedList.listIterator();
                while (listIterator.hasNext()) {
                    DkCloudStoreBook dkCloudStoreBook2 = (DkCloudStoreBook) listIterator.next();
                    if (TextUtils.equals(cVar.H(), dkCloudStoreBook2.getBookUuid())) {
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

    private void a(int i, boolean z) {
        PurchasedSortType purchasedSortType;
        gw a = a(i);
        if (i == 0) {
            purchasedSortType = PurchasedSortType.TIME;
        } else if (i == 1) {
            purchasedSortType = PurchasedSortType.NAME;
        } else if (i == 2) {
            purchasedSortType = PurchasedSortType.GROUP;
        } else {
            purchasedSortType = PurchasedSortType.TIME;
        }
        this.a.a(purchasedSortType);
        setAdapter(a);
        if (z) {
            b(true);
        } else if (a.n()) {
            a.a(false);
        } else if (a.l() != ListState.FIRST_LOADING && a.l() != ListState.LOADING_MORE && a.l() != ListState.LOADING_UPDATES) {
            b(true);
        }
    }

    private void t() {
        this.p = r();
        this.q = r();
        this.r = r();
        if (this.p != null) {
            this.p.a(new mz(getContext(), this.p, this.l, this.o, this.m));
        }
        if (this.q != null) {
            this.q.a(new fd(getContext(), this.q, this.l, this.o, this.m));
        }
        if (this.r != null) {
            this.r.a(new by(getContext(), this.r, this.l, this.o, this.m));
        }
    }

    private void b(kc kcVar) {
        if (this.p != kcVar) {
            this.p = r();
            this.p.a(new mz(getContext(), this.p, this.l, this.o, this.m));
        }
        if (this.q != kcVar) {
            this.q = r();
            this.q.a(new fd(getContext(), this.q, this.l, this.o, this.m));
        }
        if (this.r != kcVar) {
            this.r = r();
            this.r.a(new by(getContext(), this.r, this.l, this.o, this.m));
        }
    }

    private boolean a(DkCloudStoreBook dkCloudStoreBook, String str) {
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

    private lj u() {
        ViewGroup ljVar = new lj(this, getContext());
        View inflate = LayoutInflater.from(getContext()).inflate(h.bookshelf__book_group_title_view_v4, ljVar, true);
        TextView textView = (TextView) inflate.findViewById(g.bookshelf__purchased_sort_group_view__time);
        TextView textView2 = (TextView) inflate.findViewById(g.bookshelf__purchased_sort_group_view__name);
        TextView textView3 = (TextView) inflate.findViewById(g.bookshelf__purchased_sort_group_view__group);
        ((LinearLayout) inflate.findViewById(g.bookshelf__purchased_sort_group_view)).getChildAt(this.m.a()).setSelected(true);
        textView.setOnClickListener(new kq(this, textView, textView2, textView3));
        textView2.setOnClickListener(new kr(this, textView, textView2, textView3));
        textView3.setOnClickListener(new ks(this, textView, textView2, textView3));
        return ljVar;
    }

    public void e() {
        if (this.e.getAdapter() == getNormalAdapter()) {
            this.n.setVisibility(8);
        }
        super.e();
    }

    public void f() {
        if (getAdapter() == this.k) {
            this.n.setVisibility(0);
        }
        super.f();
    }

    public void a() {
        super.a();
        this.n.setEnabled(false);
        if (!k()) {
            this.e.setPullDownRefreshEnabled(false);
        }
    }

    public void b() {
        super.b();
        this.n.setEnabled(true);
        if (!k()) {
            this.e.setPullDownRefreshEnabled(true);
        }
    }

    public void g() {
        a(this.m.a(), true);
    }

    public List h() {
        return d().s();
    }
}
