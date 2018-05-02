package com.duokan.reader.common.async.work;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener.CheckErrorResult;

class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void run() {
        synchronized (this.a) {
            this.a.d = Thread.currentThread();
        }
        try {
            a();
            synchronized (this.a) {
                this.a.d = null;
            }
        } catch (Throwable th) {
            synchronized (this.a) {
                this.a.d = null;
            }
        }
    }

    private void a() {
        synchronized (this.a) {
            Object obj = (this.a.c.g() || this.a.c.h()) ? 1 : null;
        }
        if (obj != null) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
        }
        int i = 0;
        while (true) {
            Object obj2;
            e a;
            Object obj3;
            Object obj4;
            synchronized (this.a) {
                Object obj5 = (this.a.c.g() || this.a.c.h()) ? 1 : null;
                if (obj5 == null || !this.a.c.q()) {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
            }
            if (obj2 != null) {
                this.a.e();
            }
            if (obj5 != null) {
                a = this.a.a(i);
            } else {
                a = null;
            }
            this.a.j();
            synchronized (this.a) {
                if (this.a.c.g() || this.a.c.h()) {
                    obj5 = 1;
                } else {
                    obj5 = null;
                }
                if (a == null) {
                    if (obj5 == null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    obj5 = null;
                    obj3 = null;
                    obj4 = obj2;
                    obj2 = null;
                } else if (this.a.c.n()) {
                    obj2 = null;
                    obj5 = null;
                    obj3 = null;
                    r7 = 1;
                } else if (a.b()) {
                    this.a.c.a(a);
                    obj2 = null;
                    obj5 = null;
                    int i2 = 1;
                    r7 = 1;
                } else if (a.c()) {
                    if (obj5 != null) {
                        this.a.c.b(e.b(-2, true, false));
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    obj5 = obj2;
                    obj3 = null;
                    r7 = 1;
                    obj2 = null;
                } else if (!a.e) {
                    this.a.c.b(a);
                    obj2 = null;
                    r5 = 1;
                    obj3 = null;
                    r7 = 1;
                } else if (obj5 == null) {
                    obj2 = null;
                    obj5 = null;
                    obj3 = null;
                    r7 = 1;
                } else if (!a.f && this.a.a(a) != CheckErrorResult.Passed) {
                    this.a.c.b(a);
                    obj2 = null;
                    r5 = 1;
                    obj3 = null;
                    r7 = 1;
                } else if (i < this.a.b().d()) {
                    i++;
                    obj2 = null;
                    obj5 = null;
                    obj3 = null;
                    obj4 = null;
                } else {
                    r5 = this.a.b(a);
                    if (r5 == 3) {
                        this.a.c.a(false);
                        obj2 = 1;
                        obj5 = null;
                    } else if (r5 == 6) {
                        this.a.c.b(a);
                        obj2 = null;
                        r5 = 1;
                    } else {
                        throw new IllegalStateException();
                    }
                    obj3 = null;
                    r7 = 1;
                }
            }
            if (obj3 != null) {
                this.a.j();
                this.a.g();
            } else if (obj5 != null) {
                this.a.j();
                this.a.i();
            } else if (obj2 != null) {
                this.a.j();
                this.a.f();
            }
            synchronized (this.a) {
                if (obj4 != null) {
                    if (!this.a.c.g()) {
                        this.a.f = null;
                        this.a.g = null;
                        return;
                    }
                }
            }
        }
    }
}
