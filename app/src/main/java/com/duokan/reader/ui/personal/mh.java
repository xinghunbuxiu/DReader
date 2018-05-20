package com.duokan.reader.ui.personal;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0255g;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.ip;
import com.duokan.reader.domain.bookshelf.iq;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.cloud.DkCloudReadingInfo;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.account.ak;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.hh;

public class mh extends ActivatedController implements ip, iq {
    /* renamed from: a */
    private final ReaderFeature f8939a = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));
    /* renamed from: b */
    private final mj f8940b;
    /* renamed from: c */
    private final ak f8941c = new ak(this);
    /* renamed from: d */
    private final DkCloudNoteBookInfo f8942d;
    /* renamed from: e */
    private final DkCloudStoreBook f8943e;
    /* renamed from: f */
    private DkCloudReadingInfo f8944f;
    /* renamed from: g */
    private DkCloudReadingInfo f8945g;

    public mh(IFeature mFeature, DkCloudNoteBookInfo dkCloudNoteBookInfo, DkCloudStoreBook dkCloudStoreBook) {
        super(mFeature);
        this.f8942d = dkCloudNoteBookInfo;
        this.f8943e = dkCloudStoreBook;
        this.f8940b = new mj(this, getContext());
        setContentView(this.f8940b);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.f8940b.m12291b();
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        ai.m3980a().m3890a((iq) this);
        ai.m3980a().m3889a((ip) this);
    }

    protected void onDetachFromStub() {
        ai.m3980a().m3913b((iq) this);
        ai.m3980a().m3912b((ip) this);
        super.onDetachFromStub();
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        if (!this.f8941c.m8873a(c0303e) || !containsDirectly(c0303e)) {
            return super.onRequestDetach(c0303e);
        }
        removeSubController(c0303e);
        deactivate(c0303e);
        return true;
    }

    public void onItemsChanged() {
    }

    public void onItemChanged(an anVar, int i) {
        if ((anVar instanceof C0800c) && (i & 72) != 0) {
            C0800c c0800c = (C0800c) anVar;
            if (this.f8943e != null && c0800c.getId().equals(this.f8943e.getBookUuid())) {
                new hh(getContext(), this.f8943e.getBookUuid(), this.f8943e.getTitle(), this.f8942d.isSerial()).m10750a((DkLabelView) this.f8940b.findViewById(C0255g.personal__notes_info_header_view__read));
                runFirstOnActive("redisplay_list", new mi(this));
            }
        }
    }
}
