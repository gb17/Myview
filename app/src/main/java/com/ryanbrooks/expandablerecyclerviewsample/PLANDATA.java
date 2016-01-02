package com.ryanbrooks.expandablerecyclerviewsample;

import com.orm.SugarRecord;

/**
 * Created by ${GB} on 1/2/16.
 */
public class PLANDATA extends SugarRecord {


    String PLANDATE;
    String BU;
    String TERRITORY_CODE;
    String TRCODE;
    String PATCHCODE;
    String PATCHNAME;
    String SYNCFLAG;
    String PCODE;
    String PNAME;
    String PTYPE;
    String SPCLCODE;
    String SPCLNAME;
    String CLASSCODE;
    String CLASSNAME;
    String NCACODE;
    String NCATYPE;
    String LEAVECODE;
    String LEAVE;

    public PLANDATA() {
    }

    public PLANDATA(String PLANDATE, String BU, String TERRITORY_CODE, String TRCODE, String PATCHCODE, String PATCHNAME, String SYNCFLAG, String PCODE, String PNAME, String PTYPE, String SPCLCODE, String SPCLNAME, String CLASSCODE, String CLASSNAME, String NCACODE, String NCATYPE, String LEAVECODE, String LEAVE) {
        this.PLANDATE = PLANDATE;
        this.BU = BU;
        this.TERRITORY_CODE = TERRITORY_CODE;
        this.TRCODE = TRCODE;
        this.PATCHCODE = PATCHCODE;
        this.PATCHNAME = PATCHNAME;
        this.SYNCFLAG = SYNCFLAG;
        this.PCODE = PCODE;
        this.PNAME = PNAME;
        this.PTYPE = PTYPE;
        this.SPCLCODE = SPCLCODE;
        this.SPCLNAME = SPCLNAME;
        this.CLASSCODE = CLASSCODE;
        this.CLASSNAME = CLASSNAME;
        this.NCACODE = NCACODE;
        this.NCATYPE = NCATYPE;
        this.LEAVECODE = LEAVECODE;
        this.LEAVE = LEAVE;
    }


}
