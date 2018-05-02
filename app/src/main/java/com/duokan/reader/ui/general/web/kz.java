package com.duokan.reader.ui.general.web;

import com.duokan.core.app.ac;
import com.duokan.core.app.ad;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import java.util.LinkedList;

class kz implements ad {
    /* renamed from: a */
    final /* synthetic */ LinkedList f8127a;
    /* renamed from: b */
    final /* synthetic */ TtsWebController f8128b;

    kz(TtsWebController ttsWebController, LinkedList linkedList) {
        this.f8128b = ttsWebController;
        this.f8127a = linkedList;
    }

    /* renamed from: a */
    public void mo1553a(ac acVar) {
        this.f8128b.mDownloadCenter.m7874a((DownloadCenterTask[]) this.f8127a.toArray(new DownloadCenterTask[0]));
        this.f8128b.requestBack();
    }

    /* renamed from: b */
    public void mo1554b(ac acVar) {
        this.f8128b.mDownloadCenter.m7873a(this.f8127a);
    }
}
