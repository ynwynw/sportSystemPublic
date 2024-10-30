package com.cl.dao;

import com.cl.entity.SaishishipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SaishishipinView;


/**
 * 赛事视频
 * 
 * @author 
 * @email 
 * @date 2024-01-15 09:49:33
 */
public interface SaishishipinDao extends BaseMapper<SaishishipinEntity> {
	
	List<SaishishipinView> selectListView(@Param("ew") Wrapper<SaishishipinEntity> wrapper);

	List<SaishishipinView> selectListView(Pagination page,@Param("ew") Wrapper<SaishishipinEntity> wrapper);
	
	SaishishipinView selectView(@Param("ew") Wrapper<SaishishipinEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<SaishishipinEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<SaishishipinEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<SaishishipinEntity> wrapper);



}
