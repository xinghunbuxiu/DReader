package com.duokan.reader.domain.bookshelf;

import com.duokan.core.a.n;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.downloadcenter.b;
import com.duokan.reader.domain.store.a;

import java.io.File;

interface am {
    void a();

    void a(long j);

    void a(an anVar, int i);

    void a(c cVar);

    void a(c cVar, long j);

    void a(c cVar, is isVar);

    void b();

    void b(long j);

    File c();

    boolean c(long j);

    an d(long j);

    File d();

    a e();

    DkCloudStorage f();

    b g();

    n h();

    n i();

    BookOrderHelper j();
}
