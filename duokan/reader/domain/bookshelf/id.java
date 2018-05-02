package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.domain.downloadcenter.DownloadType;
import com.duokan.reader.domain.downloadcenter.a;
import com.duokan.reader.domain.downloadcenter.k;

class id implements k {
    final /* synthetic */ ic a;

    id(ic icVar) {
        this.a = icVar;
    }

    public void a(DownloadCenterTask downloadCenterTask) {
        if (downloadCenterTask.o().a() == DownloadType.BOOK) {
            c c;
            a aVar = (a) downloadCenterTask.o();
            if (TextUtils.isEmpty(aVar.c)) {
                c = this.a.a.c(downloadCenterTask.i());
            } else {
                c = this.a.a.b(aVar.c);
            }
            if (c != null) {
                c.a(downloadCenterTask);
                this.a.a.j(c);
            }
        }
    }

    public void b(DownloadCenterTask downloadCenterTask) {
        if (downloadCenterTask.o().a() == DownloadType.BOOK && !downloadCenterTask.p()) {
            c c;
            a aVar = (a) downloadCenterTask.o();
            if (TextUtils.isEmpty(aVar.c)) {
                c = this.a.a.c(downloadCenterTask.i());
            } else {
                c = this.a.a.b(aVar.c);
            }
            if (c == null) {
                this.a.a.n.d(downloadCenterTask);
                return;
            }
            c.a(downloadCenterTask);
            this.a.a.j(c);
            if (downloadCenterTask.g()) {
                c.b(downloadCenterTask);
                this.a.a.n.d(downloadCenterTask);
            } else if (downloadCenterTask.h()) {
                c.c(downloadCenterTask);
                this.a.a.n.d(downloadCenterTask);
            }
        }
    }
}
