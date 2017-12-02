package com.duokan.reader.common.webservices.duokan;

public enum RankingType {
    HOT("0"),
    HIGH_COMMENT("100"),
    MONTH("10"),
    FREE("1"),
    UPDATE("1002"),
    DANGDANG("230"),
    AMAZON("210"),
    JINGDONG("220"),
    DOUBAN("200"),
    NEW("1001"),
    BOY("1501"),
    GIRL("1502"),
    XUANHUAN("2001"),
    WUXIA("2002"),
    CITY("2003"),
    LOVE("2004"),
    RANK_FINISHED_ALL("1034"),
    RANK_PROGRESSIVE("1005");
    
    private String mTypeIndex;

    public String value() {
        return this.mTypeIndex;
    }

    private RankingType(String str) {
        this.mTypeIndex = str;
    }
}
