package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.SaishixinwenEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SaishixinwenView;


/**
 * 赛事新闻
 *
 * @author 
 * @email 
 * @date 2024-01-15 09:49:33
 */
public interface SaishixinwenService extends IService<SaishixinwenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SaishixinwenView> selectListView(Wrapper<SaishixinwenEntity> wrapper);
   	
   	SaishixinwenView selectView(@Param("ew") Wrapper<SaishixinwenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SaishixinwenEntity> wrapper);
   	

}

