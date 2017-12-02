package com.duokan.reader.domain.bookshelf;

import com.duokan.common.FileTypeRecognizer;
import com.duokan.common.FileTypeRecognizer.FileType;
import com.duokan.reader.domain.micloud.bi;
import com.duokan.reader.domain.micloud.bj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class jj {
    public bj a;
    public final ArrayList b;
    public final HashMap c;

    private jj() {
        this.a = new bj();
        this.b = new ArrayList();
        this.c = new HashMap();
    }

    public void a(Collection collection) {
        this.b.clear();
        this.c.clear();
        for (bi biVar : collection) {
            if (FileTypeRecognizer.a(biVar.e()) != FileType.UNSUPPORTED) {
                this.b.add(new iy(biVar));
            }
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            iy iyVar = (iy) it.next();
            this.c.put(iyVar.f(), iyVar);
        }
    }

    public void a(iy iyVar) {
        if (FileTypeRecognizer.a(iyVar.b()) != FileType.UNSUPPORTED) {
            this.b.add(iyVar);
            this.c.put(iyVar.f(), iyVar);
        }
    }

    public void a(String str) {
        iy iyVar = (iy) this.c.get(str);
        if (iyVar != null) {
            this.b.remove(iyVar);
            this.c.remove(str);
        }
    }

    public iy b(String str) {
        return (iy) this.c.get(str);
    }
}
