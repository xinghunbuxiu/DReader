package com.duokan.reader.common.async.work;

public interface IAsyncWorkProgressListener {

    public enum CheckErrorResult {
        Ignored,
        Passed,
        Failed
    }

    CheckErrorResult a(c cVar, e eVar);

    void a(c cVar);

    void b(c cVar);

    void c(c cVar);

    void d(c cVar);

    void e(c cVar);

    void f(c cVar);

    void g(c cVar);
}
