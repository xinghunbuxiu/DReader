package com.duokan.reader.ui.bookshelf;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.apache.http.entity.ContentProducer;

class kk implements ContentProducer {
    /* renamed from: a */
    final /* synthetic */ kf f6715a;

    kk(kf kfVar) {
        this.f6715a = kfVar;
    }

    public void writeTo(OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
        outputStreamWriter.write(this.f6715a.m9903j());
        outputStreamWriter.flush();
    }
}
