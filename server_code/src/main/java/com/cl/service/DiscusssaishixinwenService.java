package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscusssaishixinwenEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusssaishixinwenView;


/**
 * 赛事新闻评论表
 *
 * @author 
 * @email 
 * @date 2024-01-15 09:49:34
 */
public interface DiscusssaishixinwenService extends IService<DiscusssaishixinwenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusssaishixinwenView> selectListView(Wrapper<DiscusssaishixinwenEntity> wrapper);
   	
   	DiscusssaishixinwenView selectView(@Param("ew") Wrapper<DiscusssaishixinwenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusssaishixinwenEntity> wrapper);
   	

}

