package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.DkFlowPosition;
import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.ay;
import com.duokan.reader.domain.document.d;

import org.json.JSONObject;

public class c extends d {
    static final /* synthetic */ boolean c = (!c.class.desiredAssertionStatus());
    protected long a;
    protected EpubTypesettingContext b;
    private long d;
    private long e;
    private long f;
    private String g;
    private String h;
    private long i;
    private String j;
    private boolean k;

    protected c(long j, long j2, long j3) {
        this(j, j2, j3, "", "", -1, "");
    }

    protected c(long j, long j2, long j3, String str, String str2, long j4, String str3) {
        this.k = false;
        this.a = -1;
        this.b = null;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = str;
        this.h = str2;
        this.i = j4;
        this.j = str3;
    }

    public long g() {
        return this.d;
    }

    public long h() {
        return this.e;
    }

    public long i() {
        return this.f;
    }

    public String j() {
        return this.g;
    }

    public String k() {
        return this.h;
    }

    public long l() {
        return this.i;
    }

    public String m() {
        return this.j;
    }

    public static c a(JSONObject jSONObject) {
        try {
            return new c(jSONObject.optLong("chapter_index", 0), jSONObject.optLong("para_index", 0), jSONObject.optLong("atom_index", 0), jSONObject.optString("book_revision"), jSONObject.optString("chapter_id"), jSONObject.optLong("byte_offset", -1), jSONObject.optString("kernel_version"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("chapter_index", g());
            jSONObject.put("para_index", h());
            jSONObject.put("atom_index", i());
            jSONObject.put("book_revision", j());
            jSONObject.put("chapter_id", k());
            jSONObject.put("byte_offset", l());
            jSONObject.put("kernel_version", m());
        } catch (Exception e) {
            if (c) {
                e.printStackTrace();
            } else {
                throw new AssertionError();
            }
        }
        return jSONObject;
    }

    protected boolean a(DkeBook dkeBook) {
        if (this.k || !b() || !d() || this.j.equals(ah.e().a())) {
            return false;
        }
        long[] chapterOffsetRange = dkeBook.getChapterOffsetRange(this.d);
        if (chapterOffsetRange[0] >= chapterOffsetRange[1]) {
            return false;
        }
        DkFlowPosition[] flowPositionRange = dkeBook.getFlowPositionRange(this.d, this.i, this.d, chapterOffsetRange[1]);
        if (flowPositionRange[0].mChapterIndex == 0 && flowPositionRange[0].mParaIndex == 0 && flowPositionRange[0].mAtomIndex == 0 && flowPositionRange[1].mChapterIndex == 0 && flowPositionRange[1].mParaIndex == 0 && flowPositionRange[1].mAtomIndex == 0) {
            DkFlowPosition[] flowPositionRange2 = dkeBook.getFlowPositionRange(this.d, 0, this.d, this.i);
            this.d = flowPositionRange2[1].mChapterIndex;
            this.e = flowPositionRange2[1].mParaIndex;
            this.f = flowPositionRange2[1].mAtomIndex;
        } else {
            this.d = flowPositionRange[0].mChapterIndex;
            this.e = flowPositionRange[0].mParaIndex;
            this.f = flowPositionRange[0].mAtomIndex;
        }
        this.j = ah.e().a();
        this.k = true;
        return true;
    }

    protected DkFlowPosition b(DkeBook dkeBook) {
        return new DkFlowPosition(this.d, this.e, this.f);
    }

    public boolean a() {
        return true;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return this.i >= 0;
    }

    public boolean e() {
        return true;
    }

    public boolean a(long j) {
        return true;
    }

    public boolean a(Document_a aVar) {
        if (aVar instanceof ay) {
            return a(((ay) aVar).g());
        }
        c cVar = (c) aVar;
        if (this.d < cVar.d) {
            return true;
        }
        if (this.d == cVar.d && this.e < cVar.e) {
            return true;
        }
        if (this.d == cVar.d && this.e == cVar.e && this.f < cVar.f) {
            return true;
        }
        return false;
    }

    public boolean c(Document_a aVar) {
        if (aVar instanceof ay) {
            return d(((ay) aVar).h());
        }
        c cVar = (c) aVar;
        if (this.d > cVar.d) {
            return true;
        }
        if (this.d == cVar.d && this.e > cVar.e) {
            return true;
        }
        if (this.d == cVar.d && this.e == cVar.e && this.f > cVar.f) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.d == cVar.d && this.e == cVar.e && this.f == cVar.f) {
            return true;
        }
        return false;
    }

    public String toString() {
        return f().toString();
    }
}
