package com.duokan.reader.ui.reading;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.bookshelf.BookContent;

class rw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Runnable f10919a;
    /* renamed from: b */
    final /* synthetic */ qr f10920b;

    rw(qr qrVar, Runnable runnable) {
        this.f10920b = qrVar;
        this.f10919a = runnable;
    }

    public void run() {
        this.f10920b.m12774G();
        if (this.f10920b.f9282f.m4246r() == BookContent.AUDIO_TEXT) {
            AudioPlayer.m3613a().m3645f();
        }
        if (this.f10920b.f9279c.bb()) {
            this.f10920b.f9279c.aY();
        }
        if (this.f10920b.f9279c.aE()) {
            this.f10920b.f9279c.aD();
        }
        boolean z = false;
        if (this.f10920b.isMenuShowing()) {
            this.f10920b.requestHideMenu();
            z = true;
        }
        if (this.f10920b.f9270J != null && this.f10920b.f9270J.mo2382m()) {
            this.f10920b.f9270J.mo2381l();
            z = true;
        }
        if (this.f10920b.f9273M != null && this.f10920b.f9273M.mo2295f()) {
            this.f10920b.f9273M.mo2290b();
            z = true;
        }
        if (z) {
            this.f10920b.f9279c.mo2103b(new rx(this));
            return;
        }
        if (this.f10919a != null) {
            this.f10919a.run();
        }
        if (this.f10920b.f9282f.ak() && this.f10920b.f9282f.mo1012a(true) && C0709k.m3476a().m3501b().equals(AccountType.ANONYMOUS) && this.f10920b.f9266E > 0 && System.currentTimeMillis() - ReaderEnv.get().getLastShowLoginDialogInAnonymousTime() > 86400000) {
            ReaderEnv.get().setLastShowLoginDialogInAnonymousTime(System.currentTimeMillis());
            this.f10920b.m12785R();
        }
    }
}
