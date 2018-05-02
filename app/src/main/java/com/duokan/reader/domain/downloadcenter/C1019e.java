package com.duokan.reader.domain.downloadcenter;

import java.util.Comparator;

/* renamed from: com.duokan.reader.domain.downloadcenter.e */
class C1019e implements Comparator<DownloadCenterTask> {
    /* renamed from: a */
    final /* synthetic */ boolean f5069a;
    /* renamed from: b */
    final /* synthetic */ C1016b f5070b;

    C1019e(C1016b c1016b, boolean z) {
        this.f5070b = c1016b;
        this.f5069a = z;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m7903a((DownloadCenterTask) obj, (DownloadCenterTask) obj2);
    }

    /* renamed from: a */
    public int m7903a(DownloadCenterTask downloadCenterTask, DownloadCenterTask downloadCenterTask2) {
        int i = 0;
        if (downloadCenterTask.f5029a.mo794g() > downloadCenterTask2.f5029a.mo794g()) {
            i = 1;
        } else if (downloadCenterTask.f5029a.mo794g() < downloadCenterTask2.f5029a.mo794g()) {
            i = -1;
        }
        return this.f5069a ? i : -i;
    }
}
