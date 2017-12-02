package com.duokan.reader.ui.bookshelf;

import org.apache.http.entity.ContentProducer;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

class jb implements ContentProducer {
    final /* synthetic */ iv a;

    jb(iv ivVar) {
        this.a = ivVar;
    }

    public void writeTo(OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
        outputStreamWriter.write(this.a.j());
        outputStreamWriter.flush();
    }
}
