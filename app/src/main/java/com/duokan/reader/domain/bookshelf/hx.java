package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;
import com.duokan.reader.domain.downloadcenter.C0780k;
import com.duokan.reader.domain.downloadcenter.C1015a;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.domain.downloadcenter.DownloadType;

class hx implements C0780k {
    /* renamed from: a */
    final /* synthetic */ hw f3331a;

    hx(hw hwVar) {
        this.f3331a = hwVar;
    }

    public void onTaskRunning(DownloadCenterTask downloadCenterTask) {
        if (downloadCenterTask.m7802p().mo1474a() == DownloadType.BOOK) {
            C0800c c;
            C1015a c1015a = (C1015a) downloadCenterTask.m7802p();
            if (TextUtils.isEmpty(c1015a.f5040c)) {
                c = this.f3331a.f3330a.m3917c(downloadCenterTask.m7795i());
            } else {
                c = this.f3331a.f3330a.m3906b(c1015a.f5040c);
            }
            if (c != null) {
                c.mo990a(downloadCenterTask);
                this.f3331a.f3330a.m3855j(c);
            }
        }
    }

    public void onTaskStatusChanged(DownloadCenterTask downloadCenterTask) {
        if (downloadCenterTask.m7802p().mo1474a() == DownloadType.BOOK && !downloadCenterTask.m7803q()) {
            C0800c c;
            C1015a c1015a = (C1015a) downloadCenterTask.m7802p();
            if (TextUtils.isEmpty(c1015a.f5040c)) {
                c = this.f3331a.f3330a.m3917c(downloadCenterTask.m7795i());
            } else {
                c = this.f3331a.f3330a.m3906b(c1015a.f5040c);
            }
            if (c == null) {
                this.f3331a.f3330a.f2749n.m7887d(downloadCenterTask);
                return;
            }
            c.mo990a(downloadCenterTask);
            this.f3331a.f3330a.m3855j(c);
            if (downloadCenterTask.m7793g()) {
                c.mo992b(downloadCenterTask);
                this.f3331a.f3330a.f2749n.m7887d(downloadCenterTask);
            } else if (downloadCenterTask.m7794h()) {
                c.mo993c(downloadCenterTask);
                this.f3331a.f3330a.f2749n.m7887d(downloadCenterTask);
            }
        }
    }
}
