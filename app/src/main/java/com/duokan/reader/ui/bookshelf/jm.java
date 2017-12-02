package com.duokan.reader.ui.bookshelf;

import org.apache.http.entity.ContentProducer;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

class jm implements ContentProducer {
    final /* synthetic */ jh a;

    jm(jh jhVar) {
        this.a = jhVar;
    }

    public void writeTo(OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
        outputStreamWriter.write(this.a.j());
        outputStreamWriter.flush();
    }
}
