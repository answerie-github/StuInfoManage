package com.xsyu.enums;

public enum StuStateEnums {
    SUCCESS(1, "在校"),
    ERROR(-1, "不在校"),
    NULL_STUID(-999, "stuId is null!"),
    NULL_STU(-1000,"stuInfo is null!");

    private int state;
    private String stateInfo;

    StuStateEnums(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static StuStateEnums stateOf(int state) {
        for (StuStateEnums stuStateEnums : values()) {
            if (stuStateEnums.getState() == state) {
                return stuStateEnums;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
