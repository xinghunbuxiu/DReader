package com.duokan.reader.domain.cloud;

import android.text.TextUtils;
import com.duokan.common.C0267i;
import com.duokan.reader.common.webservices.duokan.DkAnnotationBookInfo;
import java.util.Date;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;

public class DkCloudNoteBookInfo extends DkCloudJsonItem {
    static final /* synthetic */ boolean $assertionsDisabled = (!DkCloudNoteBookInfo.class.desiredAssertionStatus());
    private final String mBookFormat;
    private final DkAnnotationBookInfo mBookInfo;
    private String mBookTitle;
    private final boolean mIsDuokanBook;

    public DkCloudNoteBookInfo(DkAnnotationBookInfo dkAnnotationBookInfo, boolean z) {
        super(dkAnnotationBookInfo.mVersion);
        this.mBookInfo = dkAnnotationBookInfo;
        if (z || TextUtils.isEmpty(this.mBookInfo.mBookName)) {
            this.mBookTitle = this.mBookInfo.mBookName;
            this.mBookFormat = "";
        } else {
            this.mBookTitle = C0267i.m607b(this.mBookInfo.mBookName);
            this.mBookFormat = C0267i.m601a(this.mBookInfo.mBookName).toUpperCase();
        }
        this.mIsDuokanBook = z;
    }

    public JSONObject convertToJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_duokan_book", this.mIsDuokanBook);
            jSONObject.put("book_uuid", this.mBookInfo.mBookUuid);
            jSONObject.put(ClientCookie.VERSION_ATTR, this.mBookInfo.mVersion);
            jSONObject.put("update_time", this.mBookInfo.mLastUpdateTime.getTime());
            jSONObject.put("comment_count", this.mBookInfo.mCommentCount);
            jSONObject.put("bookmark_count", this.mBookInfo.mBookmarkCount);
            jSONObject.put("name", this.mBookInfo.mBookName);
            jSONObject.put("author", this.mBookInfo.mAuthor);
            jSONObject.put("editor", this.mBookInfo.mEditor);
            jSONObject.put("cover", this.mBookInfo.mCoverUrl);
            jSONObject.put("is_serial", this.mBookInfo.mSerial);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static DkCloudNoteBookInfo createFromJson(JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("is_duokan_book");
        DkAnnotationBookInfo dkAnnotationBookInfo = new DkAnnotationBookInfo();
        dkAnnotationBookInfo.mBookUuid = jSONObject.optString("book_uuid");
        dkAnnotationBookInfo.mVersion = jSONObject.optLong(ClientCookie.VERSION_ATTR);
        dkAnnotationBookInfo.mLastUpdateTime = new Date(jSONObject.optLong("update_time"));
        dkAnnotationBookInfo.mCommentCount = jSONObject.optInt("comment_count");
        dkAnnotationBookInfo.mBookmarkCount = jSONObject.optInt("bookmark_count");
        dkAnnotationBookInfo.mBookName = jSONObject.optString("name");
        dkAnnotationBookInfo.mAuthor = jSONObject.optString("author");
        dkAnnotationBookInfo.mEditor = jSONObject.optString("editor");
        dkAnnotationBookInfo.mCoverUrl = jSONObject.optString("cover");
        dkAnnotationBookInfo.mSerial = jSONObject.optBoolean("is_serial");
        return new DkCloudNoteBookInfo(dkAnnotationBookInfo, optBoolean);
    }

    public static boolean canCreateFromJson(JSONObject jSONObject) {
        return jSONObject.has("is_duokan_book");
    }

    public String getBookUuid() {
        return this.mBookInfo.mBookUuid;
    }

    public int getNoteCount() {
        return this.mBookInfo.mCommentCount;
    }

    public void setNoteCount(int i) {
        this.mBookInfo.mCommentCount = i;
    }

    public Date getLastDate() {
        return this.mBookInfo.mLastUpdateTime;
    }

    public void setLastDate(Date date) {
        this.mBookInfo.mLastUpdateTime = date;
    }

    public boolean isDuokanBookNote() {
        return this.mIsDuokanBook;
    }

    public boolean isSerial() {
        return this.mBookInfo.mSerial;
    }

    public String getTitle() {
        return this.mBookTitle;
    }

    public void setTitle(String str) {
        this.mBookTitle = str;
    }

    public String getBookName() {
        return this.mBookInfo.mBookName;
    }

    public String getBookFormat() {
        return this.mBookFormat;
    }

    public String getBookAuthor() {
        return this.mBookInfo.mAuthor;
    }

    public void setBookAuthor(String str) {
        this.mBookInfo.mAuthor = str;
    }

    public String getBookEditor() {
        return this.mBookInfo.mEditor;
    }

    public void setBookEditor(String str) {
        this.mBookInfo.mEditor = str;
    }

    public String getBookCoverUrl() {
        return this.mBookInfo.mCoverUrl;
    }

    public void setBookCoverUrl(String str) {
        this.mBookInfo.mCoverUrl = str;
    }

    public String getCloudId() {
        return this.mBookInfo.mBookUuid;
    }

    protected DkCloudItem merge(DkCloudItem dkCloudItem) {
        if ($assertionsDisabled) {
            return null;
        }
        throw new AssertionError();
    }

    protected void fillJsonObject(JSONObject jSONObject) {
    }
}
