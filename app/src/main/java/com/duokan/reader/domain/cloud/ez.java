package com.duokan.reader.domain.cloud;

class ez implements Runnable {
    final /* synthetic */ DkUserReadingNotesManager a;

    ez(DkUserReadingNotesManager dkUserReadingNotesManager) {
        this.a = dkUserReadingNotesManager;
    }

    public void run() {
        this.a.b.a(this.a.c);
    }
}
