package com.duokan.reader.ui.bookshelf;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.apache.http.entity.ContentProducer;
import org.json.JSONObject;

class kj implements ContentProducer {
    /* renamed from: a */
    final /* synthetic */ JSONObject f6713a;
    /* renamed from: b */
    final /* synthetic */ kf f6714b;

    kj(kf kfVar, JSONObject jSONObject) {
        this.f6714b = kfVar;
        this.f6713a = jSONObject;
    }

    public void writeTo(OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
        outputStreamWriter.write(this.f6713a.toString());
        outputStreamWriter.flush();
    }
}
