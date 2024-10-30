package com.cl.dao;

import com.cl.entity.DiscusssaishixinwenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusssaishixinwenView;


/**
 * 赛事新闻评论表
 * 
 * @author 
 * @email 
 * @date 2024-01-15 09:49:34
 */
public interface DiscusssaishixinwenDao extends BaseMapper<DiscusssaishixinwenEntity> {
	
	List<DiscusssaishixinwenView> selectListView(@Param("ew") Wrapper<DiscusssaishixinwenEntity> wrapper);

	List<DiscusssaishixinwenView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusssaishixinwenEntity> wrapper);
	
	DiscusssaishixinwenView selectView(@Param("ew") Wrapper<DiscusssaishixinwenEntity> wrapper);
	

}
