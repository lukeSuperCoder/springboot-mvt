package com.test.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
public class MVTReq implements Serializable {
    private static final long serialVersionUID = 1656087792952781046L;
    private Integer x;
    private Integer y;
    private Integer z;

    @NotEmpty
    private String typeId;

    private List<String> typeIds;

    private List<String> areaCodes;


    private Integer level;
    private String geom;

    private String serviceTypeId;



    private String tile;
    private String  bbox;
    private String pcode;
    private String tb;

}
