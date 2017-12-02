package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.epublib.DkeResourceStream;

import java.nio.ByteBuffer;

class a implements DkeResourceStream {
    private final ax a;

    public a(ax axVar) {
        this.a = axVar;
    }

    public DkeResourceStream clone() {
        return new a(this.a.a());
    }

    public int read(ByteBuffer byteBuffer, long j) {
        return this.a.a(byteBuffer, j);
    }

    public boolean isOpen() {
        return this.a.b();
    }

    public boolean isLowQuality() {
        return this.a.c();
    }

    public long getLength() {
        return this.a.d();
    }

    public void close() {
        this.a.e();
    }
}
