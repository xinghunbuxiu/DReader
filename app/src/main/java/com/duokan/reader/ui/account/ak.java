package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.store.DkStoreBook;

public class ak {
    /* renamed from: a */
    private final ActivatedController f5791a;
    /* renamed from: b */
    private ShareEntranceController f5792b = null;

    public ak(ActivatedController c0303e) {
        this.f5791a = c0303e;
    }

    /* renamed from: a */
    public boolean m8873a(ActivatedController c0303e) {
        return this.f5792b == c0303e;
    }

    /* renamed from: a */
    public void m8871a(IFeature mFeature, String str, Bitmap bitmap) {
        m8868a();
        this.f5792b = new ShareEntranceController(mFeature, str, bitmap);
        m8869b();
    }

    /* renamed from: a */
    public void m8870a(IFeature mFeature, DkCloudNoteBookInfo dkCloudNoteBookInfo, DkCloudComment dkCloudComment) {
        m8868a();
        this.f5792b = new ShareEntranceController(mFeature, dkCloudNoteBookInfo, dkCloudComment);
        m8869b();
    }

    /* renamed from: a */
    public void m8872a(IFeature mFeature, String str, DkStoreBook dkStoreBook, String str2, Bitmap bitmap) {
        m8868a();
        this.f5792b = new ShareEntranceController(mFeature, str, dkStoreBook, str2, bitmap);
        m8869b();
    }

    /* renamed from: a */
    private void m8868a() {
        if (this.f5792b != null) {
            this.f5791a.removeSubController(this.f5792b);
            this.f5791a.deactivate(this.f5792b);
        }
    }

    /* renamed from: b */
    private void m8869b() {
        this.f5791a.addSubController(this.f5792b);
        this.f5791a.activate(this.f5792b);
    }
}
