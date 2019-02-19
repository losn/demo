package com.fxslit.jcs.service;

import java.util.Map;

public interface ExpressReportService {
    Map<String, Object> courierReport(String date, int uid);
    Map<String, Object> returnBack(String date, int uid);
    Map<String, Object> collect(String date, int uid);
    Map<String, Object> send(String date, int uid);
    Map<String, Object> returnArrive(String date, int uid);
    Map<String, Object> inv(String date, int uid);
    Map<String, Object> collectChart(String date, int uid);
    Map<String, Object> sendChart(String date, int uid);
}
