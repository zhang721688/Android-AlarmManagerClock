package com.zxn.clock;


import java.io.Serializable;

/**
 */
//@Entity(nameInDb = "printer_tb")
public class LocalPrinter implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id(autoincrement = true)
    public Long id;

    public String printerName;// 打印机名称

    public String departmentNo;// 门店Code
    public String departmentName;//门店名称

    public String operatorNo;// 操作人（登录员工id）

    public String operatorName;// 操作人姓名（登录员工姓名）

    public String ip;// 小票机ip地址

    public int format;// 打印规格(0 58mm ,1 80mm)

    public Integer printCount = 1;// 打印次数

    public int status;// 是否停用（0停用 1启用）

    public long gmtCreated;// 创建时间

    public long gmtModify;// 修改时间


}
