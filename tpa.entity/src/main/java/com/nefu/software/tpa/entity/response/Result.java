package com.nefu.software.tpa.entity.response;

import com.nefu.software.tpa.entity.enums.ResultStatus;

/**
 * 结果实现类
 *
 * Created by Super腾 on 2017/1/22.
 */
public class Result {
    private Object object;
    private ResultStatus resultStatus;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }
}
