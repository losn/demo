package com.fxslit.jcs.service;

import com.fxslit.jcs.controller.model.*;

import java.util.List;
import java.util.Map;

public interface ExpressOrderService {
    Map<String, Object> onlineConfirm(Map<String, List<Integer>> model, int uid);
    Map<String, Object> onlineAdd(ExpressInsertModel model, int uid);
    Map<String, Object> getByExpressInfoByQRCode(String qrcode);

}
