package com.voole.cdcenter.service.system.function.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.voole.cdcenter.entry.sytem.function.FunctionEntry;
import com.voole.cdcenter.mapper.system.function.IFunctionMapper;
import com.voole.cdcenter.mapper.system.function.IRuleFunctionMapper;
import com.voole.cdcenter.service.system.function.IFunctionService;
import com.voole.cdcenter.util.ListUtils;
import com.voole.cdcenter.vo.system.function.FunctionVo;
import com.voole.cdcenter.vo.system.function.RuleFunctionVo;

/**
 * @ClassName: IFunctionServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年7月7日 下午2:38:10
 * 
 */
@Service
public class FunctionServiceImpl implements IFunctionService {
    @Resource
    private IFunctionMapper functionMapper;
    @Resource
    private IRuleFunctionMapper ruleFunctionMapper;

    /*
     * (非 Javadoc) <p>Title: queryFunction</p> <p>Description: </p>
     * 
     * @param functionquerycase
     * 
     * @return
     * 
     * @see
     * com.voole.cdcenter.service.system.function.IFunctionService#queryFunction(com.voole.cdcenter.vo.system.function.
     * FunctionVo)
     */
    @Override
    public List<FunctionVo> queryMenuFunction(FunctionVo functionquerycase) {
        RuleFunctionVo ruleFunctionquerycase = new RuleFunctionVo();
        ruleFunctionquerycase.setRids(functionquerycase.getRids());
        ruleFunctionquerycase.setIs_on(functionquerycase.getIs_on());
        List<RuleFunctionVo> ruleFunctionVos = this.ruleFunctionMapper.queryRuleFunction(ruleFunctionquerycase);
        if (null != ruleFunctionVos) {
            Integer[] fids = ListUtils.getTargetForIntegerArray(ruleFunctionVos, "fid");
            functionquerycase.setFids(fids);
            functionquerycase.setIs_on(functionquerycase.getIs_on());
            // 获取一级菜单
            functionquerycase.setMenu_type(1);
            List<FunctionVo> funcs_1 = this.queryFunction(functionquerycase);
            if (null != funcs_1) {
                for (FunctionVo functionVo : funcs_1) {
                    FunctionVo functionquerycase_2 = new FunctionVo();
                    functionquerycase_2.setFids(fids);
                    functionquerycase_2.setMenu_type(2);
                    functionquerycase_2.setPfid(functionVo.getFid());
                    functionquerycase_2.setIs_on(functionquerycase.getIs_on());
                    // 获取二级菜单
                    List<FunctionVo> funcs_2 = this.queryFunction(functionquerycase_2);
                    if (null != funcs_2) {
                        for (FunctionVo functionVo2 : funcs_2) {
                            FunctionVo functionquerycase_3 = new FunctionVo();
                            functionquerycase_3.setFids(fids);
                            functionquerycase_3.setMenu_type(3);
                            functionquerycase_3.setPfid(functionVo2.getFid());
                            functionquerycase_3.setIs_on(functionquerycase.getIs_on());
                            // 获取三级菜单
                            List<FunctionVo> funcs_3 = this.queryFunction(functionquerycase_3);
                            functionVo2.setChildFuncs(funcs_3);
                        }
                    }
                    functionVo.setChildFuncs(funcs_2);
                }
            }
            return funcs_1;
        }
        return new ArrayList<>();
    }

    /*
     * (非 Javadoc) <p>Title: queryFunction</p> <p>Description: </p>
     * 
     * @param functionquerycase
     * 
     * @return
     * 
     * @see
     * com.voole.cdcenter.service.system.function.IFunctionService#queryFunction(com.voole.cdcenter.vo.system.function.
     * FunctionVo)
     */
    @Override
    public List<FunctionVo> queryFunction(FunctionVo functionquerycase) {
        // 根据角色id查找连接id集合
        RuleFunctionVo ruleFunctionquerycase = new RuleFunctionVo();
        ruleFunctionquerycase.setRids(functionquerycase.getRids());
        ruleFunctionquerycase.setIs_on(functionquerycase.getIs_on());
        List<RuleFunctionVo> ruleFunctionVos = this.ruleFunctionMapper.queryRuleFunction(ruleFunctionquerycase);
        if (null != ruleFunctionVos) {
            // 根据链接id集合查找可用的连接集合
            Integer[] fids = ListUtils.getTargetForIntegerArray(ruleFunctionVos, "fid");
            functionquerycase.setFids(fids);
            functionquerycase.setIs_on(functionquerycase.getIs_on());
            return this.functionMapper.queryFunctions(functionquerycase);
        }
        return new ArrayList<>();
    }

    /*
     * (非 Javadoc) <p>Title: insertFunction</p> <p>Description: </p>
     * 
     * @param entry
     * 
     * @return
     * 
     * @see com.voole.cdcenter.service.system.function.IFunctionService#insertFunction(com.voole.cdcenter.entry.sytem.
     * function.FunctionEntry)
     */
    @Override
    public Integer insertFunction(FunctionEntry entry) {
        Integer flag = this.functionMapper.insertFunction(entry);
        if (flag > 0) {
            return entry.getFid();
        }
        return 0;
    }

    /*
     * (非 Javadoc) <p>Title: deleteFunction</p> <p>Description: </p>
     * 
     * @param entry
     * 
     * @return
     * 
     * @see com.voole.cdcenter.service.system.function.IFunctionService#deleteFunction(com.voole.cdcenter.entry.sytem.
     * function.FunctionEntry)
     */
    @Override
    public boolean deleteFunction(FunctionEntry entry) {
        return this.functionMapper.deleteFunction(entry) > 0;
    }

    /*
     * (非 Javadoc) <p>Title: updateFunction</p> <p>Description: </p>
     * 
     * @param entry
     * 
     * @return
     * 
     * @see com.voole.cdcenter.service.system.function.IFunctionService#updateFunction(com.voole.cdcenter.entry.sytem.
     * function.FunctionEntry)
     */
    @Override
    public boolean updateFunction(FunctionEntry entry) {
        return this.functionMapper.updateFunction(entry) > 0;
    }

}
