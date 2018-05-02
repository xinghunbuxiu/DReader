package com.duokan.reader.ui.reading;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.audio.AudioPlayer;
import com.duokan.reader.domain.bookshelf.BookContent;

class rl implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ qh b;

    rl(qh qhVar, Runnable runnable) {
        this.b = qhVar;
        this.a = runnable;
    }

    public void run() {
        this.b.G();
        if (this.b.f.r() == BookContent.AUDIO_TEXT) {
            AudioPlayer.a().f();
        }
        if (this.b.c.bb()) {
            this.b.c.aY();
        }
        if (this.b.c.aE()) {
            this.b.c.aD();
        }
        boolean z = false;
        if (this.b.isMenuShowing()) {
            this.b.requestHideMenu();
            z = true;
        }
        if (this.b.J != null && this.b.J.m()) {
            this.b.J.l();
            z = true;
        }
        if (this.b.M != null && this.b.M.f()) {
            this.b.M.b();
            z = true;
        }
        if (z) {
            this.b.c.b(new rm(this));
            return;
        }
        if (this.a != null) {
            this.a.run();
        }
        if (this.b.f.ai() && this.b.f.a(true) && i.f().a().equals(AccountType.ANONYMOUS) && this.b.E > 0 && System.currentTimeMillis() - ReaderEnv.get().getLastShowLoginDialogInAnonymousTime() > 86400000) {
            ReaderEnv.get().setLastShowLoginDialogInAnonymousTime(System.currentTimeMillis());
            this.b.R();
        }
    }
}
