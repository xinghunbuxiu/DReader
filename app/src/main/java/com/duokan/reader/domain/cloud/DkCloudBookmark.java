package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.e.a;

import org.json.JSONObject;
import org.w3c.dom.Node;

import java.util.Date;

public class DkCloudBookmark extends DkCloudAnnotation {
    public DkCloudBookmark(String str, String str2, String str3, long j, Date date, Date date2, g gVar, String str4) {
        super(str, str2, str3, j, date, date2, gVar, null, str4);
    }

    public DkCloudBookmark(String str, String str2, Node node, long j) {
        super(str, str2, node, j);
    }

    protected void fillJsonObject(JSONObject jSONObject) {
    }

    protected void fillXmlNode(Node node) {
        super.fillXmlNode(node);
        a.b(node, "Type", "BOOKMARK");
    }
}
