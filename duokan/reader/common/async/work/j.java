package com.duokan.reader.common.async.work;

public class j implements IAsyncWorkProgressListener {
    private final IAsyncWorkProgressListener a;

    public j(IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        this.a = iAsyncWorkProgressListener;
    }

    public void a(c cVar) {
        this.a.a(cVar);
    }

    public void b(c cVar) {
        this.a.b(cVar);
    }

    public void c(c cVar) {
        this.a.c(cVar);
    }

    public void d(c cVar) {
        this.a.d(cVar);
    }

    public void e(c cVar) {
        this.a.e(cVar);
    }

    public void f(c cVar) {
        this.a.f(cVar);
    }

    public CheckErrorResult a(c cVar, e eVar) {
        return this.a.a(cVar, eVar);
    }

    public void g(c cVar) {
        this.a.g(cVar);
    }
}
