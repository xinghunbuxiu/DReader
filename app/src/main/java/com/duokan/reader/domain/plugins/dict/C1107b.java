package com.duokan.reader.domain.plugins.dict;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;

/* renamed from: com.duokan.reader.domain.plugins.dict.b */
class C1107b implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ DownloadCenterTask f5387a;
    /* renamed from: b */
    final /* synthetic */ C1106a f5388b;

    C1107b(C1106a c1106a, DownloadCenterTask downloadCenterTask) {
        this.f5388b = c1106a;
        this.f5387a = downloadCenterTask;
    }

    public void onClick(View view) {
        C1016b.m7857p().m7885c(this.f5387a);
    }
}
