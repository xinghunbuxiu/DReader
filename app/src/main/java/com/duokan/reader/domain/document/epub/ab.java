package com.duokan.reader.domain.document.epub;

import android.net.Uri;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.kernel.epublib.DkeAudioText;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0908f;
import com.duokan.reader.domain.document.C0911h;
import com.duokan.reader.domain.document.C0919l;
import com.duokan.reader.domain.document.C0930b;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

class ab extends C0934e {
    /* renamed from: a */
    final /* synthetic */ C0952s f4461a;
    /* renamed from: b */
    private final AtomicInteger f4462b = new AtomicInteger(1);
    /* renamed from: c */
    private final ap f4463c;
    /* renamed from: d */
    private final DkeBook f4464d;
    /* renamed from: e */
    private final String[] f4465e;
    /* renamed from: f */
    private final File f4466f;
    /* renamed from: g */
    private final long f4467g;
    /* renamed from: h */
    private final long f4468h;
    /* renamed from: i */
    private final ac f4469i;
    /* renamed from: j */
    private C0930b[][] f4470j = ((C0930b[][]) null);
    /* renamed from: k */
    private final aa f4471k;

    /* renamed from: d */
    public /* synthetic */ C0911h mo1258d() {
        return m6478j();
    }

    public ab(C0952s c0952s, ap apVar, aq aqVar) {
        this.f4461a = c0952s;
        this.f4463c = apVar;
        this.f4464d = aqVar.f4489b;
        this.f4465e = aqVar.f4488a;
        this.f4466f = new File(Uri.parse(this.f4463c.a).getPath());
        this.f4467g = this.f4466f.length();
        this.f4468h = this.f4464d.getChapterCount();
        this.f4470j = new C0930b[((int) this.f4468h)][];
        this.f4469i = new ac(c0952s);
        if (this.f4465e != null) {
            an anVar = ((al) apVar).f4485b;
            EpubContentEntryData[] epubContentEntryDataArr = new EpubContentEntryData[anVar.mo1067a()];
            for (int i = 0; i < epubContentEntryDataArr.length; i++) {
                epubContentEntryDataArr[i] = new EpubContentEntryData();
                epubContentEntryDataArr[i].mChapterIndex = (long) i;
                epubContentEntryDataArr[i].mTitle = anVar.mo1069a(i).mo1057b();
            }
            this.f4469i.m6485a(epubContentEntryDataArr);
        } else {
            this.f4469i.m6483a(this.f4464d);
        }
        this.f4471k = new aa(c0952s, this.f4464d);
    }

    public ab(C0952s c0952s, ap apVar, DkeBook dkeBook, String[] strArr) {
        this.f4461a = c0952s;
        this.f4463c = apVar;
        this.f4464d = dkeBook;
        this.f4465e = strArr;
        this.f4466f = new File(Uri.parse(this.f4463c.a).getPath());
        this.f4467g = this.f4466f.length();
        this.f4468h = this.f4464d.getChapterCount();
        this.f4470j = new C0930b[((int) this.f4468h)][];
        this.f4469i = new ac(c0952s);
        if (this.f4465e != null) {
            an anVar = ((al) apVar).f4485b;
            EpubContentEntryData[] epubContentEntryDataArr = new EpubContentEntryData[anVar.mo1067a()];
            for (int i = 0; i < epubContentEntryDataArr.length; i++) {
                epubContentEntryDataArr[i] = new EpubContentEntryData();
                epubContentEntryDataArr[i].mChapterIndex = (long) i;
                epubContentEntryDataArr[i].mTitle = anVar.mo1069a(i).mo1057b();
            }
            this.f4469i.m6485a(epubContentEntryDataArr);
        } else {
            this.f4469i.m6483a(this.f4464d);
        }
        this.f4471k = new aa(c0952s, this.f4464d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this.f4464d != ((ab) obj).f4464d) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public C0919l mo1257c() {
        return this.f4463c;
    }

    /* renamed from: j */
    public C0935g m6478j() {
        return this.f4469i;
    }

    /* renamed from: e */
    public C0908f mo1259e() {
        return this.f4471k;
    }

    /* renamed from: f */
    public void mo1260f() {
        C0328a.m757c().m764b(this.f4462b.get() > 0);
        this.f4462b.incrementAndGet();
    }

    /* renamed from: g */
    public void mo1261g() {
        C0328a.m757c().m764b(this.f4462b.get() > 0);
        if (this.f4462b.decrementAndGet() == 0) {
            this.f4464d.close();
        }
    }

    /* renamed from: h */
    public DkeBook mo1365h() {
        return this.f4464d;
    }

    /* renamed from: a */
    public File mo1255a() {
        return this.f4466f;
    }

    /* renamed from: b */
    public long mo1256b() {
        return this.f4467g;
    }

    /* renamed from: i */
    public long mo1366i() {
        return this.f4468h;
    }

    /* renamed from: a */
    public C0930b[] mo1364a(long j) {
        int i = 0;
        if (this.f4470j[(int) j] == null) {
            C0896a a = this.f4461a.m7041a(0, 0);
            if (!this.f4461a.mo1233d(a) || !a.mo1192e()) {
                return new C0930b[0];
            }
            DkeAudioText[] audioTexts = this.f4464d.getAudioTexts(j);
            C0959z[] c0959zArr = new C0959z[audioTexts.length];
            while (i < c0959zArr.length) {
                c0959zArr[i] = new C0959z(this.f4461a, audioTexts[i]);
                i++;
            }
            this.f4470j[(int) j] = c0959zArr;
        }
        return this.f4470j[(int) j];
    }
}
