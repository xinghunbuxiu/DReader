package com.duokan.reader.domain.cloud;

import android.graphics.Color;
import com.duokan.reader.common.p039e.C0606a;
import java.util.Date;
import org.json.JSONObject;
import org.w3c.dom.Node;

public class DkCloudComment extends DkCloudAnnotation {
    private final int mHighlightColor;
    private final String mNoteText;

    public DkCloudComment(String str, String str2, String str3, long j, Date date, Date date2, C0847g c0847g, C0847g c0847g2, String str4, String str5, int i) {
        super(str, str2, str3, j, date, date2, c0847g, c0847g2, str4);
        this.mNoteText = str5;
        this.mHighlightColor = i;
    }

    public DkCloudComment(String str, String str2, Node node, long j) {
        super(str, str2, node, j);
        this.mNoteText = C0606a.m2775a(node, "Content", "");
        this.mHighlightColor = xmlOptColor(node, "Color", Color.rgb(237, 88, 0));
    }

    public String getNoteText() {
        return this.mNoteText;
    }

    public int getHighlightColor() {
        return this.mHighlightColor;
    }

    protected void fillJsonObject(JSONObject jSONObject) {
    }

    protected void fillXmlNode(Node node) {
        super.fillXmlNode(node);
        C0606a.m2779b(node, "Content", this.mNoteText);
        C0606a.m2779b(node, "Type", "COMMENT");
        xmlInsertColor(node, "Color", this.mHighlightColor);
    }
}
