package com.duokan.reader.domain.plugins.dict;

import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;

class b implements OnClickListener {
    final /* synthetic */ DownloadCenterTask a;
    final /* synthetic */ a b;

    b(a aVar, DownloadCenterTask downloadCenterTask) {
        this.b = aVar;
        this.a = downloadCenterTask;
    }

    public void onClick(View view) {
        com.duokan.reader.domain.downloadcenter.b.n().c(this.a);
    }
}
