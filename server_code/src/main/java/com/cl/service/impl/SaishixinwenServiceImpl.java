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


import com.cl.dao.SaishixinwenDao;
import com.cl.entity.SaishixinwenEntity;
import com.cl.service.SaishixinwenService;
import com.cl.entity.view.SaishixinwenView;

@Service("saishixinwenService")
public class SaishixinwenServiceImpl extends ServiceImpl<SaishixinwenDao, SaishixinwenEntity> implements SaishixinwenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SaishixinwenEntity> page = this.selectPage(
                new Query<SaishixinwenEntity>(params).getPage(),
                new EntityWrapper<SaishixinwenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SaishixinwenEntity> wrapper) {
		  Page<SaishixinwenView> page =new Query<SaishixinwenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<SaishixinwenView> selectListView(Wrapper<SaishixinwenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SaishixinwenView selectView(Wrapper<SaishixinwenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
