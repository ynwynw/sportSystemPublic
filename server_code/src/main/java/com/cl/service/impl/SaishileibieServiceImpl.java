package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.SaishileibieDao;
import com.cl.entity.SaishileibieEntity;
import com.cl.service.SaishileibieService;
import com.cl.entity.view.SaishileibieView;

@Service("saishileibieService")
public class SaishileibieServiceImpl extends ServiceImpl<SaishileibieDao, SaishileibieEntity> implements SaishileibieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SaishileibieEntity> page = this.selectPage(
                new Query<SaishileibieEntity>(params).getPage(),
                new EntityWrapper<SaishileibieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SaishileibieEntity> wrapper) {
		  Page<SaishileibieView> page =new Query<SaishileibieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<SaishileibieView> selectListView(Wrapper<SaishileibieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SaishileibieView selectView(Wrapper<SaishileibieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
