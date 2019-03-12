package org.seckill.controller;

import org.seckill.dto.Exposer;
import org.seckill.entity.Seckill;
import org.seckill.service.SeckillService;
import org.seckill.util.ResultUtil;
import org.seckill.util.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/seckill")
public class SeckillController {
    @Autowired
    private SeckillService seckillService;

    @GetMapping("/list")
    public String getSeckills(Model model) {
        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/{seckillId}/detail")
    public String getSeckillDetail(Model model, @PathVariable("seckillId")long id){
        Seckill seckill = seckillService.getById(id);
        model.addAttribute("seckill",seckill);
        return "detail";
    }

    @GetMapping("/time/now")
    @ResponseBody
    public Result<Long> time(){
        Date now = new Date();
        return ResultUtil.success(now);
    }

    @GetMapping("/{seckillId}/exposer")
    @ResponseBody
    public Result<Exposer> exportSeckillUrl(@PathVariable long seckillId){
        Exposer e = seckillService.exportSeckillUrl(seckillId);
        return ResultUtil.success(e);
    }

    @PostMapping("/{seckillId}/{md5}/execution")
    @ResponseBody
    public Result execution(@PathVariable long seckillId,@PathVariable String md5,@CookieValue("killPhone") long killPhone){
        Result r = seckillService.executeSeckill(seckillId,killPhone,md5);
        return r;
    }
}
