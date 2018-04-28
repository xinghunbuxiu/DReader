package com.duokan.reader.ui.general.web;

class er implements C1352a {
    /* renamed from: a */
    final /* synthetic */ String f7794a;
    /* renamed from: b */
    final /* synthetic */ eq f7795b;

    er(eq eqVar, String str) {
        this.f7795b = eqVar;
        this.f7794a = str;
    }

    /* renamed from: a */
    public void mo1839a(Object... objArr) {
        this.f7795b.f7793b.f7581b.web_notifyWeb(this.f7794a, 0, "operation", Integer.valueOf(1), "text", (String) objArr[0]);
    }

    /* renamed from: b */
    public void mo1840b(Object... objArr) {
        this.f7795b.f7793b.f7581b.web_notifyWeb(this.f7794a, 0, "operation", Integer.valueOf(0), "text", "");
    }
}
