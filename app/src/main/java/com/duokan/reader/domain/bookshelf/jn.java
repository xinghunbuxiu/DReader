package com.duokan.reader.domain.bookshelf;

import com.duokan.common.FileTypeRecognizer;
import com.duokan.common.FileTypeRecognizer.FileType;
import com.duokan.reader.domain.micloud.bi;
import com.duokan.reader.domain.micloud.bj;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

class jn {
    /* renamed from: a */
    public bj f3402a;
    /* renamed from: b */
    public final ConcurrentHashMap<String, is> f3403b;

    private jn() {
        this.f3402a = new bj();
        this.f3403b = new ConcurrentHashMap();
    }

    /* renamed from: a */
    public void m4739a(Collection<bi> collection) {
        this.f3403b.clear();
        for (bi biVar : collection) {
            if (FileTypeRecognizer.m567a(biVar.m8155e()) != FileType.UNSUPPORTED) {
                is isVar = new is(biVar);
                this.f3403b.put(isVar.m4686f(), isVar);
            }
        }
    }

    /* renamed from: a */
    public void m4737a(is isVar) {
        if (FileTypeRecognizer.m567a(isVar.m4682b()) != FileType.UNSUPPORTED) {
            this.f3403b.put(isVar.m4686f(), isVar);
        } else {
            this.f3403b.remove(isVar.m4686f());
        }
    }

    /* renamed from: a */
    public void m4738a(String str) {
        this.f3403b.remove(str);
    }

    /* renamed from: b */
    public is m4740b(String str) {
        return (is) this.f3403b.get(str);
    }
}
