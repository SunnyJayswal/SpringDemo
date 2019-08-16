package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.RegDAO;
import com.vo.RegVO;
import com.vo.RegfVO;
import com.vo.loginVO;

import java.util.List;

//import org.omg.CORBA.portable.ValueOutputStream;

@Controller
public class RegController
	{
        	
    	@Autowired RegDAO regDAO;
    	
    	@RequestMapping(value="loadinsert.html",method=RequestMethod.GET)
    	public ModelAndView loadInsert()
    		{
    			return new ModelAndView("insert","data",new RegVO());
    		}
    	
    	@RequestMapping(value="reginsert.html",method=RequestMethod.POST)
    	public ModelAndView dataInsert(@ModelAttribute RegVO regVO)
    		{	
    			this.regDAO.insert(regVO);
    			return new ModelAndView("redirect:loadinsert.html");
    		}
    	
 
    	
    	@RequestMapping(value="loadsearch.html",method=RequestMethod.GET)
    	public ModelAndView search(@ModelAttribute RegVO regVO)
    	{
    		List ls=this.regDAO.search(regVO);
    		return new ModelAndView("search","list",ls);
    	}
   
    	
    	@RequestMapping(value="editentry.html",method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") int id,@ModelAttribute RegVO regVO)
	{
    		regVO.setId(id);
    		List ls=this.regDAO.edit(regVO);
    		return new ModelAndView("edit","list",ls.get(0));
    		
	}
    	
    	@RequestMapping(value="/updateentry.html",method=RequestMethod.POST)
    	public ModelAndView update(@ModelAttribute RegVO regVO)
    	{
        		this.regDAO.update(regVO);
        	
        		return new ModelAndView("redirect:loadsearch.html");
    	}
    	
    	@RequestMapping(value="/deleteentry.html",method=RequestMethod.GET)
    	public ModelAndView delete(@ModelAttribute RegVO regVO)
    	{
    		this.regDAO.delete(regVO);
    		return new ModelAndView("redirect:loadsearch.html");
    	}
    	
    	
    	@RequestMapping(value="loadinsertf.html",method=RequestMethod.GET)
    	public ModelAndView load()
    	{
    		return new ModelAndView("insertf","data",new RegfVO()); 
    	}
    	
    	@RequestMapping(value="start.html",method=RequestMethod.POST)
        public ModelAndView insertf(@ModelAttribute RegfVO regvo)
        {
    		
    		
    		loginVO vo=new loginVO();
    		vo.setUsername(regvo.getVo().getUsername());
    		vo.setPassword(regvo.getVo().getPassword());
    		this.regDAO.insertlvalue(vo);
    		
    		regvo.setVo(vo);
    		this.regDAO.insertvalue(regvo);
    		
    		return new ModelAndView("redirect:loadinsertf.html");
        }
    	
}