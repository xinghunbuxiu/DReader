package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.p039e.C0606a;
import java.util.Date;
import org.json.JSONObject;
import org.w3c.dom.Node;

public class DkCloudBookmark extends DkCloudAnnotation {
    public DkCloudBookmark(String str, String str2, String str3, long j, Date date, Date date2, C0847g c0847g, String str4) {
        super(str, str2, str3, j, date, date2, c0847g, null, str4);
    }

    public DkCloudBookmark(String str, String str2, Node node, long j) {
        super(str, str2, node, j);
    }

    protected void fillJsonObject(JSONObject jSONObject) {
    }

    protected void fillXmlNode(Node node) {
        super.fillXmlNode(node);
        C0606a.m2779b(node, "Type", "BOOKMARK");
    }
}
