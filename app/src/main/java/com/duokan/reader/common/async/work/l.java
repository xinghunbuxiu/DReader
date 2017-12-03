package com.duokan.reader.common.async.work;

import java.util.LinkedList;
import java.util.List;

class l implements IAsyncWorkProgressListener {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public void a(c cVar) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.a) {
            if (!this.a.j) {
                linkedList.addAll(this.a.g);
            }
        }
        for (IAsyncWorkProgressListener a : linkedList) {
            a.a(cVar);
        }
    }

    public void b(c cVar) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.a) {
            if (!this.a.j) {
                linkedList.addAll(this.a.g);
            }
        }
        for (IAsyncWorkProgressListener b : linkedList) {
            b.b(cVar);
        }
    }

    public void c(c cVar) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.a) {
            if (!this.a.j) {
                linkedList.addAll(this.a.g);
            }
        }
        for (IAsyncWorkProgressListener c : linkedList) {
            c.c(cVar);
        }
    }

    public void d(c cVar) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.a) {
            if (!this.a.j) {
                linkedList.addAll(this.a.g);
            }
        }
        for (IAsyncWorkProgressListener d : linkedList) {
            d.d(cVar);
        }
    }

    public void e(c cVar) {
        o oVar;
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.a) {
            if (!this.a.j) {
                linkedList.addAll(this.a.g);
            }
        }
        for (IAsyncWorkProgressListener e : linkedList) {
            e.e(cVar);
        }
        synchronized (this.a) {
            if (this.a.j) {
                oVar = null;
            } else {
                oVar = this.a.f(cVar);
                if (oVar != null) {
                    this.a.e.remove(cVar);
                    this.a.f.remove(oVar);
                }
            }
        }
        if (oVar != null) {
            this.a.b.c(cVar);
            oVar.c(this.a.i);
            this.a.h();
        }
    }

    public void f(c cVar) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.a) {
            if (!this.a.j) {
                linkedList.addAll(this.a.g);
            }
        }
        for (IAsyncWorkProgressListener f : linkedList) {
            f.f(cVar);
        }
        synchronized (this.a) {
            o oVar;
            if (this.a.j) {
                oVar = null;
            } else {
                oVar = this.a.f(cVar);
                if (oVar != null) {
                    this.a.e.remove(cVar);
                    this.a.f.remove(oVar);
                }
            }
        }
        if (oVar != null) {
            this.a.b.c(cVar);
            oVar.c(this.a.i);
            this.a.h();
        }
    }

    public CheckErrorResult a(c cVar, e eVar) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.a) {
            if (!this.a.j) {
                linkedList.addAll(this.a.g);
            }
        }
        CheckErrorResult checkErrorResult = CheckErrorResult.Ignored;
        CheckErrorResult checkErrorResult2 = checkErrorResult;
        for (IAsyncWorkProgressListener a : linkedList) {
            checkErrorResult2 = a.a(checkErrorResult2, a.a(cVar, eVar));
        }
        return checkErrorResult2;
    }

    public void g(c cVar) {
        List<IAsyncWorkProgressListener> linkedList = new LinkedList();
        synchronized (this.a) {
            if (!this.a.j) {
                linkedList.addAll(this.a.g);
            }
        }
        for (IAsyncWorkProgressListener g : linkedList) {
            g.g(cVar);
        }
    }
}
