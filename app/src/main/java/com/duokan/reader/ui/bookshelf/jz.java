package com.duokan.reader.ui.bookshelf;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.apache.http.entity.ContentProducer;

class jz implements ContentProducer {
    /* renamed from: a */
    final /* synthetic */ jt f6697a;

    jz(jt jtVar) {
        this.f6697a = jtVar;
    }

    public void writeTo(OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
        outputStreamWriter.write(this.f6697a.m9890j());
        outputStreamWriter.flush();
    }
}
