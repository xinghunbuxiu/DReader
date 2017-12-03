package com.duokan.reader.domain.cloud;

import android.graphics.Color;
import android.text.TextUtils;

import com.duokan.reader.common.e.a;

import org.json.JSONObject;
import org.w3c.dom.Node;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DkCloudItem implements Serializable {
    private static final long serialVersionUID = 0;
    private long mCloudVersion;

    protected abstract void fillJsonObject(JSONObject jSONObject);

    protected abstract void fillXmlNode(Node node);

    public abstract String getCloudId();

    protected abstract DkCloudItem merge(DkCloudItem dkCloudItem);

    public DkCloudItem(long j) {
        this.mCloudVersion = j;
    }

    public DkCloudItem(Node node, long j) {
        this.mCloudVersion = j;
    }

    public DkCloudItem(DkCloudItem dkCloudItem) {
        this.mCloudVersion = dkCloudItem.mCloudVersion;
    }

    public long getCloudVersion() {
        return this.mCloudVersion;
    }

    protected void setCloudVersion(long j) {
        this.mCloudVersion = j;
    }

    protected g xmlGetRefPos(Node node, String str) {
        Node f = a.f(node, str);
        return new g(a.a(f, "ChapterIndex"), a.a(f, "ParaIndex"), a.a(f, "AtomIndex"), a.c(f, "ChapterID"), a.a(f, "Offset"));
    }

    protected Date xmlOptDate(Node node, String str, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Object c = a.c(node, str);
        return !TextUtils.isEmpty(c) ? simpleDateFormat.parse(c) : date;
    }

    protected Date xmlGetDate(Node node, String str) {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(a.c(node, str));
    }

    protected int xmlOptColor(Node node, String str, int i) {
        Object c = a.c(node, str);
        if (TextUtils.isEmpty(c)) {
            return i;
        }
        String[] split = c.split(" ");
        return Color.rgb(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue(), Integer.valueOf(split[2]).intValue());
    }

    protected void xmlInsertRefPos(Node node, String str, g gVar) {
        Node d = a.d(node, str);
        a.b(d, "ChapterID", gVar.a());
        a.b(d, "Offset", "" + gVar.e());
        a.b(d, "ChapterIndex", "" + gVar.b());
        a.b(d, "ParaIndex", "" + gVar.c());
        a.b(d, "AtomIndex", "" + gVar.d());
    }

    protected void xmlInsertDate(Node node, String str, Date date) {
        a.b(node, str, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date));
    }

    protected void xmlInsertColor(Node node, String str, int i) {
        a.b(node, str, String.format("%getScaledTouchSlop %getScaledTouchSlop %getScaledTouchSlop", new Object[]{Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i))}));
    }
}
