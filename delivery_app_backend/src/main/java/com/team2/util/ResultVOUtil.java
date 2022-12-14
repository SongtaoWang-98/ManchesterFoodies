package com.team2.util;

import com.team2.vo.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO fail(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(1);
        resultVO.setMsg("fail");
        resultVO.setData(data);
        return resultVO;
    }
}
