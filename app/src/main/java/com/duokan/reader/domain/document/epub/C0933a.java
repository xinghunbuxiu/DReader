package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.epublib.DkeResourceStream;
import java.nio.ByteBuffer;

/* renamed from: com.duokan.reader.domain.document.epub.a */
class C0933a implements DkeResourceStream {
    /* renamed from: a */
    private final ax f4457a;

    public C0933a(ax axVar) {
        this.f4457a = axVar;
    }

    public DkeResourceStream clone() {
        return new C0933a(this.f4457a.mo1079a());
    }

    public int read(ByteBuffer byteBuffer, long j) {
        return this.f4457a.mo1078a(byteBuffer, j);
    }

    public boolean isOpen() {
        return this.f4457a.mo1080b();
    }

    public boolean isLowQuality() {
        return this.f4457a.mo1081c();
    }

    public long getLength() {
        return this.f4457a.mo1082d();
    }

    public void close() {
        this.f4457a.mo1083e();
    }
}
