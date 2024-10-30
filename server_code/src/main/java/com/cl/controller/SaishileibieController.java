package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.SaishileibieEntity;
import com.cl.entity.view.SaishileibieView;

import com.cl.service.SaishileibieService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 赛事类别
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-15 09:49:33
 */
@RestController
@RequestMapping("/saishileibie")
public class SaishileibieController {
    @Autowired
    private SaishileibieService saishileibieService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SaishileibieEntity saishileibie,
		HttpServletRequest request){
        EntityWrapper<SaishileibieEntity> ew = new EntityWrapper<SaishileibieEntity>();

		PageUtils page = saishileibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, saishileibie), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SaishileibieEntity saishileibie, 
		HttpServletRequest request){
        EntityWrapper<SaishileibieEntity> ew = new EntityWrapper<SaishileibieEntity>();

		PageUtils page = saishileibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, saishileibie), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SaishileibieEntity saishileibie){
       	EntityWrapper<SaishileibieEntity> ew = new EntityWrapper<SaishileibieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( saishileibie, "saishileibie")); 
        return R.ok().put("data", saishileibieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SaishileibieEntity saishileibie){
        EntityWrapper< SaishileibieEntity> ew = new EntityWrapper< SaishileibieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( saishileibie, "saishileibie")); 
		SaishileibieView saishileibieView =  saishileibieService.selectView(ew);
		return R.ok("查询赛事类别成功").put("data", saishileibieView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SaishileibieEntity saishileibie = saishileibieService.selectById(id);
        return R.ok().put("data", saishileibie);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SaishileibieEntity saishileibie = saishileibieService.selectById(id);
        return R.ok().put("data", saishileibie);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SaishileibieEntity saishileibie, HttpServletRequest request){
    	saishileibie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(saishileibie);
        saishileibieService.insert(saishileibie);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SaishileibieEntity saishileibie, HttpServletRequest request){
    	saishileibie.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(saishileibie);
        saishileibieService.insert(saishileibie);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SaishileibieEntity saishileibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(saishileibie);
        saishileibieService.updateById(saishileibie);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        saishileibieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
