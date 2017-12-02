package com.duokan.reader.ui.personal;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.iv;
import com.duokan.reader.domain.bookshelf.iw;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.cloud.DkCloudReadingInfo;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.account.ay;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.hs;

public class lt extends e implements iv, iw {
    private final ReaderFeature a = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));
    private final lv b;
    private final ay c = new ay(this);
    private final DkCloudNoteBookInfo d;
    private final DkCloudStoreBook e;
    private DkCloudReadingInfo f;
    private DkCloudReadingInfo g;

    public lt(y yVar, DkCloudNoteBookInfo dkCloudNoteBookInfo, DkCloudStoreBook dkCloudStoreBook) {
        super(yVar);
        this.d = dkCloudNoteBookInfo;
        this.e = dkCloudStoreBook;
        this.b = new lv(this, getContext());
        setContentView(this.b);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.b.b();
        }
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        ai.a().a((iw) this);
        ai.a().a((iv) this);
    }

    protected void onDetachFromStub() {
        ai.a().b((iw) this);
        ai.a().b((iv) this);
        super.onDetachFromStub();
    }

    protected boolean onRequestDetach(e eVar) {
        if (!this.c.a(eVar) || !containsDirectly(eVar)) {
            return super.onRequestDetach(eVar);
        }
        removeSubController(eVar);
        deactivate(eVar);
        return true;
    }

    public void onItemsChanged() {
    }

    public void onItemChanged(an anVar, int i) {
        if ((anVar instanceof c) && (i & 72) != 0) {
            c cVar = (c) anVar;
            if (this.e != null && cVar.H().equals(this.e.getBookUuid())) {
                new hs(getContext(), this.e.getBookUuid(), this.e.getTitle(), this.d.isSerial()).a((DkLabelView) this.b.findViewById(g.personal__notes_info_header_view__read));
                runFirstOnActive("redisplay_list", new lu(this));
            }
        }
    }
}
