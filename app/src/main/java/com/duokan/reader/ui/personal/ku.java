package com.duokan.reader.ui.personal;

import com.duokan.core.app.IFeature;
import com.duokan.core.ui.C0342j;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.ui.bookshelf.be;
import com.duokan.reader.ui.bookshelf.hv;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.expandable.ViewMode;
import com.duokan.reader.ui.general.ja;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ku extends nm implements hv {
    /* renamed from: a */
    static final /* synthetic */ boolean f8833a = (!ku.class.desiredAssertionStatus());
    /* renamed from: c */
    private final lc f8834c;
    /* renamed from: d */
    private final la f8835d = new la();

    public ku(IFeature mFeature) {
        super(mFeature, true);
        getContext().addFeatureListener(this.f8835d);
        this.f8834c = new lc(getContext(), this.f8835d, this);
        setContentView(this.f8834c);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.f8834c.m12164g();
        }
    }

    protected void onDeactive() {
        super.onDeactive();
        this.f8834c.m11535p();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
    }

    protected boolean onBack() {
        if (this.f8834c != null && this.f8834c.m11529j()) {
            return true;
        }
        if (!this.f8834c.m11530k()) {
            return super.onBack();
        }
        this.f8834c.m11531l();
        return true;
    }

    /* renamed from: a */
    public boolean m12101a() {
        return this.f8834c.getAdapter().mo1714f() != ViewMode.Edit;
    }

    /* renamed from: a */
    private void m12097a(List<DkCloudStoreBook> list, Runnable runnable, Runnable runnable2) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList(list.size());
            int i = 0;
            for (DkCloudStoreBook bookUuid : list) {
                C0800c b = ai.m3980a().m3906b(bookUuid.getBookUuid());
                if (b != null) {
                    int D;
                    if (b.m4233i() == BookState.NORMAL) {
                        arrayList.add(b);
                        D = (int) (b.m4151D() + ((long) i));
                    } else {
                        D = i;
                    }
                    i = D;
                }
            }
            be.m9188a(DkApp.get().getTopActivity(), (long) i, new kv(this, runnable, arrayList, runnable2));
        } else if (!f8833a) {
            throw new AssertionError();
        } else if (runnable2 != null) {
            runnable2.run();
        }
    }

    /* renamed from: a */
    private void m12096a(Runnable runnable, List<DkCloudStoreBook> list) {
        C0342j a = ja.m10832a(getContext(), "", getString(C0258j.store__shared__purchased_book_delete), true, false);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (DkCloudStoreBook dkCloudStoreBook : list) {
            if (dkCloudStoreBook instanceof DkCloudPurchasedBook) {
                linkedList.add(dkCloudStoreBook.getBookUuid());
            } else if (dkCloudStoreBook instanceof DkCloudPurchasedFiction) {
                linkedList2.add(dkCloudStoreBook.getBookUuid());
            }
        }
        DkUserPurchasedBooksManager.m5029a().m5054a(new kx(this, linkedList2, a, list, runnable), (String[]) linkedList.toArray(new String[0]));
    }

    /* renamed from: a */
    public void mo1878a(int i, int i2) {
        this.f8834c.mo2231c(i, i2);
    }

    /* renamed from: b */
    public void mo1880b() {
        this.f8834c.mo2232q();
    }

    /* renamed from: c */
    public void mo1882c() {
        this.f8834c.m11532m();
    }

    /* renamed from: d */
    public void mo1883d() {
        this.f8834c.m11533n();
    }

    /* renamed from: a */
    public void mo1879a(Runnable runnable) {
        ap apVar = new ap(getContext());
        apVar.setPrompt(C0258j.bookshelf__remove_books_in_purchased_dlg__title);
        apVar.setCancelLabel(C0258j.general__shared__cancel);
        apVar.setOkLabelResid(C0258j.general__shared__remove);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new kz(this, runnable));
    }

    /* renamed from: g */
    public boolean mo1886g() {
        return this.f8834c.mo1939c();
    }

    /* renamed from: e */
    public int mo1884e() {
        return this.f8834c.getSelectedCount();
    }

    /* renamed from: f */
    public void mo1885f() {
        this.f8834c.mo1891a();
    }

    /* renamed from: h */
    public void mo1887h() {
        this.f8834c.mo1892b();
    }

    /* renamed from: b */
    public void mo1881b(int i, int i2) {
        this.f8834c.m11522b(i, i2);
    }

    /* renamed from: i */
    public String mo1888i() {
        return null;
    }

    /* renamed from: j */
    public String mo1889j() {
        return null;
    }

    /* renamed from: k */
    public String mo1890k() {
        return null;
    }
}
