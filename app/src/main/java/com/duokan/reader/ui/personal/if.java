package com.duokan.reader.ui.personal;

class if extends r {
    final /* synthetic */ j a;
    final /* synthetic */ ie b;
    private b c = null;

    if(ie ieVar, j jVar) {
        this.b = ieVar;
        this.a = jVar;
    }

    protected void onSessionTry() {
        this.c = new o(this, null).e(this.b.a.getBookUuid());
    }

    protected void onSessionSucceeded() {
        this.a.dismiss();
        this.b.b.b.pushPageSmoothly(bv.a(x.a(this.b.b.getContext()), "0", Integer.parseInt(((String[]) this.c.a)[0]), ((String[]) this.c.a)[1], null), null);
    }

    protected void onSessionFailed() {
        this.a.dismiss();
        be.a(this.b.b.getContext(), this.b.b.getString(com.duokan.c.j.general__shared__network_error), 1).show();
    }
}
