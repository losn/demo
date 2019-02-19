package com.fxslit.jcs.service.impl;

import com.fxslit.common.BarcodeTool;
import com.fxslit.common.Msg;
import com.fxslit.common.ResultMap;
import com.fxslit.common.util.GetTime;
import com.fxslit.daishu.dao.DaishuSiteDAO;
import com.fxslit.daishu.entity.FormInv;
import com.fxslit.daishu.entity.GoodInv;
import com.fxslit.jcs.controller.model.ExpressBarcodeScanModel;
import com.fxslit.jcs.model.UserInfo;
import com.fxslit.jcs.service.BarcodeScanService;
import com.fxslit.jcs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @program: jcs
 * @description: 条码扫描相关接口
 * @author: Losn
 * @create: 2018-07-12 20:59
 **/
@Service
public class BarcodeScanServiceImpl implements BarcodeScanService{
    @Autowired
    private UserService userService;
    @Autowired
    private DaishuSiteDAO daishuSiteDAO;

    @Override
    public Map<String, Object> invScan(ExpressBarcodeScanModel model, int uid) {
        UserInfo user = userService.getLoginUser(uid);
        if(user == null) {
            return ResultMap.init(1, Msg.AUTH_FAIL.toString());
        }
        String barcode = model.getBarcode();
        if(BarcodeTool.checkFormNum(barcode)) {
            String formNum = barcode;
            FormInv fs = new FormInv();
            fs.setScanSiteName(user.getSiteName());
            fs.setUserName(user.getWorkName());
            fs.setUseDate(GetTime.getDateTime());
            fs.setSiteName(user.getSiteName());
            fs.setFormNum(formNum);
            fs.setScanDate(GetTime.getDateTime());
            fs.setWorkNum(user.getWorkCode());
            fs.setCarNum(user.getWorkCode());
            fs.setScanType("小程序");
            fs.setActions("盘点扫描");
            fs.setScanStatus("入库");
            if (daishuSiteDAO.addFormInv(fs) == 0) {
                return ResultMap.init(1, Msg.DB_ERROR.toString());
            }
        } else if(BarcodeTool.checkGoodNum(barcode)) {
            GoodInv gs = new GoodInv();
            gs.setScanSiteName(user.getSiteName());// 扫描站点
            gs.setUserName(user.getWorkName());// 操作人
            gs.setUseDate(GetTime.getDateTime());// 操作时间
            gs.setSiteName(user.getSiteName());// 操作站点
            gs.setGoodsNum(barcode);// 货物条码
            gs.setFormNum("");// 所属面单号码
            gs.setScanDate(GetTime.getDateTime());// 扫描时间
            gs.setWorkNum(user.getWorkCode());// 扫描员工号
            gs.setCarNum(user.getWorkCode());// 车号
            gs.setScanType("小程序");
            gs.setActions("盘点扫描");// 扫描动作
            gs.setScanStatus("入库");// 状态
            if (daishuSiteDAO.addGoodInv(gs) == 0) {
                return ResultMap.init(1, Msg.DB_ERROR.toString());
            }
        } else {
            return ResultMap.init(1, "条码不正确，请检查");
        }
        return ResultMap.init(0);
    }
}
