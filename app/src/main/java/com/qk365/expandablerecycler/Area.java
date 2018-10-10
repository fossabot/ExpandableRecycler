package com.qk365.expandablerecycler;

import java.util.List;

public class Area {

    private String ceaName;
    private Object cerAddress;
    private int ceaId;
    private int parentId;
    private String ceaCode;
    private int ceaAreaType;
    private List<Area> areaList;

    public String getCeaName() {
        return ceaName;
    }

    public void setCeaName(String ceaName) {
        this.ceaName = ceaName;
    }

    public Object getCerAddress() {
        return cerAddress;
    }

    public void setCerAddress(Object cerAddress) {
        this.cerAddress = cerAddress;
    }

    public int getCeaId() {
        return ceaId;
    }

    public void setCeaId(int ceaId) {
        this.ceaId = ceaId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getCeaCode() {
        return ceaCode;
    }

    public void setCeaCode(String ceaCode) {
        this.ceaCode = ceaCode;
    }

    public int getCeaAreaType() {
        return ceaAreaType;
    }

    public void setCeaAreaType(int ceaAreaType) {
        this.ceaAreaType = ceaAreaType;
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }
}
