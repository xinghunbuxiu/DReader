package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.C0299i;

class lh implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f8146a;
    /* renamed from: b */
    final /* synthetic */ C0299i f8147b;
    /* renamed from: c */
    final /* synthetic */ String f8148c;
    /* renamed from: d */
    final /* synthetic */ String f8149d;
    /* renamed from: e */
    final /* synthetic */ lg f8150e;

    lh(lg lgVar, String str, C0299i c0299i, String str2, String str3) {
        this.f8150e = lgVar;
        this.f8146a = str;
        this.f8147b = c0299i;
        this.f8148c = str2;
        this.f8149d = str3;
    }

    public void run() {
        this.f8150e.f8145a.mPageLoadingView.setVisibility(4);
        String str = this.f8146a;
        int i = -1;
        switch (str.hashCode()) {
            case -1959581811:
                if (str.equals("tag_download")) {
                    i = 3;
                    break;
                }
                break;
            case -1590630945:
                if (str.equals("tag_put_data")) {
                    i = 2;
                    break;
                }
                break;
            case -1548664189:
                if (str.equals("tag_pay")) {
                    i = 9;
                    break;
                }
                break;
            case -1411211784:
                if (str.equals("tag_get_data")) {
                    i = 1;
                    break;
                }
                break;
            case -1410688487:
                if (str.equals("tag_get_user")) {
                    i = 0;
                    break;
                }
                break;
            case -1072646731:
                if (str.equals("tag_resume_download")) {
                    i = 5;
                    break;
                }
                break;
            case -764367252:
                if (str.equals("tag_back")) {
                    i = 7;
                    break;
                }
                break;
            case -258361016:
                if (str.equals("tag_free_trial")) {
                    i = 10;
                    break;
                }
                break;
            case 262696950:
                if (str.equals("tag_pause_download")) {
                    i = 4;
                    break;
                }
                break;
            case 344514014:
                if (str.equals("tag_reload")) {
                    i = 8;
                    break;
                }
                break;
            case 344544457:
                if (str.equals("tag_remove")) {
                    i = 6;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                this.f8147b.m708a(this.f8150e.f8145a.getUserInfo(this.f8150e.f8145a.mTtsManager.getTtsUserId()));
                return;
            case 1:
                this.f8147b.m708a(this.f8150e.f8145a.getSpeakerData(this.f8148c));
                return;
            case 2:
                this.f8147b.m708a(this.f8150e.f8145a.putSpeakerData(this.f8148c));
                return;
            case 3:
                this.f8150e.f8145a.downloadSpeaker(this.f8147b, this.f8148c);
                return;
            case 4:
                this.f8147b.m708a(this.f8150e.f8145a.pauseDownload(this.f8148c));
                return;
            case 5:
                this.f8147b.m708a(this.f8150e.f8145a.resumeDownload(this.f8148c));
                return;
            case 6:
                this.f8147b.m708a(this.f8150e.f8145a.removeSpeaker(this.f8148c));
                return;
            case 7:
                this.f8150e.f8145a.close();
                this.f8147b.m708a("");
                return;
            case 8:
                this.f8150e.f8145a.reload();
                this.f8147b.m708a("");
                return;
            case 9:
                this.f8147b.m708a(this.f8150e.f8145a.payTts(this.f8148c, this.f8149d));
                return;
            case 10:
                this.f8147b.m708a("");
                return;
            default:
                this.f8147b.m708a("");
                return;
        }
    }
}
