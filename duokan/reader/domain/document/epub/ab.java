package com.duokan.reader.domain.document.epub;

import android.net.Uri;

import com.duokan.kernel.epublib.DkeAudioText;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.b;
import com.duokan.reader.domain.document.f;
import com.duokan.reader.domain.document.h;
import com.duokan.reader.domain.document.l;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

class ab extends e {
    final /* synthetic */ s a;
    private final AtomicInteger b = new AtomicInteger(1);
    private final ap c;
    private final DkeBook d;
    private final String[] e;
    private final File f;
    private final long g;
    private final long h;
    private final ac i;
    private b[][] j = ((b[][]) null);
    private final aa k;

    public /* synthetic */ h d() {
        return j();
    }

    public ab(s sVar, ap apVar, aq aqVar) {
        this.a = sVar;
        this.c = apVar;
        this.d = aqVar.b;
        this.e = aqVar.a;
        this.f = new File(Uri.parse(this.c.a).getPath());
        this.g = this.f.length();
        this.h = this.d.getChapterCount();
        this.j = new b[((int) this.h)][];
        this.i = new ac(sVar);
        if (this.e != null) {
            an anVar = ((al) apVar).b;
            EpubContentEntryData[] epubContentEntryDataArr = new EpubContentEntryData[anVar.a()];
            for (int i = 0; i < epubContentEntryDataArr.length; i++) {
                epubContentEntryDataArr[i] = new EpubContentEntryData();
                epubContentEntryDataArr[i].mChapterIndex = (long) i;
                epubContentEntryDataArr[i].mTitle = anVar.a(i).b();
            }
            this.i.a(epubContentEntryDataArr);
        } else {
            this.i.a(this.d);
        }
        this.k = new aa(sVar, this.d);
    }

    public ab(s sVar, ap apVar, DkeBook dkeBook, String[] strArr) {
        this.a = sVar;
        this.c = apVar;
        this.d = dkeBook;
        this.e = strArr;
        this.f = new File(Uri.parse(this.c.a).getPath());
        this.g = this.f.length();
        this.h = this.d.getChapterCount();
        this.j = new b[((int) this.h)][];
        this.i = new ac(sVar);
        if (this.e != null) {
            an anVar = ((al) apVar).b;
            EpubContentEntryData[] epubContentEntryDataArr = new EpubContentEntryData[anVar.a()];
            for (int i = 0; i < epubContentEntryDataArr.length; i++) {
                epubContentEntryDataArr[i] = new EpubContentEntryData();
                epubContentEntryDataArr[i].mChapterIndex = (long) i;
                epubContentEntryDataArr[i].mTitle = anVar.a(i).b();
            }
            this.i.a(epubContentEntryDataArr);
        } else {
            this.i.a(this.d);
        }
        this.k = new aa(sVar, this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this.d != ((ab) obj).d) {
            return false;
        }
        return true;
    }

    public l c() {
        return this.c;
    }

    public g j() {
        return this.i;
    }

    public f e() {
        return this.k;
    }

    public void f() {
        a.c().b(this.b.get() > 0);
        this.b.incrementAndGet();
    }

    public void g() {
        a.c().b(this.b.get() > 0);
        if (this.b.decrementAndGet() == 0) {
            this.d.close();
        }
    }

    public DkeBook h() {
        return this.d;
    }

    public File a() {
        return this.f;
    }

    public long b() {
        return this.g;
    }

    public long i() {
        return this.h;
    }

    public b[] a(long j) {
        int i = 0;
        if (this.j[(int) j] == null) {
            Document_a a = this.a.a(0, 0);
            if (!this.a.d(a) || !a.e()) {
                return new b[0];
            }
            DkeAudioText[] audioTexts = this.d.getAudioTexts(j);
            z[] zVarArr = new z[audioTexts.length];
            while (i < zVarArr.length) {
                zVarArr[i] = new z(this.a, audioTexts[i]);
                i++;
            }
            this.j[(int) j] = zVarArr;
        }
        return this.j[(int) j];
    }
}
