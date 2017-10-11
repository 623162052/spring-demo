package com.jdbc.dao;

import com.jdbc.domain.CfgCode;

import java.util.List;

public interface CfgCodeDao {

    int getCfgCodeCount();

    List<CfgCode> getCfgCodeList();

}
