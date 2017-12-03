package com.duokan.reader.ui.account;

import android.graphics.Bitmap;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.store.DkStoreBook;

public class ay {
    private final ActivatedController a;
    private ShareEntranceController b = null;

    public ay(ActivatedController activatedControllerVar) {
        this.a = activatedControllerVar;
    }

    public boolean a(ActivatedController activatedControllerVar) {
        return this.b == activatedControllerVar;
    }

    public void a(IFeature featrue, String str, Bitmap bitmap) {
        a();
        this.b = new ShareEntranceController(featrue, str, bitmap);
        b();
    }

    public void a(IFeature featrue, DkCloudNoteBookInfo dkCloudNoteBookInfo, DkCloudComment dkCloudComment) {
        a();
        this.b = new ShareEntranceController(featrue, dkCloudNoteBookInfo, dkCloudComment);
        b();
    }

    public void a(IFeature featrue, String str, DkStoreBook dkStoreBook, String str2, Bitmap bitmap) {
        a();
        this.b = new ShareEntranceController(featrue, str, dkStoreBook, str2, bitmap);
        b();
    }

    private void a() {
        if (this.b != null) {
            this.a.removeSubController(this.b);
            this.a.deactivate(this.b);
        }
    }

    private void b() {
        this.a.addSubController(this.b);
        this.a.activate(this.b);
    }
}
