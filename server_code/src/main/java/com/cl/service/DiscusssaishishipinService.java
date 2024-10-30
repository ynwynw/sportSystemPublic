package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscusssaishishipinEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusssaishishipinView;


/**
 * 赛事视频评论表
 *
 * @author 
 * @email 
 * @date 2024-01-15 09:49:34
 */
public interface DiscusssaishishipinService extends IService<DiscusssaishishipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusssaishishipinView> selectListView(Wrapper<DiscusssaishishipinEntity> wrapper);
   	
   	DiscusssaishishipinView selectView(@Param("ew") Wrapper<DiscusssaishishipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusssaishishipinEntity> wrapper);
   	

}

