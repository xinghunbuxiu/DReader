package com.duokan.reader.domain.cloud;

import android.database.Cursor;
import android.util.Pair;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.domain.bookshelf.C0800c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.json.JSONObject;

public class DkCloudStatisticsInfo extends DkCloudJsonItem {
    static final /* synthetic */ boolean $assertionsDisabled = (!DkCloudStatisticsInfo.class.desiredAssertionStatus());
    private final long mAccountId;
    protected long mLastSyncTime = 0;
    public double mLatestMonthRankingRatio;
    public long mLatestMonthReadingTime;
    protected HashMap<Long, Long> mNewDistribution = new HashMap();
    protected long mNewReadPages = 0;
    protected long mNewReadSeconds = 0;
    protected Pair<Long, C0800c> mOpenedBook = null;
    protected double mRankingRatio = 0.0d;
    protected int[] mReadingTimeDistribution = new int[24];
    protected long mTotalBooks = 0;
    protected long mTotalCompletedBooks = 0;
    protected long mTotalDays = 0;
    protected long mTotalReadingBooks = 0;
    protected long mTotalSeconds = 0;

    protected DkCloudStatisticsInfo(long j) {
        super(0);
        this.mAccountId = j;
    }

    public String getCloudId() {
        return String.valueOf(this.mAccountId);
    }

    protected DkCloudItem merge(DkCloudItem dkCloudItem) {
        DkCloudStatisticsInfo dkCloudStatisticsInfo = (DkCloudStatisticsInfo) dkCloudItem;
        this.mNewReadPages += dkCloudStatisticsInfo.mNewReadPages;
        dkCloudStatisticsInfo.mNewReadPages = 0;
        this.mNewReadSeconds += dkCloudStatisticsInfo.mNewReadSeconds;
        dkCloudStatisticsInfo.mNewReadSeconds = 0;
        this.mNewDistribution = new HashMap();
        return this;
    }

    public void update(C0621a<JSONObject> c0621a) {
        if (c0621a.b == 0) {
            JSONObject jSONObject = (JSONObject) c0621a.f2058a;
            this.mTotalReadingBooks = jSONObject.optLong("read_books");
            this.mTotalSeconds = jSONObject.optLong("total_time");
            this.mTotalCompletedBooks = jSONObject.optLong("finished_books");
            this.mTotalDays = (System.currentTimeMillis() - (jSONObject.optLong("create_time") * 1000)) / 86400000;
            this.mRankingRatio = (((double) jSONObject.optInt("total_rate")) * 1.0d) / 10000.0d;
            this.mLatestMonthReadingTime = jSONObject.optLong("monthly_time", -1);
            this.mLatestMonthRankingRatio = (((double) jSONObject.optInt("monthly_rate", -1)) * 1.0d) / 10000.0d;
            if (this.mLatestMonthReadingTime != -1) {
                this.mReadingTimeDistribution = resolveDistributionJson(jSONObject.optJSONObject("monthly_distribution"));
            } else {
                this.mReadingTimeDistribution = resolveDistributionJson(jSONObject.optJSONObject("total_distribution"));
            }
        }
    }

    public static DkCloudStatisticsInfo makeInfoFromServerData(C0621a<JSONObject> c0621a) {
        DkCloudStatisticsInfo dkCloudStatisticsInfo = new DkCloudStatisticsInfo(-1);
        if (c0621a != null) {
            dkCloudStatisticsInfo.update(c0621a);
        }
        return dkCloudStatisticsInfo;
    }

    public static DkCloudStatisticsInfo makeInfo(Cursor cursor) {
        DkCloudStatisticsInfo dkCloudStatisticsInfo = new DkCloudStatisticsInfo(cursor.getLong(1));
        dkCloudStatisticsInfo.mTotalReadingBooks = cursor.getLong(2);
        dkCloudStatisticsInfo.mTotalSeconds = cursor.getLong(3);
        dkCloudStatisticsInfo.mTotalBooks = cursor.getLong(4);
        dkCloudStatisticsInfo.mTotalCompletedBooks = cursor.getLong(5);
        dkCloudStatisticsInfo.mTotalDays = cursor.getLong(6);
        dkCloudStatisticsInfo.mRankingRatio = cursor.getDouble(7);
        try {
            dkCloudStatisticsInfo.mReadingTimeDistribution = (int[]) new ObjectInputStream(new ByteArrayInputStream(cursor.getBlob(8))).readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dkCloudStatisticsInfo.mNewReadPages = cursor.getLong(9);
        dkCloudStatisticsInfo.mNewReadSeconds = cursor.getLong(10);
        try {
            dkCloudStatisticsInfo.mNewDistribution = (HashMap) new ObjectInputStream(new ByteArrayInputStream(cursor.getBlob(11))).readObject();
        } catch (Exception e2) {
            e2.printStackTrace();
            dkCloudStatisticsInfo.mNewDistribution = new HashMap();
        }
        dkCloudStatisticsInfo.mLastSyncTime = cursor.getLong(12);
        dkCloudStatisticsInfo.mLatestMonthReadingTime = cursor.getLong(13);
        dkCloudStatisticsInfo.mLatestMonthRankingRatio = cursor.getDouble(14);
        return dkCloudStatisticsInfo;
    }

    public long getAccountId() {
        return this.mAccountId;
    }

    public long getTotalReadingBooks() {
        return this.mTotalReadingBooks;
    }

    public long getTotalSeconds() {
        return this.mTotalSeconds;
    }

    public long getTotalBooks() {
        return this.mTotalBooks;
    }

    public long getTotalCompletedBooks() {
        return this.mTotalCompletedBooks;
    }

    public long getTotalDays() {
        return this.mTotalDays;
    }

    public double getRankingRatio() {
        return this.mRankingRatio;
    }

    public long getLatestMonthReadingTime() {
        return this.mLatestMonthReadingTime;
    }

    public double getLatestMonthRankingRatio() {
        return this.mLatestMonthRankingRatio;
    }

    public byte[] getTotalDistributionByte() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(this.mReadingTimeDistribution);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public long getNewReadPages() {
        return this.mNewReadPages;
    }

    public long getNewReadSeconds() {
        return this.mNewReadSeconds;
    }

    public byte[] getNewDistributionByte() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(this.mNewDistribution);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public long getLastSyncTime() {
        return this.mLastSyncTime;
    }

    private static int[] resolveDistributionJson(JSONObject jSONObject) {
        int i = 0;
        if ($assertionsDisabled || jSONObject != null) {
            int[] iArr = new int[24];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = 0;
            }
            if (jSONObject != null) {
                while (i < iArr.length) {
                    iArr[i] = jSONObject.optInt(Integer.toString(i));
                    i++;
                }
            }
            return iArr;
        }
        throw new AssertionError();
    }
}
