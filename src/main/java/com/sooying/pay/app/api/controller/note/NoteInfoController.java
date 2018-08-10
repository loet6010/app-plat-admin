package com.sooying.pay.app.api.controller.note;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.controller.note.dto.NoteInfoDto;
import com.sooying.pay.app.api.model.platform.note.NoteInfo;
import com.sooying.pay.app.api.service.immediately.PassagewayImmediatelyService;
import com.sooying.pay.app.api.service.immediately.enums.RedisCashTypeEnum;
import com.sooying.pay.app.api.service.note.NoteInfoService;
import com.sooying.pay.app.api.util.ResultReturnUtil;

/**
 * 短信明细
 * 
 * @Description NoteInfoController
 * @author liurh
 * @date 2018年6月5日
 */
@Controller
public class NoteInfoController {
    private static Logger logger = LoggerFactory.getLogger(NoteInfoController.class);

    @Resource
    NoteInfoService noteInfoService;
    @Resource
    PassagewayImmediatelyService passagewayImmediatelyService;

    /**
     * 获取短信明细列表
     *
     * @param noteInfoDto
     * @return
     */
    @RequestMapping(value = "/note/getNoteInfoList.json", method = { RequestMethod.GET })
    @ResponseBody
    public String getNoteInfoList(NoteInfoDto noteInfoDto) {
        logger.info("NoteInfoController getNoteInfoList 获取短信明细列表");

        try {
            return noteInfoService.getNoteInfoList(noteInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("NoteInfoController 获取短信明细列表，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("NoteInfoController 获取短信明细列表异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 修改短信明细激活状态
     *
     * @param noteInfoDto
     * @return
     */
    @RequestMapping(value = "/note/modifyNoteInfoStatus.json", method = { RequestMethod.POST })
    @ResponseBody
    public String modifyNoteInfoStatus(NoteInfoDto noteInfoDto) {
        logger.info("NoteInfoController modifyNoteInfoStatus 修改短信明细激活状态");

        try {
            String message;
            NoteInfo noteInfo = noteInfoService.getNoteInfoById(noteInfoDto);

            if (noteInfo != null) {
                noteInfoDto.setPassagewayId(noteInfo.getPassagewayId());
                message = noteInfoService.modifyNoteInfoStatus(noteInfoDto);

                // 刷新通道分级系数数据
                passagewayImmediatelyService.setRedisCash(noteInfo.getPassagewayId(),
                        RedisCashTypeEnum.REDIS_CASH_TYPE_ENUM0.getStatus());
            } else {
                message = ResultReturnUtil.getExceptionString("当前短信明细不存在！");
            }

            return message;
        } catch (IllegalArgumentException e) {
            logger.info("NoteInfoController 修改短信明细激活状态，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("NoteInfoController 修改短信明细激活状态异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 修改短信明细SDK激活状态
     *
     * @param noteInfoDto
     * @return
     */
    @RequestMapping(value = "/note/modifyNoteInfoSdkStatus.json", method = { RequestMethod.POST })
    @ResponseBody
    public String modifyNoteInfoSdkStatus(NoteInfoDto noteInfoDto) {
        logger.info("NoteInfoController modifyNoteInfoSdkStatus 修改短信明细SDK激活状态");

        try {
            String message;
            NoteInfo noteInfo = noteInfoService.getNoteInfoById(noteInfoDto);

            if (noteInfo != null) {
                message = noteInfoService.modifyNoteInfoSdkStatus(noteInfoDto);

                // 刷新通道分级系数数据
                passagewayImmediatelyService.setRedisCash(noteInfo.getPassagewayId(),
                        RedisCashTypeEnum.REDIS_CASH_TYPE_ENUM0.getStatus());
            } else {
                message = ResultReturnUtil.getExceptionString("当前短信明细不存在！");
            }

            return message;
        } catch (IllegalArgumentException e) {
            logger.info("NoteInfoController 修改短信明细SDK激活状态，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("NoteInfoController 修改短信明细SDK激活状态异常：", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }
}
