package com.duokan.reader.domain.downloadcenter;

import java.util.Comparator;

class e implements Comparator {
    final /* synthetic */ boolean a;
    final /* synthetic */ b b;

    e(b bVar, boolean z) {
        this.b = bVar;
        this.a = z;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((DownloadCenterTask) obj, (DownloadCenterTask) obj2);
    }

    public int a(DownloadCenterTask downloadCenterTask, DownloadCenterTask downloadCenterTask2) {
        int i = 0;
        if (downloadCenterTask.a.g() > downloadCenterTask2.a.g()) {
            i = 1;
        } else if (downloadCenterTask.a.g() < downloadCenterTask2.a.g()) {
            i = -1;
        }
        return this.a ? i : -i;
    }
}
