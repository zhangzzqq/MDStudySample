package com.zq.administrator.mdapplication.enumstudy;

import android.util.Log;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Created by steven on 2018/5/26.
 *
 *  用法
 *   ResType resType=ResType.findByChinaName(resName);
 *   String NodeType = resType.getResTypeName();
 *   String searchJson=resType.toString();
 */
public enum ResType {
    /* 位置点 */
    /**
     * {@code 102 PositionPointEquiproom in Space}
     * <p>
     * 空间资源 - 含机房位置点
     */
    PositionPointEquiproom(10200, "PositionPointEquiproom", "PositionPointEquiproom", "含机房位置点"),

    /**
     * {@code 102 PositionPointEquiproom in Space}
     * <p>
     * 空间资源 - 室外传输位置点
     */
    PositionPointTranso(10201, "PositionPointTranso", "PositionPointTranso", "室外传输位置点"),

    /**
     * {@code 102 PositionPointEquiproom in Space}
     * <p>
     * 空间资源 - 室外无线位置点
     */
    PositionPointWireless(10202, "PositionPointWireless", "PositionPointWireless", "室外无线位置点"),

    /**
     * {@code 102 PositionPointEquiproom in Space}
     * <p>
     * 空间资源 - 室外WLAN热点
     */
    PositionPointWlan(10203, "PositionPointWlan", "PositionPointWlan", "室外WLAN热点"),


    /* 空间资源 */
    /**
     * {@code 102 PositionPoint in Space}
     * <p>
     * 空间资源 - 位置点
     */
    PositionPoint(102, "PositionPoint", "PositionPoint", "位置点"),
    ClusterPoint(000, "ClusterPoint", "ClusterPoint", "聚合点"),
    /**
     * {@code 103 EquipRoom in Space}
     * <p>
     * 空间资源 - 机房
     */
    EquipRoom(103, "EquipRoom", "EquipRoom", "机房"),
    /**
     * {@code 104 RackPosition in Space}
     * <p>
     * 空间资源 - 机架位置
     */
    RackPosition(104, "RackPosition", "RackPosition", "机架位置"),
    /**
     * {@code 105 FiberPort of ODM in Space}
     * <p>
     * 空间资源 - ODM端子
     */
    ODMFiberPort(105, "FiberPort", "ODMFiberPort", "ODM端子"),
    /**
     * {@code 106 ODM in Space}
     * <p>
     * 空间资源 - ODM
     */
    ODM(106, "ODM", "ODM", "ODM"),
    /**
     * {@code 107 ODF in Space}
     * <p>
     * 空间资源 - ODF
     */
    ODF(107, "ODF", "ODF", "ODF"),

    /* 传输外线 */
    /**
     * {@code 201 StructWell in TRANSO}
     * <p>
     * 传输外线 - 人手井
     */
    StructWell(201, "StructWell", "StructWell", "人手井"),
    /**
     * {@code 202 StructPole in TRANSO}
     * <p>
     * 传输外线 - 电杆
     */
    StructPole(202, "StructPole", "StructPole", "电杆"),
    /**
     * {@code 203 StructStone in TRANSO}
     * <p>
     * 传输外线 - 标石
     */
    StructStone(203, "StructStone", "StructStone", "标石"),
    /**
     * {@code 204 TranBox in TRANSO}
     * <p>
     * 传输外线 - 光交接箱
     */
    TranBox(204, "TranBox", "TranBox", "光交接箱"),
    /**
     * {@code 205 LayingSegment in TRANSO}
     * <p>
     * 传输外线 - 敷设段
     */
    LayingSegment(205, "LayingSegment", "LayingSegment", "敷设段"),
    /**
     * {@code 206 TubeHole in TRANSO}
     * <p>
     * 传输外线 - 管孔
     */
    TubeHole(206, "TubeHole", "TubeHole", "管孔"),
    /**
     * {@code 207 CableSegment in TRANSO}
     * <p>
     * 传输外线 - 光缆段
     */
    CableSegment(207, "CableSegment", "CableSegment", "光缆段"),
    /**
     * {@code 208 Fiber in TRANSO}
     * <p>
     * 传输外线 - 纤芯
     */
    Fiber(208, "Fiber", "Fiber", "纤芯"),
    /**
     * {@code 209 FiberLink in TRANSO}
     * <p>
     * 传输外线 - 局向光纤
     */
    FiberLink(209, "FiberLink", "FiberLink", "局向纤芯"),
    /**
     * {@code 210 OpticCircuit in TRANSO}
     * <p>
     * 传输外线 - 光路
     */
    OpticCircuit(210, "OpticCircuit", "OpticCircuit", "光路"),
    /**
     * {@code 211 FiberPort of TranBox in TRANSO}
     * <p>
     * 传输外线 - 光交接箱端子
     */
    TranBoxFiberPort(211, "FiberPort", "TranBoxFiberPort", "光交接箱端子"),
    /**
     * {@code 212 SupportPoint in TRANSO}
     * <p>
     * 传输外线 - 撑点
     */
    SupportPoint(212, "SupportPoint", "SupportPoint", "撑点"),
    /**
     * {@code 213 JointBox in TRANSO}
     * <p>
     * 传输外线 - 光分纤接续点（接头盒）
     */
    JointBox(213, "JointBox", "JointBox", "光接头盒"),
    /**
     * {@code 214 CableLink in TRANSO}
     * <p>
     * 传输外线 - 局向光纤
     */
    CableLink(214, "CableLink", "CableLink", "局向光缆"),
    /**
     * {@code 215 RoutingSegment in TRANSO}
     * <p>
     * 传输外线 - 路由段
     */
    RoutingSegment(215, "RoutingSegment", "RoutingSegment", "路由段"),
    /**
     * {@code 217 OpticCircuitRoute in TRANSO}
     * <p>
     * 传输外线 - 光路路由
     */
    OpticCircuitRoute(217, "OpticCircuitRoute", "OpticCircuitRoute", "光路路由"),

    /* 有线接入网 */
    /**
     * {@code 1603 Splitter in WiredAccess}
     * <p>
     * 有线接入网 - 分光器
     */
    Splitter(1603, "Splitter", "Splitter", "分光器"),
    /**
     * {@code 1604 FiberPort of Splitter in WiredAccess}
     * <p>
     * 有线接入网 - 分光器端子
     */
    SplitterFiberPort(1604, "FiberPort", "SplitterFiberPort", "分光器端子"),
    /**
     * {@code 1605 FiberBox in WiredAccess}
     * <p>
     * 有线接入网 - 光分纤箱
     */
    FiberBox(1605, "FiberBox", "FiberBox", "光分纤箱"),
    /**
     * {@code 1607 MediaBox in WiredAccess}
     * <p>
     * 有线接入网 - 多媒体箱
     */
    MediaBox(1607, "MediaBox", "MediaBox", "多媒体箱"),
    /**
     * {@code 1611 FiberPort of FiberBox in WiredAccess}
     * <p>
     * 有线接入网 - 光分纤箱端子
     */
    FiberBoxFiberPort(1611, "FiberPort", "FiberBoxFiberPort", "光分纤箱端子"),
    /**
     * {@code 1612 TerminalBox in WiredAccess}
     * <p>
     * 有线接入网 - 光终端盒
     */
    TerminalBox(1612, "TerminalBox", "TerminalBox", "光终端盒"),
    /**
     * {@code 1613 FiberPort of TerminalBox in WiredAccess}
     * <p>
     * 有线接入网 - 光终端盒端子
     */
    TerminalBoxFiberPort(1613, "FiberPort", "TerminalBoxFiberPort", "光终端盒端子"),

    BTS(402, "BTS", "BTS", "基站"),
    Station(403, "Station", "Station", "小区"),
    RRU(405, "RRU", "RRU", "RRU"),
    Tower(409, "Tower", "Tower", "铁塔"),

    OTN(301, "OTN", "OTN", "OTN"),
    WDM(302, "WDM", "WDM", "WDM"),
    PTN(303, "PTN", "PTN", "PTN"),
    SDH(304, "SDH", "SDH", "SDH"),
    /**
     * 板卡
     */
    EquipBoard(305, "EquipBoard", "EquipBoard", "EquipBoard"),
    /**
     * 端口
     */
    EquipPort(306, "EquipPort", "EquipPort", "EquipPort"),
    /**
     * 端口连接
     */
    EquipPortLink(307, "EquipPortLink", "EquipPortLink", "EquipPortLink"),
    /**
     * 波分复用段
     */
    OMS(313, "OMS", "OMS", "OMS"),
    /**
     * 波道
     */
    OTU(311, "OTU", "OTU", "OTU"),
    /**
     * 传输子网
     */
    TRANSISystem(315, "TRANSISystem", "TRANSISystem", "TRANSISystem"),
    /**
     * 传输内线  U位
     */
    UNIT(9901, "Unit", "Unit", "Unit"),
    SLOT(9902, "SLOT", "SLOT", "SLOT"),
    ERROR(999, "ERROR", "ERROR", "ERROR");


    private static final DecimalFormat formatter = new DecimalFormat("0000");
    private static final DecimalFormat formatter1 = new DecimalFormat("000000");
    private final int value;
    private final String name;
    private final String configName;
    private final String chinaName;

    ResType(int value, String name, String configName, String chinaName) {
        this.value = value;
        this.name = name;
        this.configName = configName;
        this.chinaName = chinaName;
    }

    /**
     * 根据整型值获取资源类别枚举值
     */
    public static ResType valueOf(int value) {
        for (ResType type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + formatter.format(value) + "]");
    }

    /**
     * 根据资源类别名称获取资源类别枚举值
     */
    public static ResType findByName(String name) {
        for (ResType type : values()) {
            if(type.name.equals(name)){
                return type;
            }

//            if (Objects.equals(type.name, name)) {
//                return type;
//            }
        }
        throw new IllegalArgumentException("No matching constant for [" + name + "]");
    }

    /**
     * 根据资源类别中文名称获取资源类别枚举值
     */
    public static ResType findByChinaName(String chinaName) {
        for (ResType type : ResType.values()) {

            if (Objects.equals(type.chinaName, chinaName)) {
                Log.w("ResType===","value=="+type.value+"chineseName=="+type.chinaName);
                return type;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + chinaName + "]");
    }

    /**
     * 根据资源标识获取资源类别枚举值
     */
    public static ResType parse(String resID) {
        String strResult ="";
        if(resID.length()<10){
            strResult = resID.substring(6, resID.length());
        }else {
            strResult = resID.substring(6, 10);
        }
        if(isNumeric(strResult)){
            return valueOf(Integer.valueOf(strResult));
        }
        return ResType.valueOf(000);

    }

    /**
     * 获取资源类别的整型值
     */
    public int value() {
        return this.value;
    }

    /**
     * 获取资源专业的整型值
     */
    public ResClass getResClass() {
        return ResClass.valueOf(this);
    }

    /**
     * 获取资源专业的英文名称
     */
    public String getResClassName() {
        return ResClass.valueOf(this).getResClassName();
    }

    /**
     * 获取资源类别的英文名称
     */
    public String getResTypeName() {
        return this.name;
    }

    /**
     * 获取资源类别的英文配置名称
     */
    public String getResTypeConfigName() {
        return this.configName;
    }

    /**
     * 获取资源类别的英文配置名称
     */
    public String getResTypeChinaName() {
        return this.chinaName;
    }

    /**
     * 判断是否是空间专业资源
     */
    public boolean isSpaceField() {
        return ResClass.Space.equals(getResClass());
    }

    /**
     * 判断是否是传输外线专业资源
     */
    public boolean isTRANSOField() {
        return ResClass.TRANSO.equals(getResClass());
    }

    /**
     * 判断是否是有线接入网专业资源
     */
    public boolean isWiredField() {
        return ResClass.WiredAccess.equals(getResClass());
    }

    /**
     * 获取资源类别的四位字符串值
     */
    @Override
    public String toString() {
        if(value<9999){
            return formatter.format(value);
        } else {
            return formatter1.format(value);
        }
    }

    /**
     * 资源专业的枚举类
     */
    public enum ResClass {
        Space(102, "Space"),
        TRANSO(2, "TRANSO"),
        WiredAccess(16, "WiredAccess");

        private static final DecimalFormat formatter = new DecimalFormat("00");
        private final int value;
        private final String resClassName;

        ResClass(int value, String resClassName) {
            this.value = value;
            this.resClassName = resClassName;
        }

        /**
         * 根据资源类别整型值获取资源专业枚举值
         */
        public static ResClass valueOf(int resTypeValue) {
            int seriesCode = resTypeValue / 100;
            for (ResClass resClass : values()) {
                if (resClass.value == seriesCode) {
                    return resClass;
                }
            }
            throw new IllegalArgumentException("No matching constant for [" + formatter.format(resTypeValue) + "]");
        }

        /**
         * 根据资源类别枚举值获取资源专业枚举值
         */
        public static ResClass valueOf(ResType resType) {
            return valueOf(resType.value);
        }

        /**
         * 获取资源专业的整型值
         */
        public int value() {
            return this.value;
        }

        /**
         * 获取资源专业的英文名称
         */
        public String getResClassName() {
            return this.resClassName;
        }
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }



}

