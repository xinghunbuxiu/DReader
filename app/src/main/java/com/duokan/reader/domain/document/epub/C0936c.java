package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.ay;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.document.epub.c */
public class C0936c extends C0897d {
    /* renamed from: b */
    static final /* synthetic */ boolean f4624b = (!C0936c.class.desiredAssertionStatus());
    /* renamed from: a */
    protected long f4625a;
    /* renamed from: c */
    private long f4626c;
    /* renamed from: d */
    private long f4627d;
    /* renamed from: e */
    private long f4628e;
    /* renamed from: f */
    private String f4629f;
    /* renamed from: g */
    private String f4630g;
    /* renamed from: h */
    private long f4631h;
    /* renamed from: i */
    private String f4632i;
    /* renamed from: j */
    private boolean f4633j;
    /* renamed from: k */
    private WeakReference<EpubTypesettingContext> f4634k;

    protected C0936c(long j, long j2, long j3) {
        this(j, j2, j3, "", "", -1, "");
    }

    protected C0936c(long j, long j2, long j3, String str, String str2, long j4, String str3) {
        this.f4633j = false;
        this.f4625a = -1;
        this.f4634k = null;
        this.f4626c = j;
        this.f4627d = j2;
        this.f4628e = j3;
        this.f4629f = str;
        this.f4630g = str2;
        this.f4631h = j4;
        this.f4632i = str3;
    }

    /* renamed from: g */
    public long m6780g() {
        return this.f4626c;
    }

    /* renamed from: h */
    public long m6781h() {
        return this.f4627d;
    }

    /* renamed from: i */
    public long m6782i() {
        return this.f4628e;
    }

    /* renamed from: j */
    public String m6783j() {
        return this.f4629f;
    }

    /* renamed from: k */
    public String m6784k() {
        return this.f4630g;
    }

    /* renamed from: l */
    public long m6785l() {
        return this.f4631h;
    }

    /* renamed from: m */
    public String m6786m() {
        return this.f4632i;
    }

    /* renamed from: a */
    public static C0936c m6768a(JSONObject jSONObject) {
        try {
            return new C0936c(jSONObject.optLong("chapter_index", 0), jSONObject.optLong("para_index", 0), jSONObject.optLong("atom_index", 0), jSONObject.optString("book_revision"), jSONObject.optString("chapter_id"), jSONObject.optLong("byte_offset", -1), jSONObject.optString("kernel_version"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: f */
    public JSONObject mo1193f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("chapter_index", m6780g());
            jSONObject.put("para_index", m6781h());
            jSONObject.put("atom_index", m6782i());
            jSONObject.put("book_revision", m6783j());
            jSONObject.put("chapter_id", m6784k());
            jSONObject.put("byte_offset", m6785l());
            jSONObject.put("kernel_version", m6786m());
        } catch (Exception e) {
            if (f4624b) {
                e.printStackTrace();
            } else {
                throw new AssertionError();
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    protected boolean m6772a(DkeBook dkeBook) {
        if (this.f4633j || !m5777b() || !mo1191d() || this.f4632i.equals(ah.m6500e().m6501a())) {
            return false;
        }
        long[] chapterOffsetRange = dkeBook.getChapterOffsetRange(this.f4626c);
        if (chapterOffsetRange[0] >= chapterOffsetRange[1]) {
            return false;
        }
        DkFlowPosition[] flowPositionRange = dkeBook.getFlowPositionRange(this.f4626c, this.f4631h, this.f4626c, chapterOffsetRange[1]);
        if (flowPositionRange[0].mChapterIndex == 0 && flowPositionRange[0].mParaIndex == 0 && flowPositionRange[0].mAtomIndex == 0 && flowPositionRange[1].mChapterIndex == 0 && flowPositionRange[1].mParaIndex == 0 && flowPositionRange[1].mAtomIndex == 0) {
            DkFlowPosition[] flowPositionRange2 = dkeBook.getFlowPositionRange(this.f4626c, 0, this.f4626c, this.f4631h);
            this.f4626c = flowPositionRange2[1].mChapterIndex;
            this.f4627d = flowPositionRange2[1].mParaIndex;
            this.f4628e = flowPositionRange2[1].mAtomIndex;
        } else {
            this.f4626c = flowPositionRange[0].mChapterIndex;
            this.f4627d = flowPositionRange[0].mParaIndex;
            this.f4628e = flowPositionRange[0].mAtomIndex;
        }
        this.f4632i = ah.m6500e().m6501a();
        this.f4633j = true;
        return true;
    }

    /* renamed from: b */
    protected DkFlowPosition m6774b(DkeBook dkeBook) {
        return new DkFlowPosition(this.f4626c, this.f4627d, this.f4628e);
    }

    /* renamed from: a */
    void m6769a(EpubTypesettingContext epubTypesettingContext) {
        this.f4634k = new WeakReference(epubTypesettingContext);
    }

    /* renamed from: n */
    EpubTypesettingContext m6787n() {
        return this.f4634k == null ? null : (EpubTypesettingContext) this.f4634k.get();
    }

    /* renamed from: a */
    public boolean mo1186a() {
        return true;
    }

    /* renamed from: c */
    public boolean mo1189c() {
        return false;
    }

    /* renamed from: d */
    public boolean mo1191d() {
        return this.f4631h >= 0;
    }

    /* renamed from: e */
    public boolean mo1192e() {
        return true;
    }

    /* renamed from: a */
    public boolean mo1187a(long j) {
        return true;
    }

    /* renamed from: a */
    public boolean mo1188a(C0896a c0896a) {
        if (c0896a instanceof ay) {
            return mo1188a(((ay) c0896a).mo1198g());
        }
        C0936c c0936c = (C0936c) c0896a;
        if (this.f4626c < c0936c.f4626c) {
            return true;
        }
        if (this.f4626c == c0936c.f4626c && this.f4627d < c0936c.f4627d) {
            return true;
        }
        if (this.f4626c == c0936c.f4626c && this.f4627d == c0936c.f4627d && this.f4628e < c0936c.f4628e) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public boolean mo1190c(C0896a c0896a) {
        if (c0896a instanceof ay) {
            return m5782d(((ay) c0896a).mo1199h());
        }
        C0936c c0936c = (C0936c) c0896a;
        if (this.f4626c > c0936c.f4626c) {
            return true;
        }
        if (this.f4626c == c0936c.f4626c && this.f4627d > c0936c.f4627d) {
            return true;
        }
        if (this.f4626c == c0936c.f4626c && this.f4627d == c0936c.f4627d && this.f4628e > c0936c.f4628e) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0936c)) {
            return false;
        }
        C0936c c0936c = (C0936c) obj;
        if (this.f4626c == c0936c.f4626c && this.f4627d == c0936c.f4627d && this.f4628e == c0936c.f4628e) {
            return true;
        }
        return false;
    }

    public String toString() {
        return mo1193f().toString();
    }
}
