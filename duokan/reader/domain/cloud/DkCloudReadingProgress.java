package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.e.a;

import org.json.JSONObject;
import org.w3c.dom.Node;

import java.util.Calendar;
import java.util.Date;

public class DkCloudReadingProgress extends DkCloudItem {
    static final /* synthetic */ boolean $assertionsDisabled = (!DkCloudReadingProgress.class.desiredAssertionStatus());
    private final Date mCreationDate;
    private final Date mModifiedDate;
    private final g mStartPos;

    public DkCloudReadingProgress(g gVar) {
        super(0);
        this.mCreationDate = Calendar.getInstance().getTime();
        this.mModifiedDate = Calendar.getInstance().getTime();
        this.mStartPos = gVar;
    }

    public DkCloudReadingProgress(Node node, long j) {
        super(node, j);
        this.mCreationDate = xmlOptDate(node, "CreateTime", new Date(0));
        this.mModifiedDate = xmlOptDate(node, "LastModifyTime", this.mCreationDate);
        this.mStartPos = xmlGetRefPos(node, "RefPos");
    }

    public g getStartPos() {
        return this.mStartPos;
    }

    public String getCloudId() {
        return "0";
    }

    protected DkCloudItem merge(DkCloudItem dkCloudItem) {
        if ($assertionsDisabled || getCloudId().equals(dkCloudItem.getCloudId())) {
            return new DkCloudReadingProgress(((DkCloudReadingProgress) dkCloudItem).getStartPos());
        }
        throw new AssertionError();
    }

    protected void fillJsonObject(JSONObject jSONObject) {
        jSONObject.put("Type", "PROGRESS");
        jSONObject.put("DataID", "0");
        jSONObject.put("CreateTime", "" + (this.mCreationDate.getTime() / 1000));
        jSONObject.put("LastModifyTime", "" + (this.mModifiedDate.getTime() / 1000));
        jSONObject.put("RefPos", this.mStartPos.f());
    }

    protected void fillXmlNode(Node node) {
        a.b(node, "Type", "PROGRESS");
        a.b(node, "DataID", "0");
        xmlInsertRefPos(node, "RefPos", this.mStartPos);
        xmlInsertDate(node, "CreateTime", this.mCreationDate);
        xmlInsertDate(node, "LastModifyTime", this.mModifiedDate);
    }
}
