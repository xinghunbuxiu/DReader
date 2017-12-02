package com.duokan.reader.ui.account;

import com.duokan.reader.ui.general.ReaderUi;

class cn implements Runnable {
    final /* synthetic */ ch a;

    cn(ch chVar) {
        this.a = chVar;
    }

    public void run() {
        ReaderUi.a(this.a.getActivity(), this.a.j);
    }
}
