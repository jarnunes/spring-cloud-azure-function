package com.jnunes.springcloud.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {


    @CreatedBy
    private transient String createUser;


    @LastModifiedBy
    private transient String modifyUser;


    @CreatedDate
    private transient LocalDateTime createDate;


    @LastModifiedDate
    private transient LocalDateTime modifyDate;

    @PrePersist
    protected void prePersist(){
        if(this.createDate == null)
            createDate = LocalDateTime.now();

    }

    @PreUpdate
    protected  void preUpdate(){
        modifyDate = LocalDateTime.now();
    }
}
