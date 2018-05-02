package com.duokan.reader.ui.personal;

import android.os.Handler;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.is;
import com.duokan.reader.domain.bookshelf.iv;
import com.duokan.reader.domain.bookshelf.iw;
import com.duokan.reader.domain.bookshelf.iy;
import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.domain.micloud.i;
import com.duokan.reader.ui.bookshelf.ay;
import com.duokan.reader.ui.bookshelf.ho;
import com.duokan.reader.ui.general.expandable.ViewMode;

import java.util.LinkedList;
import java.util.List;

public class ds extends ActivatedController implements iv, iw, ho, eo {
    static final /* synthetic */ boolean a = (!ds.class.desiredAssertionStatus());
    private final eq b = new eq(getContext(), this);
    private Handler c = new Handler();
    private final IAsyncWorkProgressListener d = new dt(this);
    private IAsyncWorkProgressListener e = new dy(this);

    public ds(IFeature featrue) {
        super(featrue);
        ai.a().a((iw) this);
        ai.a().a((iv) this);
        iz.a().a(this.d);
        iz.a().c(this.e);
        setContentView(this.b);
    }

    protected boolean onBack() {
        if (this.b != null && this.b.j()) {
            return true;
        }
        if (!this.b.k()) {
            return super.onBack();
        }
        this.b.l();
        return true;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.b.d();
        }
    }

    protected void onDeactive() {
        super.onDeactive();
        this.b.p();
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        ai.a().b((iw) this);
        ai.a().b((iv) this);
        iz.a().b(this.d);
        iz.a().d(this.e);
    }

    public void onItemsChanged() {
        runLastOnActive("reload_data_from_cache", new ef(this));
    }

    public void onItemChanged(an anVar, int i) {
        if ((i & 72) != 0) {
            runFirstOnActive("refresh_ui", new eg(this));
        }
    }

    public void a(CustomCloudItem customCloudItem) {
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).openBook(customCloudItem.b());
    }

    public void a(CustomCloudItem customCloudItem, is isVar) {
        if (customCloudItem.c()) {
            iy iyVar = (iy) customCloudItem.a();
            ay.a(getContext(), iyVar.d(), new eh(this, customCloudItem, iyVar, isVar));
        } else if (a) {
            isVar.a("");
        } else {
            throw new AssertionError();
        }
    }

    public void a(List list, ep epVar) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (CustomCloudItem customCloudItem : list) {
            if (customCloudItem.c()) {
                linkedList.add((iy) customCloudItem.a());
            } else {
                linkedList2.add((i) customCloudItem.a());
            }
        }
        ep eiVar = new ei(this, epVar, linkedList2);
        if (linkedList2.size() > 0) {
            a.a(new ej(this, linkedList2, linkedList, eiVar), new Void[0]);
        } else {
            b(linkedList, eiVar);
        }
    }

    private void b(List list, ep epVar) {
        if (list.size() == 0) {
            epVar.a(null, null);
        } else {
            iz.a().a(list, true, new ek(this, epVar));
        }
    }

    private void l() {
        this.c.post(new dx(this));
    }

    public void a(int i, int i2) {
        this.b.c(i, i2);
    }

    public void b() {
        this.b.q();
    }

    public void c() {
        this.b.m();
    }

    public void d() {
        this.b.n();
    }

    public void a(Runnable runnable) {
        this.b.a(runnable);
    }

    public boolean g() {
        return this.b.c();
    }

    public int e() {
        return this.b.getSelectedCount();
    }

    public void f() {
        this.b.a();
    }

    public void h() {
        this.b.b();
    }

    public void b(int i, int i2) {
        this.b.b(i, i2);
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

    public boolean a() {
        return this.b.getViewMode() != ViewMode.Edit;
    }
}
