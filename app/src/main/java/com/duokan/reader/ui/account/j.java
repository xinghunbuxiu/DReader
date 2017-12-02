package com.duokan.reader.ui.account;

import com.duokan.core.sys.as;

class j implements as {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public void a() {
        if (!this.a.a.mFinished) {
            this.a.a.mFinished = true;
            if (this.a.a.mLoginListener != null) {
                this.a.a.mLoginListener.a(this.a.a.mAccount);
            }
        }
    }
}
