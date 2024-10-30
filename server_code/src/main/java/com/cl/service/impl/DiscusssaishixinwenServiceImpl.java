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


import com.cl.dao.DiscusssaishixinwenDao;
import com.cl.entity.DiscusssaishixinwenEntity;
import com.cl.service.DiscusssaishixinwenService;
import com.cl.entity.view.DiscusssaishixinwenView;

@Service("discusssaishixinwenService")
public class DiscusssaishixinwenServiceImpl extends ServiceImpl<DiscusssaishixinwenDao, DiscusssaishixinwenEntity> implements DiscusssaishixinwenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusssaishixinwenEntity> page = this.selectPage(
                new Query<DiscusssaishixinwenEntity>(params).getPage(),
                new EntityWrapper<DiscusssaishixinwenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusssaishixinwenEntity> wrapper) {
		  Page<DiscusssaishixinwenView> page =new Query<DiscusssaishixinwenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscusssaishixinwenView> selectListView(Wrapper<DiscusssaishixinwenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusssaishixinwenView selectView(Wrapper<DiscusssaishixinwenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
