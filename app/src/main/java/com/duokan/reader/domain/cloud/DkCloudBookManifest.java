package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.z;

import org.json.JSONObject;
import org.w3c.dom.Node;

public class DkCloudBookManifest extends DkCloudItem {
    static final /* synthetic */ boolean $assertionsDisabled = (!DkCloudBookManifest.class.desiredAssertionStatus());
    private z mBookCertification = null;
    private String mBookMd5 = "";
    private final String mBookRevision;
    private String mBookUri = "";
    private final String mBookUuid;
    private String mOpfMd5 = "";
    private String mOpfUri = "";

    protected DkCloudBookManifest(String str, String str2, String str3, String str4, String str5, String str6, z zVar) {
        super(0);
        if (!$assertionsDisabled && str == null) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && str3 == null) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && str2 == null) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && str4 == null) {
            throw new AssertionError();
        } else if ($assertionsDisabled || zVar != null) {
            this.mBookUuid = str;
            this.mBookRevision = str2;
            this.mBookUri = str3;
            this.mBookMd5 = str4;
            this.mOpfUri = str5;
            this.mOpfMd5 = str6;
            this.mBookCertification = zVar;
        } else {
            throw new AssertionError();
        }
    }

    public String getBookUuid() {
        return this.mBookUuid;
    }

    public String getBookRevision() {
        return this.mBookRevision;
    }

    public String getBookUri() {
        return this.mBookUri;
    }

    public String getBookMd5() {
        return this.mBookMd5;
    }

    public z getBookCertification() {
        return this.mBookCertification;
    }

    public String getOpfUri() {
        return this.mOpfUri;
    }

    public String getOpfMd5() {
        return this.mOpfMd5;
    }

    public String getCloudId() {
        return getBookUuid();
    }

    protected DkCloudItem merge(DkCloudItem dkCloudItem) {
        return dkCloudItem;
    }

    protected void fillXmlNode(Node node) {
        if (!$assertionsDisabled) {
            throw new AssertionError();
        }
    }

    protected void fillJsonObject(JSONObject jSONObject) {
    }
}
