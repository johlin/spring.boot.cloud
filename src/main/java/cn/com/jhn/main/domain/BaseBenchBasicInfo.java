package cn.com.jhn.main.domain;

import java.io.Serializable;
import java.util.Date;

public class BaseBenchBasicInfo
        implements Serializable {
    /**   
	 *   
	 */   
	
	private static final long serialVersionUID = 3301369542817300783L;

	private Integer id;

    private Date createtime;

    private Boolean isvalid;

    private Integer benchtype;

    private Integer benchCode;

    private Integer benchstatus;

    private Long allocationId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Boolean getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Boolean isvalid) {
        this.isvalid = isvalid;
    }

    public Integer getBenchtype() {
        return benchtype;
    }

    public void setBenchtype(Integer benchtype) {
        this.benchtype = benchtype;
    }

    public Integer getBenchCode() {
        return benchCode;
    }

    public void setBenchCode(Integer benchCode) {
        this.benchCode = benchCode;
    }

    public Integer getBenchstatus() {
        return benchstatus;
    }

    public void setBenchstatus(Integer benchstatus) {
        this.benchstatus = benchstatus;
    }

    public Long getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(Long allocationId) {
        this.allocationId = allocationId;
    }
}