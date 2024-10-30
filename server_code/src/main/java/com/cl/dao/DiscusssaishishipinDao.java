package com.cl.dao;

import com.cl.entity.DiscusssaishishipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusssaishishipinView;


/**
 * 赛事视频评论表
 * 
 * @author 
 * @email 
 * @date 2024-01-15 09:49:34
 */
public interface DiscusssaishishipinDao extends BaseMapper<DiscusssaishishipinEntity> {
	
	List<DiscusssaishishipinView> selectListView(@Param("ew") Wrapper<DiscusssaishishipinEntity> wrapper);

	List<DiscusssaishishipinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusssaishishipinEntity> wrapper);
	
	DiscusssaishishipinView selectView(@Param("ew") Wrapper<DiscusssaishishipinEntity> wrapper);
	

}
