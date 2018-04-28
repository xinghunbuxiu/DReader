package com.duokan.reader.domain.cloud;

import android.graphics.Color;
import android.text.TextUtils;
import com.duokan.reader.common.p039e.C0606a;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
import org.w3c.dom.Node;

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

    protected C0847g xmlGetRefPos(Node node, String str) {
        Node f = C0606a.m2783f(node, str);
        return new C0847g(C0606a.m2773a(f, "ChapterIndex"), C0606a.m2773a(f, "ParaIndex"), C0606a.m2773a(f, "AtomIndex"), C0606a.m2780c(f, "ChapterID"), C0606a.m2773a(f, "Offset"));
    }

    protected Date xmlOptDate(Node node, String str, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Object c = C0606a.m2780c(node, str);
        return !TextUtils.isEmpty(c) ? simpleDateFormat.parse(c) : date;
    }

    protected Date xmlGetDate(Node node, String str) {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(C0606a.m2780c(node, str));
    }

    protected int xmlOptColor(Node node, String str, int i) {
        Object c = C0606a.m2780c(node, str);
        if (TextUtils.isEmpty(c)) {
            return i;
        }
        String[] split = c.split(" ");
        return Color.rgb(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue(), Integer.valueOf(split[2]).intValue());
    }

    protected void xmlInsertRefPos(Node node, String str, C0847g c0847g) {
        Node d = C0606a.m2781d(node, str);
        C0606a.m2779b(d, "ChapterID", c0847g.m5589a());
        C0606a.m2779b(d, "Offset", "" + c0847g.m5595e());
        C0606a.m2779b(d, "ChapterIndex", "" + c0847g.m5591b());
        C0606a.m2779b(d, "ParaIndex", "" + c0847g.m5593c());
        C0606a.m2779b(d, "AtomIndex", "" + c0847g.m5594d());
    }

    protected void xmlInsertDate(Node node, String str, Date date) {
        C0606a.m2779b(node, str, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(date));
    }

    protected void xmlInsertColor(Node node, String str, int i) {
        C0606a.m2779b(node, str, String.format("%d %d %d", new Object[]{Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i))}));
    }
}
