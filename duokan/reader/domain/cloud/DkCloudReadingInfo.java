package com.duokan.reader.domain.cloud;

import android.text.TextUtils;

import com.duokan.reader.common.e.a;
import com.duokan.reader.common.webservices.duokan.y;

import org.json.JSONObject;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class DkCloudReadingInfo extends DkCloudItemGroup {
    static final /* synthetic */ boolean $assertionsDisabled = (!DkCloudReadingInfo.class.desiredAssertionStatus() ? true : $assertionsDisabled);
    private static final String READNIG_INFO_VERSION = "2.0";
    private DkCloudAnnotation[] mAnnotations;
    private final String mBookName;
    private final String mBookRevision;
    private final String mDeviceId;
    private final String mInfoId;
    private final boolean mIsDuokanBook;
    private final String mKernelVersion;
    private DkCloudReadingProgress mReadingProgress;

    public DkCloudReadingInfo(String str, String str2, boolean z, long j, String str3, String str4, String str5, DkCloudReadingProgress dkCloudReadingProgress, DkCloudAnnotation[] dkCloudAnnotationArr) {
        super(j);
        this.mInfoId = new y(str).a();
        this.mBookName = str2;
        this.mDeviceId = str3;
        this.mBookRevision = str4;
        this.mKernelVersion = str5;
        this.mIsDuokanBook = z;
        this.mReadingProgress = dkCloudReadingProgress;
        this.mAnnotations = dkCloudAnnotationArr;
    }

    public DkCloudReadingInfo(boolean z, String str, Node node, long j) {
        DkCloudReadingProgress dkCloudReadingProgress = null;
        super(node, j);
        this.mInfoId = a.c(node, "BookID");
        this.mDeviceId = a.c(node, "DeviceID");
        this.mBookRevision = a.c(node, "BookRevision");
        this.mKernelVersion = a.c(node, "KernelVersion");
        this.mBookName = str;
        this.mIsDuokanBook = z;
        Node f = a.f(node, "ReadingData");
        if (f == null) {
            this.mReadingProgress = null;
            this.mAnnotations = new DkCloudAnnotation[0];
            return;
        }
        LinkedList linkedList = new LinkedList();
        Node firstChild = f.getFirstChild();
        while (firstChild != null) {
            DkCloudReadingProgress dkCloudReadingProgress2;
            String c = a.c(firstChild, "Type");
            if (TextUtils.isEmpty(c)) {
                dkCloudReadingProgress2 = dkCloudReadingProgress;
            } else if (c.equals("BOOKMARK")) {
                linkedList.add(new DkCloudBookmark(this.mBookRevision, this.mKernelVersion, firstChild, j));
                dkCloudReadingProgress2 = dkCloudReadingProgress;
            } else if (c.equals("COMMENT")) {
                linkedList.add(new DkCloudComment(this.mBookRevision, this.mKernelVersion, firstChild, j));
                dkCloudReadingProgress2 = dkCloudReadingProgress;
            } else if (c.equals("PROGRESS")) {
                dkCloudReadingProgress2 = new DkCloudReadingProgress(firstChild, j);
            } else {
                dkCloudReadingProgress2 = dkCloudReadingProgress;
            }
            firstChild = firstChild.getNextSibling();
            dkCloudReadingProgress = dkCloudReadingProgress2;
        }
        this.mReadingProgress = dkCloudReadingProgress;
        this.mAnnotations = (DkCloudAnnotation[]) linkedList.toArray(new DkCloudAnnotation[0]);
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getBookName() {
        return this.mBookName;
    }

    public String getBookRevision() {
        return this.mBookRevision;
    }

    public String getKernelVersion() {
        return this.mKernelVersion;
    }

    public DkCloudReadingProgress getReadingProgress() {
        return this.mReadingProgress;
    }

    public boolean getIsDuokanBook() {
        return this.mIsDuokanBook;
    }

    protected void setReadingProgress(DkCloudReadingProgress dkCloudReadingProgress) {
        this.mReadingProgress = dkCloudReadingProgress;
    }

    public DkCloudAnnotation[] getAnnotations() {
        return this.mAnnotations;
    }

    protected void setAnnotations(DkCloudAnnotation[] dkCloudAnnotationArr) {
        this.mAnnotations = dkCloudAnnotationArr;
    }

    protected void fillJsonObjectWithReadingProgress(JSONObject jSONObject) {
        jSONObject.put("SpecVersion", READNIG_INFO_VERSION);
        jSONObject.put("DeviceID", this.mDeviceId);
        jSONObject.put("KernelVersion", this.mKernelVersion);
        jSONObject.put("BookID", this.mInfoId);
        jSONObject.put("BookRevision", this.mBookRevision);
        JSONObject jSONObject2 = new JSONObject();
        if (this.mReadingProgress != null) {
            this.mReadingProgress.fillJsonObject(jSONObject2);
            jSONObject.put("Item", jSONObject2);
        }
    }

    protected void fillXmlNodeWithReadingProgress(Node node) {
        a.b(node, "Version", READNIG_INFO_VERSION);
        a.b(node, "BookID", this.mInfoId);
        a.b(node, "DeviceID", this.mDeviceId);
        a.b(node, "BookRevision", this.mBookRevision);
        a.b(node, "KernelVersion", this.mKernelVersion);
        Node d = a.d(node, "ReadingData");
        if (this.mReadingProgress != null) {
            this.mReadingProgress.fillXmlNode(a.d(d, "ReadingDataItem"));
        }
    }

    protected void fillXmlNodeWithAnnotations(Node node) {
        a.b(node, "Version", READNIG_INFO_VERSION);
        a.b(node, "BookID", this.mInfoId);
        a.b(node, "DeviceID", this.mDeviceId);
        a.b(node, "BookRevision", this.mBookRevision);
        a.b(node, "KernelVersion", this.mKernelVersion);
        Node d = a.d(node, "ReadingData");
        if (this.mAnnotations != null) {
            for (DkCloudAnnotation fillXmlNode : this.mAnnotations) {
                fillXmlNode.fillXmlNode(a.d(d, "ReadingDataItem"));
            }
        }
    }

    public String getCloudId() {
        return this.mInfoId;
    }

    public DkCloudItem merge(DkCloudItem dkCloudItem) {
        if ($assertionsDisabled || getCloudId().equals(dkCloudItem.getCloudId())) {
            DkCloudReadingProgress dkCloudReadingProgress;
            DkCloudReadingInfo dkCloudReadingInfo = (DkCloudReadingInfo) dkCloudItem;
            DkCloudReadingProgress readingProgress = ((DkCloudReadingInfo) dkCloudItem).getReadingProgress();
            DkCloudReadingProgress dkCloudReadingProgress2 = this.mReadingProgress;
            if (this == null || dkCloudReadingProgress2 == null) {
                dkCloudReadingProgress = readingProgress != null ? readingProgress : dkCloudReadingProgress2;
            } else if (getDeviceId().equals(dkCloudReadingInfo.getDeviceId())) {
                dkCloudReadingProgress = dkCloudReadingProgress2;
            } else {
                dkCloudReadingProgress = readingProgress;
            }
            DkCloudAnnotation[] annotations = ((DkCloudReadingInfo) dkCloudItem).getAnnotations();
            DkCloudAnnotation[] dkCloudAnnotationArr = this.mAnnotations;
            LinkedList linkedList = new LinkedList();
            Collection linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            linkedList2.addAll(Arrays.asList(annotations));
            linkedList3.addAll(Arrays.asList(dkCloudAnnotationArr));
            Iterator it = linkedList3.iterator();
            while (it.hasNext()) {
                DkCloudItem dkCloudItem2;
                DkCloudAnnotation dkCloudAnnotation = (DkCloudAnnotation) it.next();
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    dkCloudItem2 = (DkCloudAnnotation) it2.next();
                    if (dkCloudItem2.getCloudId().equals(dkCloudAnnotation.getCloudId())) {
                        it2.remove();
                        break;
                    }
                }
                dkCloudItem2 = null;
                if (dkCloudItem2 != null) {
                    linkedList.add((DkCloudAnnotation) dkCloudAnnotation.merge(dkCloudItem2));
                } else {
                    linkedList.add(dkCloudAnnotation);
                }
            }
            linkedList.addAll(linkedList2);
            return new DkCloudReadingInfo(this.mInfoId, this.mBookName, this.mIsDuokanBook, getCloudVersion() >= dkCloudItem.getCloudVersion() ? getCloudVersion() : dkCloudItem.getCloudVersion(), this.mDeviceId, this.mBookRevision, this.mKernelVersion, dkCloudReadingProgress, (DkCloudAnnotation[]) linkedList.toArray(new DkCloudAnnotation[0]));
        }
        throw new AssertionError();
    }

    protected void fillJsonObject(JSONObject jSONObject) {
    }

    protected void fillXmlNode(Node node) {
        a.b(node, "Version", READNIG_INFO_VERSION);
        a.b(node, "BookID", this.mInfoId);
        a.b(node, "DeviceID", this.mDeviceId);
        a.b(node, "BookRevision", this.mBookRevision);
        a.b(node, "KernelVersion", this.mKernelVersion);
        Node d = a.d(node, "ReadingData");
        if (this.mReadingProgress != null) {
            this.mReadingProgress.fillXmlNode(a.d(d, "ReadingDataItem"));
        }
        if (this.mAnnotations != null) {
            for (DkCloudAnnotation fillXmlNode : this.mAnnotations) {
                fillXmlNode.fillXmlNode(a.d(d, "ReadingDataItem"));
            }
        }
    }
}
