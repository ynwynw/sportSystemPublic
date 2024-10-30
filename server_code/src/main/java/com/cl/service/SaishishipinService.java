package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.SaishishipinEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SaishishipinView;


/**
 * 赛事视频
 *
 * @author 
 * @email 
 * @date 2024-01-15 09:49:33
 */
public interface SaishishipinService extends IService<SaishishipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SaishishipinView> selectListView(Wrapper<SaishishipinEntity> wrapper);
   	
   	SaishishipinView selectView(@Param("ew") Wrapper<SaishishipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SaishishipinEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<SaishishipinEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<SaishishipinEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<SaishishipinEntity> wrapper);



}

