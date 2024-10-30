package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.SaishileibieEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SaishileibieView;


/**
 * 赛事类别
 *
 * @author 
 * @email 
 * @date 2024-01-15 09:49:33
 */
public interface SaishileibieService extends IService<SaishileibieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SaishileibieView> selectListView(Wrapper<SaishileibieEntity> wrapper);
   	
   	SaishileibieView selectView(@Param("ew") Wrapper<SaishileibieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SaishileibieEntity> wrapper);
   	

}

