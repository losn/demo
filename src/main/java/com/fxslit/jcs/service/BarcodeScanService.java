package com.fxslit.jcs.service;

import com.fxslit.jcs.controller.model.ExpressBarcodeScanModel;

import java.util.Map;

public interface BarcodeScanService {
    Map<String, Object> invScan(ExpressBarcodeScanModel model, int uid);
}
