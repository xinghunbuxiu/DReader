package com.duokan.reader.ui.personal;

import android.os.Handler;
import com.duokan.common.C0259a;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.im;
import com.duokan.reader.domain.bookshelf.ip;
import com.duokan.reader.domain.bookshelf.iq;
import com.duokan.reader.domain.bookshelf.is;
import com.duokan.reader.domain.bookshelf.it;
import com.duokan.reader.domain.micloud.C1068i;
import com.duokan.reader.domain.micloud.bl;
import com.duokan.reader.ui.bookshelf.be;
import com.duokan.reader.ui.bookshelf.hv;
import com.duokan.reader.ui.general.expandable.ViewMode;
import java.util.LinkedList;
import java.util.List;

public class dm extends ActivatedController implements ip, iq, hv, ei {
    /* renamed from: a */
    static final /* synthetic */ boolean f8456a = (!dm.class.desiredAssertionStatus());
    /* renamed from: b */
    private final ek f8457b = new ek(getContext(), this);
    /* renamed from: c */
    private Handler f8458c = new Handler();
    /* renamed from: d */
    private final IAsyncWorkProgressListener<bl> f8459d = new dn(this);
    /* renamed from: e */
    private IAsyncWorkProgressListener<C1068i> f8460e = new dr(this);

    public dm(IFeature mFeature) {
        super(mFeature);
        ai.m3980a().m3890a((iq) this);
        ai.m3980a().m3889a((ip) this);
        it.m4692a().m4714a(this.f8459d);
        it.m4692a().m4731c(this.f8460e);
        setContentView(this.f8457b);
    }

    protected boolean onBack() {
        if (this.f8457b != null && this.f8457b.m11529j()) {
            return true;
        }
        if (!this.f8457b.m11530k()) {
            return super.onBack();
        }
        this.f8457b.m11531l();
        return true;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.f8457b.mo1903d();
        }
    }

    protected void onDeactive() {
        super.onDeactive();
        this.f8457b.m11535p();
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        ai.m3980a().m3913b((iq) this);
        ai.m3980a().m3912b((ip) this);
        it.m4692a().m4727b(this.f8459d);
        it.m4692a().m4733d(this.f8460e);
    }

    public void onItemsChanged() {
        runLastOnActive("reload_data_from_cache", new dy(this));
    }

    public void onItemChanged(an anVar, int i) {
        if ((i & 72) != 0) {
            runFirstOnActive("refresh_ui", new dz(this));
        }
    }

    /* renamed from: a */
    public void mo1898a(CustomCloudItem customCloudItem) {
        ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).openBook(customCloudItem.m11340b());
    }

    /* renamed from: a */
    public void mo1899a(CustomCloudItem customCloudItem, im imVar) {
        if (customCloudItem.m11341c()) {
            is isVar = (is) customCloudItem.m11337a();
            be.m9188a(getContext(), isVar.m4684d(), new ea(this, customCloudItem, isVar, imVar));
        } else if (f8456a) {
            imVar.mo1022a("");
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo1900a(List<CustomCloudItem> list, ej ejVar) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (CustomCloudItem customCloudItem : list) {
            if (customCloudItem.m11341c()) {
                linkedList.add((is) customCloudItem.m11337a());
            } else {
                linkedList2.add((C1068i) customCloudItem.m11337a());
            }
        }
        ej ebVar = new eb(this, ejVar, linkedList2);
        if (linkedList2.size() > 0) {
            C0259a.m568a(new ec(this, linkedList2, linkedList, ebVar), new Void[0]);
        } else {
            m11665b(linkedList, ebVar);
        }
    }

    /* renamed from: b */
    private void m11665b(List<is> list, ej ejVar) {
        if (list.size() == 0) {
            ejVar.mo1902a(null, null);
        } else {
            it.m4692a().m4723a((List) list, true, new ed(this, ejVar));
        }
    }

    /* renamed from: l */
    private void m11667l() {
        this.f8458c.post(new eh(this));
    }

    /* renamed from: a */
    public void mo1878a(int i, int i2) {
        this.f8457b.mo2231c(i, i2);
    }

    /* renamed from: b */
    public void mo1880b() {
        this.f8457b.mo2232q();
    }

    /* renamed from: c */
    public void mo1882c() {
        this.f8457b.m11532m();
    }

    /* renamed from: d */
    public void mo1883d() {
        this.f8457b.m11533n();
    }

    /* renamed from: a */
    public void mo1879a(Runnable runnable) {
        this.f8457b.m11752a(runnable);
    }

    /* renamed from: g */
    public boolean mo1886g() {
        return this.f8457b.mo1939c();
    }

    /* renamed from: e */
    public int mo1884e() {
        return this.f8457b.getSelectedCount();
    }

    /* renamed from: f */
    public void mo1885f() {
        this.f8457b.mo1891a();
    }

    /* renamed from: h */
    public void mo1887h() {
        this.f8457b.mo1892b();
    }

    /* renamed from: b */
    public void mo1881b(int i, int i2) {
        this.f8457b.m11522b(i, i2);
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

    /* renamed from: a */
    public boolean m11673a() {
        return this.f8457b.getViewMode() != ViewMode.Edit;
    }
}
