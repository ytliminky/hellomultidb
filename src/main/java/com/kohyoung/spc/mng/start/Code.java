package com.kohyoung.spc.mng.start;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;

@Validated
@Entity
@Table(name = "tb_code")
@Getter
@Setter
public class Code implements Serializable {

    private static final long serialVersionUID = 5057388942388599423L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeId;

    @Column(nullable = false, length = 60)
    private String code;

    @Column(nullable = false, length = 60)
    private String parentCode;

    @Column(nullable = false, length = 60)
    private String codeLabel;

    private Float numberValue;

    private String stringValue;

    private String useFlag;

    private String memo;

}