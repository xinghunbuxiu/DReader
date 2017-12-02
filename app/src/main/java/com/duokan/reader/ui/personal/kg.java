package com.duokan.reader.ui.personal;

import com.duokan.core.app.y;
import com.duokan.core.ui.j;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkCloudPurchasedBook;
import com.duokan.reader.domain.cloud.DkCloudPurchasedFiction;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.ui.bookshelf.ay;
import com.duokan.reader.ui.bookshelf.ho;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.expandable.ViewMode;
import com.duokan.reader.ui.general.jq;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class kg extends my implements ho {
    static final /* synthetic */ boolean a = (!kg.class.desiredAssertionStatus());
    private final ko c;
    private final km d = new km();

    public kg(y yVar) {
        super(yVar, true);
        getContext().a(this.d);
        this.c = new ko(getContext(), this.d, this);
        setContentView(this.c);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.c.g();
        }
    }

    protected void onDeactive() {
        super.onDeactive();
        this.c.p();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
    }

    protected boolean onBack() {
        if (this.c != null && this.c.j()) {
            return true;
        }
        if (!this.c.k()) {
            return super.onBack();
        }
        this.c.l();
        return true;
    }

    public boolean a() {
        return this.c.getAdapter().f() != ViewMode.Edit;
    }

    private void a(List list, Runnable runnable, Runnable runnable2) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList(list.size());
            int i = 0;
            for (DkCloudStoreBook bookUuid : list) {
                c b = ai.a().b(bookUuid.getBookUuid());
                if (b != null) {
                    int C;
                    if (b.i() == BookState.NORMAL) {
                        arrayList.add(b);
                        C = (int) (b.C() + ((long) i));
                    } else {
                        C = i;
                    }
                    i = C;
                }
            }
            ay.a(DkApp.get().getTopActivity(), (long) i, new kh(this, runnable, arrayList, runnable2));
        } else if (!a) {
            throw new AssertionError();
        } else if (runnable2 != null) {
            runnable2.run();
        }
    }

    private void a(Runnable runnable, List list) {
        j a = jq.a(getContext(), "", getString(com.duokan.c.j.store__shared__purchased_book_delete), true, false);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (DkCloudStoreBook dkCloudStoreBook : list) {
            if (dkCloudStoreBook instanceof DkCloudPurchasedBook) {
                linkedList.add(dkCloudStoreBook.getBookUuid());
            } else if (dkCloudStoreBook instanceof DkCloudPurchasedFiction) {
                linkedList2.add(dkCloudStoreBook.getBookUuid());
            }
        }
        DkUserPurchasedBooksManager.a().a(new kj(this, linkedList2, a, list, runnable), (String[]) linkedList.toArray(new String[0]));
    }

    public void a(int i, int i2) {
        this.c.c(i, i2);
    }

    public void b() {
        this.c.q();
    }

    public void c() {
        this.c.m();
    }

    public void d() {
        this.c.n();
    }

    public void a(Runnable runnable) {
        ap apVar = new ap(getContext());
        apVar.setPrompt(com.duokan.c.j.bookshelf__remove_books_in_purchased_dlg__title);
        apVar.setCancelLabel(com.duokan.c.j.general__shared__cancel);
        apVar.setOkLabel(com.duokan.c.j.general__shared__remove);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new kl(this, runnable));
    }

    public boolean g() {
        return this.c.c();
    }

    public int e() {
        return this.c.getSelectedCount();
    }

    public void f() {
        this.c.a();
    }

    public void h() {
        this.c.b();
    }

    public void b(int i, int i2) {
        this.c.b(i, i2);
    }

    public String i() {
        return null;
    }

    public String j() {
        return null;
    }

    public String k() {
        return null;
    }
}
