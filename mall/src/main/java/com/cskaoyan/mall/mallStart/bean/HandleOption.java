package com.cskaoyan.mall.mallStart.bean;

public class HandleOption {
    private boolean cancel;
    private boolean comment;
    private boolean confirm;
    private boolean delete;
    private boolean pay;
    private boolean rebuy;
    private boolean refund;

    public boolean getCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public boolean getComment() {
        return comment;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public boolean getConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public boolean getDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean getPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public boolean getRebuy() {
        return rebuy;
    }

    public void setRebuy(boolean rebuy) {
        this.rebuy = rebuy;
    }

    public boolean getRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

}
