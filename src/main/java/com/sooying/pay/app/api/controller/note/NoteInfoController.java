package com.sooying.pay.app.api.controller.note;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sooying.pay.app.api.controller.note.dto.NoteInfoDto;
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

    /**
     * 获取短信明细列表
     *
     * @param request
     * @param noteInfoDto
     * @return
     */
    @RequestMapping(value = "/note/getNoteInfoList.json", method = { RequestMethod.GET })
    @ResponseBody
    public String getNoteInfoList(HttpServletRequest request, NoteInfoDto noteInfoDto) {
        logger.info("NoteInfoController 获取电信明细列表，通道ID：{}", noteInfoDto.getPassagewayId());

        try {
            return noteInfoService.getNoteInfoList(noteInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("NoteInfoController 获取短信明细列表，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("NoteInfoController 获取电信明细列表异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }

    /**
     * 修改短信明细激活状态
     *
     * @param request
     * @param noteInfoDto
     * @return
     */
    @RequestMapping(value = "/note/modifyNoteInfoStatus.json", method = { RequestMethod.POST })
    @ResponseBody
    public String modifyNoteInfoStatus(HttpServletRequest request, NoteInfoDto noteInfoDto) {
        logger.info("NoteInfoController 修改短信明细激活状态，主键ID：{}", noteInfoDto.getId());

        try {
            return noteInfoService.modifyNoteInfoStatus(noteInfoDto);
        } catch (IllegalArgumentException e) {
            logger.info("NoteInfoController 修改短信明细激活状态，参数验证错误：{}", e.getMessage());

            return ResultReturnUtil.getExceptionString(e.getMessage());
        } catch (Exception e) {
            logger.info("NoteInfoController 修改短信明细激活状态异常：{}", e);

            return ResultReturnUtil.getExceptionString(e.getMessage());
        }
    }
}
