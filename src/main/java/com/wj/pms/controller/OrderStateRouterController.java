package com.wj.pms.controller;

import com.wj.pms.common.Result;
import com.wj.pms.mybatis.entity.OrderStateRouter;
import com.wj.pms.mybatis.mapper.OrderStateRouterMapper;
import com.wj.pms.mybatis.mapper.self.PmsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-7-28 上午7:27
 */
@RestController
@RequestMapping("/api/stateRouter")
public class OrderStateRouterController {

    @Autowired
    private OrderStateRouterMapper orderStateRouterMapper;

    @Autowired
    private PmsDao pmsDao;

    @PostMapping
    @ResponseBody
    public Result insertOrUpdate(@RequestBody OrderStateRouter router){
        if(StringUtils.isEmpty(router.getId())){
            orderStateRouterMapper.insert(router);
        } else {
            orderStateRouterMapper.updateByPrimaryKey(router);
        }
        return Result.success();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Result delete(@PathVariable String id){
        orderStateRouterMapper.deleteByPrimaryKey(id);
        return Result.success();
    }

    @GetMapping
    @ResponseBody
    public Result getState(){
        return Result.success(orderStateRouterMapper.selectAll());
    }

//    @GetMapping("/{id}")
//    @ResponseBody
//    public Result getState(@PathVariable Integer id){
//        return Result.success(orderStateRouterMapper.selectByPrimaryKey(id));
//    }

    @GetMapping("/{stateName}")
    @ResponseBody
    public Result getState(@PathVariable String stateName){
        return Result.success(pmsDao.selectOrderStateRouterByStateName(stateName));
    }
}
