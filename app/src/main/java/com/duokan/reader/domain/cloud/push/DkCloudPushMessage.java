package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.common.webservices.duokan.DkCloudMessageInfo;
import com.duokan.reader.domain.cloud.DkCloudItem;
import com.duokan.reader.domain.cloud.DkCloudJsonItem;
import java.util.Date;
import org.json.JSONObject;

public class DkCloudPushMessage extends DkCloudJsonItem {
    private static final long MESSAGE_VERSION = 0;
    private static final long serialVersionUID = 1;
    private ActionType mActionType;
    private final DkCloudMessageInfo mMessageInfo;
    private final String mMiServerMsgId;
    private Date mReceivedDate = new Date();
    private boolean mReportMiServer;

    public enum ActionType {
        PROMPT,
        BOOK_DETAIL,
        BOOK_TOPIC,
        FICTION_DETAIL,
        FICTION_TOPIC,
        URL
    }

    public DkCloudPushMessage(String str, boolean z, DkCloudMessageInfo dkCloudMessageInfo) {
        super(0);
        this.mMiServerMsgId = str;
        this.mReportMiServer = z;
        this.mMessageInfo = dkCloudMessageInfo;
        try {
            JSONObject jSONObject = new JSONObject(this.mMessageInfo.mActionParams);
            if (jSONObject.has("book_id")) {
                this.mActionType = ActionType.BOOK_DETAIL;
            } else if (jSONObject.has("book_topic_id")) {
                this.mActionType = ActionType.BOOK_TOPIC;
            } else if (jSONObject.has("fiction_id")) {
                this.mActionType = ActionType.FICTION_DETAIL;
            } else if (jSONObject.has("fiction_topic_id")) {
                this.mActionType = ActionType.FICTION_TOPIC;
            } else if (jSONObject.has("url")) {
                this.mActionType = ActionType.URL;
            } else {
                this.mActionType = ActionType.PROMPT;
            }
        } catch (Exception e) {
            this.mActionType = ActionType.PROMPT;
        }
    }

    public Date getReceivedDate() {
        return this.mReceivedDate;
    }

    public String getMessageTitle() {
        return this.mMessageInfo.mTitle;
    }

    public String getMessageContent() {
        return this.mMessageInfo.mMessage;
    }

    public ActionType getMessageType() {
        return this.mActionType;
    }

    public String getActionParamString() {
        return this.mMessageInfo.mActionParams;
    }

    public String getActionUrl() {
        try {
            return new JSONObject(this.mMessageInfo.mActionParams).getString("url");
        } catch (Exception e) {
            return "";
        }
    }

    public long getPublishTime() {
        return this.mMessageInfo.mPublishTime;
    }

    public long getEndTime() {
        return this.mMessageInfo.mEndTime * 1000;
    }

    public boolean getIsDirect() {
        return this.mMessageInfo.mDirect;
    }

    protected boolean getIsReportMiServer() {
        return this.mReportMiServer;
    }

    protected String getMiServerMsgId() {
        return this.mMiServerMsgId;
    }

    protected void markReportMiServer() {
        this.mReportMiServer = true;
    }

    public String getCloudId() {
        return this.mMessageInfo.mMessageId;
    }

    protected DkCloudItem merge(DkCloudItem dkCloudItem) {
        return null;
    }
}
