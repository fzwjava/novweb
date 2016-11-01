package cn.com.siemens.novel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.siemens.novel.bean.ChapterDetails;
import cn.com.siemens.novel.bean.Novel;
import cn.com.siemens.novel.service.NovelService;

@Controller
public class NovelController {

	@Autowired
	NovelService novelService;

	@RequestMapping(method = RequestMethod.GET, value = "/ca")
	public String ca(Model model, @RequestParam(required = true) String id) {
		Novel n = novelService.getNovelById(id);
		model.addAttribute("nv", n);
		return "novel";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/info")
	@ResponseBody
	public ChapterDetails info( @RequestParam(required = true) String id,@RequestParam(required = true) String ca,@RequestParam(required = true) String author) {
		return novelService.getInfo(id, ca, author);
	}

}
