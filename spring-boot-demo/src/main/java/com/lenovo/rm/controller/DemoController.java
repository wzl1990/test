package com.lenovo.rm.controller;


import com.lenovo.rm.entity.Demo;
import com.lenovo.rm.page.PageBean;
import com.lenovo.rm.page.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/admin/demo")
public class DemoController {
	private static List<Demo> list=null;

	static{
		//Page<User1> page = PageHelper.startPage(1,1);
		list=new ArrayList<Demo>();
		for(int i=0;i<15;i++){
			Demo demo=new Demo();
			demo.setPassword(Integer.toString(i));
			demo.setName("weizl"+i);
			demo.setId(i);
			demo.setEmail("weizl2@lenovo.com");
			list.add(demo);
		}
	}

	@RequestMapping(value="/isRegistered")
	@ResponseBody
	public boolean  isRegistered(String name) throws InterruptedException{
		Thread.sleep(3000);
		if("wzlwzl".equals(name)){
			return true;
		}else{
			return false;
		}
	}
	

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getIndexPage() {
		return "test";
	}
	
	@RequestMapping(value="/index")
	public String demo(){
		return "demo";
	}

	@RequestMapping(value="/getList")
	@ResponseBody
	public List<Demo> getList(){
		return  list;
	}
	
	@RequestMapping(value="/create")
	@ResponseBody
	public String  create(Demo demo){
		System.out.println(demo);
		return  "AAAAAAAAA";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public String  update(Demo demo){
		System.out.println(demo);
		return  "AAAAAAAAA";
	}
	
	
	@RequestMapping(value="/getById")
	@ResponseBody
	public Demo  getById(Integer id){
		Demo d=null;
		for(Demo demo:list){
			if(demo.getId()==id){
				d=demo;
				break;
			}
		}
		return d;
	}
	
	@RequestMapping(value="/getAllByPage")
	@ResponseBody
	public Pagination<Demo> getList(PageBean page){
		List<Demo> list=new ArrayList<Demo>();
		System.out.println("aaaaaaaaaaaffffffeeeeaaaaaaaaaaaaaaaaaa");
		for(int i=0;i<123;i++){
			Demo demo=new Demo();
			demo.setPassword(Integer.toString(i));
			demo.setName("weizl"+i);
			demo.setId(i);
			demo.setEmail("weizl2@lenovo.com");
			list.add(demo);
		}
		Pagination<Demo> pagination=new Pagination<Demo>(list, page.getPageSize(), page.getCurrentPage());
		return  pagination;
	}

}
