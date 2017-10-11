package com.jdbc.dao.impl;

import com.jdbc.dao.CfgCodeDao;
import com.jdbc.domain.CfgCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CfgCodeDaoImpl implements CfgCodeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper<CfgCode> cfgCodeMapper() {
        return new RowMapper<CfgCode>() {

            public CfgCode mapRow(ResultSet rs, int rowNum) throws SQLException {
                CfgCode cfgCode = new CfgCode();
                cfgCode.setTenantId(rs.getString("tenant_id"));
                cfgCode.setProvCode(rs.getString("prov_code"));
                cfgCode.setCodeTypeCd(rs.getString("code_type_cd"));
                cfgCode.setCodeNm(rs.getString("code_nm"));
                return cfgCode;
            }
        };
    }

    @Override
    public int getCfgCodeCount() {
        return jdbcTemplate.queryForObject(" select count(*) from t_sr_cfg_code ", Integer.class);
    }

    @Override
    public List<CfgCode> getCfgCodeList() {
        return jdbcTemplate.query(" select * from t_sr_cfg_code ", cfgCodeMapper());
    }

}
