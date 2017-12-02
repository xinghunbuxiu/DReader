package com.duokan.reader.domain.cloud;

import org.json.JSONObject;
import org.w3c.dom.Node;

public abstract class DkCloudJsonItem extends DkCloudItem {
    static final /* synthetic */ boolean $assertionsDisabled = (!DkCloudJsonItem.class.desiredAssertionStatus());

    public DkCloudJsonItem(long j) {
        super(j);
    }

    public DkCloudJsonItem(DkCloudJsonItem dkCloudJsonItem) {
        super((DkCloudItem) dkCloudJsonItem);
    }

    protected void fillXmlNode(Node node) {
        if (!$assertionsDisabled) {
            throw new AssertionError();
        }
    }

    protected void fillJsonObject(JSONObject jSONObject) {
    }
}
