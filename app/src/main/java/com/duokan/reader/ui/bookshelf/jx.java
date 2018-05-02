package com.duokan.reader.ui.bookshelf;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.apache.http.entity.ContentProducer;
import org.json.JSONObject;

class jx implements ContentProducer {
    /* renamed from: a */
    final /* synthetic */ JSONObject f6694a;
    /* renamed from: b */
    final /* synthetic */ jt f6695b;

    jx(jt jtVar, JSONObject jSONObject) {
        this.f6695b = jtVar;
        this.f6694a = jSONObject;
    }

    public void writeTo(OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
        outputStreamWriter.write(this.f6694a.toString());
        outputStreamWriter.flush();
    }
}
