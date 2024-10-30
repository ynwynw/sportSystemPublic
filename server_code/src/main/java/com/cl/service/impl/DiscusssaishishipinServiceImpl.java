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


import com.cl.dao.DiscusssaishishipinDao;
import com.cl.entity.DiscusssaishishipinEntity;
import com.cl.service.DiscusssaishishipinService;
import com.cl.entity.view.DiscusssaishishipinView;

@Service("discusssaishishipinService")
public class DiscusssaishishipinServiceImpl extends ServiceImpl<DiscusssaishishipinDao, DiscusssaishishipinEntity> implements DiscusssaishishipinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusssaishishipinEntity> page = this.selectPage(
                new Query<DiscusssaishishipinEntity>(params).getPage(),
                new EntityWrapper<DiscusssaishishipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusssaishishipinEntity> wrapper) {
		  Page<DiscusssaishishipinView> page =new Query<DiscusssaishishipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscusssaishishipinView> selectListView(Wrapper<DiscusssaishishipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusssaishishipinView selectView(Wrapper<DiscusssaishishipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
