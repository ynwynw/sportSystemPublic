package com.cl.dao;

import com.cl.entity.SaishileibieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SaishileibieView;


/**
 * 赛事类别
 * 
 * @author 
 * @email 
 * @date 2024-01-15 09:49:33
 */
public interface SaishileibieDao extends BaseMapper<SaishileibieEntity> {
	
	List<SaishileibieView> selectListView(@Param("ew") Wrapper<SaishileibieEntity> wrapper);

	List<SaishileibieView> selectListView(Pagination page,@Param("ew") Wrapper<SaishileibieEntity> wrapper);
	
	SaishileibieView selectView(@Param("ew") Wrapper<SaishileibieEntity> wrapper);
	

}
