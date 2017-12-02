package com.duokan.reader.common.webservices.duokan;

public class DkStoreBookTocInfo extends DkStoreItemInfo {
    private String childLine = null;
    public DkStoreBookTocInfo[] mChildToc = new DkStoreBookTocInfo[0];
    public String mPreview = null;
    public String mTitle = null;

    public String getChilidLine() {
        if (this.childLine == null && this.mChildToc != null && this.mChildToc.length > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (DkStoreBookTocInfo dkStoreBookTocInfo : this.mChildToc) {
                stringBuffer.append(dkStoreBookTocInfo.mTitle).append("\r\n");
            }
            this.childLine = stringBuffer.toString();
        }
        return this.childLine;
    }
}
