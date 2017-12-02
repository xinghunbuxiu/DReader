package com.duokan.reader.ui.bookshelf;

import org.apache.http.entity.ContentProducer;
import org.json.JSONObject;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

class jl implements ContentProducer {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ jh b;

    jl(jh jhVar, JSONObject jSONObject) {
        this.b = jhVar;
        this.a = jSONObject;
    }

    public void writeTo(OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");
        outputStreamWriter.write(this.a.toString());
        outputStreamWriter.flush();
    }
}
