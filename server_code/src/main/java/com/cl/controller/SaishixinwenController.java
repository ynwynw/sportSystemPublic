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

import com.cl.entity.SaishixinwenEntity;
import com.cl.entity.view.SaishixinwenView;

import com.cl.service.SaishixinwenService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 赛事新闻
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-15 09:49:33
 */
@RestController
@RequestMapping("/saishixinwen")
public class SaishixinwenController {
    @Autowired
    private SaishixinwenService saishixinwenService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SaishixinwenEntity saishixinwen,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date faburiqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date faburiqiend,
		HttpServletRequest request){
        EntityWrapper<SaishixinwenEntity> ew = new EntityWrapper<SaishixinwenEntity>();
                if(faburiqistart!=null) ew.ge("faburiqi", faburiqistart);
                if(faburiqiend!=null) ew.le("faburiqi", faburiqiend);

		PageUtils page = saishixinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, saishixinwen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SaishixinwenEntity saishixinwen, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date faburiqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date faburiqiend,
		HttpServletRequest request){
        EntityWrapper<SaishixinwenEntity> ew = new EntityWrapper<SaishixinwenEntity>();
                if(faburiqistart!=null) ew.ge("faburiqi", faburiqistart);
                if(faburiqiend!=null) ew.le("faburiqi", faburiqiend);

		PageUtils page = saishixinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, saishixinwen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SaishixinwenEntity saishixinwen){
       	EntityWrapper<SaishixinwenEntity> ew = new EntityWrapper<SaishixinwenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( saishixinwen, "saishixinwen")); 
        return R.ok().put("data", saishixinwenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SaishixinwenEntity saishixinwen){
        EntityWrapper< SaishixinwenEntity> ew = new EntityWrapper< SaishixinwenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( saishixinwen, "saishixinwen")); 
		SaishixinwenView saishixinwenView =  saishixinwenService.selectView(ew);
		return R.ok("查询赛事新闻成功").put("data", saishixinwenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SaishixinwenEntity saishixinwen = saishixinwenService.selectById(id);
		saishixinwen.setClicknum(saishixinwen.getClicknum()+1);
		saishixinwen.setClicktime(new Date());
		saishixinwenService.updateById(saishixinwen);
        return R.ok().put("data", saishixinwen);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SaishixinwenEntity saishixinwen = saishixinwenService.selectById(id);
		saishixinwen.setClicknum(saishixinwen.getClicknum()+1);
		saishixinwen.setClicktime(new Date());
		saishixinwenService.updateById(saishixinwen);
        return R.ok().put("data", saishixinwen);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        SaishixinwenEntity saishixinwen = saishixinwenService.selectById(id);
        if(type.equals("1")) {
        	saishixinwen.setThumbsupnum(saishixinwen.getThumbsupnum()+1);
        } else {
        	saishixinwen.setCrazilynum(saishixinwen.getCrazilynum()+1);
        }
        saishixinwenService.updateById(saishixinwen);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SaishixinwenEntity saishixinwen, HttpServletRequest request){
    	saishixinwen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(saishixinwen);
        saishixinwenService.insert(saishixinwen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SaishixinwenEntity saishixinwen, HttpServletRequest request){
    	saishixinwen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(saishixinwen);
        saishixinwenService.insert(saishixinwen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SaishixinwenEntity saishixinwen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(saishixinwen);
        saishixinwenService.updateById(saishixinwen);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        saishixinwenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,SaishixinwenEntity saishixinwen, HttpServletRequest request,String pre){
        EntityWrapper<SaishixinwenEntity> ew = new EntityWrapper<SaishixinwenEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = saishixinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, saishixinwen), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,SaishixinwenEntity saishixinwen, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "saishileibie";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "saishixinwen").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<SaishixinwenEntity> saishixinwenList = new ArrayList<SaishixinwenEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                saishixinwenList.addAll(saishixinwenService.selectList(new EntityWrapper<SaishixinwenEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<SaishixinwenEntity> ew = new EntityWrapper<SaishixinwenEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = saishixinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, saishixinwen), params), params));
        List<SaishixinwenEntity> pageList = (List<SaishixinwenEntity>)page.getList();
        if(saishixinwenList.size()<limit) {
            int toAddNum = (limit-saishixinwenList.size())<=pageList.size()?(limit-saishixinwenList.size()):pageList.size();
            for(SaishixinwenEntity o1 : pageList) {
                boolean addFlag = true;
                for(SaishixinwenEntity o2 : saishixinwenList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    saishixinwenList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(saishixinwenList.size()>limit) {
            saishixinwenList = saishixinwenList.subList(0, limit);
        }
        page.setList(saishixinwenList);
        return R.ok().put("data", page);
    }







}
