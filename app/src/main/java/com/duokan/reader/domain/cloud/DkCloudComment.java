package com.duokan.reader.domain.cloud;

import android.graphics.Color;

import com.duokan.reader.common.e.a;

import org.json.JSONObject;
import org.w3c.dom.Node;

import java.util.Date;

public class DkCloudComment extends DkCloudAnnotation {
    private final int mHighlightColor;
    private final String mNoteText;

    public DkCloudComment(String str, String str2, String str3, long j, Date date, Date date2, g gVar, g gVar2, String str4, String str5, int i) {
        super(str, str2, str3, j, date, date2, gVar, gVar2, str4);
        this.mNoteText = str5;
        this.mHighlightColor = i;
    }

    public DkCloudComment(String str, String str2, Node node, long j) {
        super(str, str2, node, j);
        this.mNoteText = a.a(node, "Content", "");
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
        a.b(node, "Content", this.mNoteText);
        a.b(node, "Type", "COMMENT");
        xmlInsertColor(node, "Color", this.mHighlightColor);
    }
}
