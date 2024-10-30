package com.cl.dao;

import com.cl.entity.GuanggaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GuanggaoxinxiView;


/**
 * 广告信息
 * 
 * @author 
 * @email 
 * @date 2024-01-15 09:49:33
 */
public interface GuanggaoxinxiDao extends BaseMapper<GuanggaoxinxiEntity> {
	
	List<GuanggaoxinxiView> selectListView(@Param("ew") Wrapper<GuanggaoxinxiEntity> wrapper);

	List<GuanggaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<GuanggaoxinxiEntity> wrapper);
	
	GuanggaoxinxiView selectView(@Param("ew") Wrapper<GuanggaoxinxiEntity> wrapper);
	

}
