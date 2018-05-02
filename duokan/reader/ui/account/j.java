package com.duokan.reader.ui.account;

import com.duokan.core.sys.as;

class j implements as {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public void a() {
        if (!this.a.ccountController.mFinished) {
            this.a.ccountController.mFinished = true;
            if (this.a.ccountController.mLoginListener != null) {
                this.a.ccountController.mLoginListener.a(this.a.ccountController.mAccount);
            }
        }
    }
}
