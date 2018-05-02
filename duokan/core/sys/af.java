package com.duokan.core.sys;

public class af {
    private Object a;
    private boolean b;

    public af() {
        this.a = null;
        this.b = false;
    }

    public af(Object obj) {
        this.a = null;
        this.a = obj;
        this.b = true;
    }

    public Object a() {
        return this.a;
    }

    public void a(Object obj) {
        this.a = obj;
        this.b = true;
    }

    public boolean b() {
        return this.b;
    }

    public boolean b(Object obj) {
        if (!this.b) {
            return false;
        }
        if (this.a != null && obj != null) {
            return this.a.equals(obj);
        }
        if (this.a == obj) {
            return true;
        }
        return false;
    }

    public void c() {
        this.a = null;
        this.b = false;
    }

    public void a(af afVar) {
        this.a = afVar.a;
        this.b = afVar.b;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        af afVar = (af) obj;
        if (this.b && afVar.b) {
            return b(afVar.a);
        }
        if (this.b == afVar.b) {
            return true;
        }
        return false;
    }
}
