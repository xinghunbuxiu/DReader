package com.duokan.reader.common;

public abstract class a {
    protected String a;
    private boolean b = false;

    protected abstract void b();

    protected a(String str) {
        this.a = str;
    }

    public final void a() {
        if (!this.b) {
            this.b = true;
            b();
            this.a = null;
        }
    }
}
