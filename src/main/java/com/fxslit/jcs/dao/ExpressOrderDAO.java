package com.fxslit.jcs.dao;

import com.fxslit.jcs.entity.ExpressOrder;
import org.apache.ibatis.annotations.Param;

public interface ExpressOrderDAO{
    int insert(ExpressOrder obj);
    int delete(@Param("id") int id);
    int update(Object obj);
    ExpressOrder get(@Param("id") int id);
    int confirm(ExpressOrder expressOrder);
}
