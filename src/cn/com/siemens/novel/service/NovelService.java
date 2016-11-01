package cn.com.siemens.novel.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import cn.com.siemens.novel.bean.ChapterDetails;
import cn.com.siemens.novel.bean.Novel;
import cn.com.siemens.novel.util.MD5;

@Service
public class NovelService {
	@Autowired 
	MongoTemplate mongoTemplate;
	
	public Novel getNovelById(String id){
		if(StringUtils.isNotBlank(id)){
			return mongoTemplate.findById(id, Novel.class);
		}
		return new Novel();
	}
	
	public ChapterDetails getInfo(String id, String ca, String author){
		if(StringUtils.isNotBlank(id)&&StringUtils.isNotBlank(ca)&&StringUtils.isNotBlank(author)){
			ChapterDetails de = mongoTemplate.findById(MD5.GetMD5Code(id+author+ca), ChapterDetails.class);
			if(de!=null)
				return de;
		}
		
		return new ChapterDetails();
	}

}
