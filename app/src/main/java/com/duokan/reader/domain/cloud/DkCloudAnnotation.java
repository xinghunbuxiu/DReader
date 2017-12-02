package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.e.a;

import org.w3c.dom.Node;

import java.util.Date;

public abstract class DkCloudAnnotation extends DkCloudItem {
    static final /* synthetic */ boolean $assertionsDisabled = (!DkCloudAnnotation.class.desiredAssertionStatus());
    private final String mAnnotationId;
    private final String mBookRevision;
    private final Date mCreationDate;
    private final g mEndPos;
    private final String mKernelVersion;
    private final Date mModifiedDate;
    private final String mSample;
    private final g mStartPos;

    public DkCloudAnnotation(String str, String str2, String str3, long j, Date date, Date date2, g gVar, g gVar2, String str4) {
        super(j);
        this.mBookRevision = str;
        this.mKernelVersion = str2;
        this.mAnnotationId = str3;
        this.mCreationDate = date;
        this.mModifiedDate = date2;
        this.mStartPos = gVar;
        this.mEndPos = gVar2;
        this.mSample = str4;
    }

    public DkCloudAnnotation(String str, String str2, Node node, long j) {
        super(node, j);
        this.mBookRevision = str;
        this.mKernelVersion = str2;
        this.mAnnotationId = a.c(node, "DataID");
        this.mCreationDate = xmlOptDate(node, "CreateTime", new Date(0));
        this.mModifiedDate = xmlOptDate(node, "LastModifyTime", this.mCreationDate);
        if (a.e(node, "RefPos")) {
            this.mStartPos = xmlGetRefPos(node, "RefPos");
            this.mEndPos = null;
        } else {
            this.mStartPos = xmlGetRefPos(node, "BeginRefPos");
            this.mEndPos = xmlGetRefPos(node, "EndRefPos");
        }
        this.mSample = a.c(node, "RefContent");
    }

    public g getStartPos() {
        return this.mStartPos;
    }

    public g getEndPos() {
        return this.mEndPos;
    }

    public String getSample() {
        return this.mSample;
    }

    public Date getCreationDate() {
        return this.mCreationDate;
    }

    public Date getModifiedDate() {
        return this.mModifiedDate;
    }

    public String getBookRevision() {
        return this.mBookRevision;
    }

    public String getKernelVersion() {
        return this.mKernelVersion;
    }

    public String getCloudId() {
        return this.mAnnotationId;
    }

    public DkCloudItem merge(DkCloudItem dkCloudItem) {
        if ($assertionsDisabled || getCloudId().equals(dkCloudItem.getCloudId())) {
            DkCloudItem dkCloudItem2 = (DkCloudAnnotation) dkCloudItem;
            return getCloudVersion() != dkCloudItem.getCloudVersion() ? getCloudVersion() > dkCloudItem2.getCloudVersion() ? this : dkCloudItem2 : !getModifiedDate().after(dkCloudItem2.getModifiedDate()) ? dkCloudItem2 : this;
        } else {
            throw new AssertionError();
        }
    }

    protected void fillXmlNode(Node node) {
        xmlInsertDate(node, "CreateTime", this.mCreationDate);
        xmlInsertDate(node, "LastModifyTime", this.mModifiedDate);
        if (this.mEndPos == null) {
            xmlInsertRefPos(node, "RefPos", this.mStartPos);
        } else {
            xmlInsertRefPos(node, "BeginRefPos", this.mStartPos);
            xmlInsertRefPos(node, "EndRefPos", this.mEndPos);
        }
        a.b(node, "DataID", this.mAnnotationId);
        a.b(node, "RefContent", this.mSample);
    }
}
