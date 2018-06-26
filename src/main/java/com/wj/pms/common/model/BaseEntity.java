package com.wj.pms.common.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 已包含逻辑主键id, 数据插入时间和数据生成时间
 * <p>
 * Created by YoungSmith on 2018/7/15.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BaseEntity<T extends BaseEntity> implements Comparable<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createTime;
    private Date updateTime;
    private Boolean deleted;

    public BaseEntity() {
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }

    public String computeObjectPath() {
        return String.format("/%s/%d", this.getClass().getSimpleName(), id);
    }

    public Date getCreateTime() {
        return createTime;
    }

    public T setCreateTime(Date createTime) {
        this.createTime = createTime;
        return (T) this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public T setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return (T) this;
    }

    public Long getId() {
        return id;
    }

    public T setId(Long id) {
        this.id = id;
        return (T) this;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public T setDeleted(Boolean deleted) {
        this.deleted = deleted;
        return (T) this;
    }

    public String computeMainUri() {
        String[] componentArray = this.getClass().getName().split("\\.");
        String baseName = componentArray[componentArray.length - 1];
        return new StringBuilder("/").append(baseName).append("/").append(this.id != null ? this.id : 0L).toString();
    }

    protected String computeOtherUriList() {
        return "";
    }

    public String computeUriList() {
        StringBuilder sb = new StringBuilder(computeMainUri());
        String otherUriList = computeOtherUriList();
        if (!otherUriList.isEmpty()) {
            sb.append(otherUriList);
        }
        return sb.toString();
    }

    @Override
    public int compareTo(T o) {
        return getId().compareTo(o.getId());
    }
}

