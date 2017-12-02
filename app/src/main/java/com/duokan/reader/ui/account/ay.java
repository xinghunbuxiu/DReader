package com.duokan.reader.ui.account;

import android.graphics.Bitmap;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.store.DkStoreBook;

public class ay {
    private final e a;
    private ShareEntranceController b = null;

    public ay(e eVar) {
        this.a = eVar;
    }

    public boolean a(e eVar) {
        return this.b == eVar;
    }

    public void a(y yVar, String str, Bitmap bitmap) {
        a();
        this.b = new ShareEntranceController(yVar, str, bitmap);
        b();
    }

    public void a(y yVar, DkCloudNoteBookInfo dkCloudNoteBookInfo, DkCloudComment dkCloudComment) {
        a();
        this.b = new ShareEntranceController(yVar, dkCloudNoteBookInfo, dkCloudComment);
        b();
    }

    public void a(y yVar, String str, DkStoreBook dkStoreBook, String str2, Bitmap bitmap) {
        a();
        this.b = new ShareEntranceController(yVar, str, dkStoreBook, str2, bitmap);
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
