package com.cl.dao;

import com.cl.entity.SaishixinwenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SaishixinwenView;


/**
 * 赛事新闻
 * 
 * @author 
 * @email 
 * @date 2024-01-15 09:49:33
 */
public interface SaishixinwenDao extends BaseMapper<SaishixinwenEntity> {
	
	List<SaishixinwenView> selectListView(@Param("ew") Wrapper<SaishixinwenEntity> wrapper);

	List<SaishixinwenView> selectListView(Pagination page,@Param("ew") Wrapper<SaishixinwenEntity> wrapper);
	
	SaishixinwenView selectView(@Param("ew") Wrapper<SaishixinwenEntity> wrapper);
	

}
