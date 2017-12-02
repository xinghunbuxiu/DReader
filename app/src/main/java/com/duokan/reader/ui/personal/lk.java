package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.core.app.y;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.iv;
import com.duokan.reader.domain.bookshelf.iw;
import com.duokan.reader.domain.cloud.a;
import com.duokan.reader.ui.bookshelf.ho;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.hd;

import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class lk extends hd implements iv, iw, ho {
    private lo a;
    private final String[] b;
    private kn c;

    public lk(y yVar, a aVar, String[] strArr) {
        super(yVar);
        this.b = strArr;
        for (String a : this.b) {
            aVar = aVar.a(a);
        }
        this.c = (kn) yVar.queryFeature(kn.class);
        this.a = new lo(getContext(), aVar, this, new ke(getContext()));
        setContentView(this.a);
        this.a.getHeaderView().setOnBackListener(new ll(this));
    }

    private void b(List list) {
        if (this.a.getAdapter() instanceof mq) {
            ((mq) this.a.getAdapter()).a(list);
        }
    }

    public void a(List list) {
        Collator instance = Collator.getInstance(Locale.CHINESE);
        a a = a.a(list);
        a.a(instance);
        a.b(instance);
        for (String str : this.b) {
            if (a == null) {
                break;
            }
            a = a.a(str);
        }
        this.a.setData(a);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        ai.a().a((iw) this);
        ai.a().a((iv) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        ai.a().b((iw) this);
        ai.a().b((iv) this);
    }

    protected void onDeactive() {
        super.onDeactive();
        this.a.p();
    }

    protected boolean onBack() {
        if (this.a != null && this.a.j()) {
            return true;
        }
        if (!this.a.k()) {
            return super.onBack();
        }
        this.a.l();
        return true;
    }

    public void onItemsChanged() {
    }

    public void onItemChanged(an anVar, int i) {
        if ((anVar instanceof c) && (i & 72) != 0) {
            this.a.d();
        }
    }

    public void a(int i, int i2) {
        this.a.c(i, i2);
    }

    public void b() {
        this.a.q();
    }

    public void c() {
        this.a.m();
    }

    public void d() {
        this.a.n();
    }

    public void a(Runnable runnable) {
        ap apVar = new ap(getContext());
        apVar.setPrompt(j.bookshelf__remove_books_in_purchased_dlg__title);
        apVar.setCancelLabel(j.general__shared__cancel);
        apVar.setOkLabel(j.general__shared__remove);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new lm(this, runnable));
    }

    public boolean g() {
        return this.a.c();
    }

    public int e() {
        return this.a.getSelectedCount();
    }

    public void f() {
        this.a.a();
    }

    public void h() {
        this.a.b();
    }

    public void b(int i, int i2) {
        this.a.b(i, i2);
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
