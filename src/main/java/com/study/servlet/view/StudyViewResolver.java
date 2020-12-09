package com.study.servlet.view;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudyViewResolver {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String REDIRECT_URL_PREFIX = "redirect:";
	
	private String prefix = "";
	private String suffix = "";

	/**
	 * 뷰의 이름을 기반으로 적절한 View 객체를 리턴한다. <br>
	 * 
	 * @param req
	 * @param viewName
	 * @return View
	 */
	public View resolveViewName(HttpServletRequest req, String viewName) {
		View view = null;
		
    // viewName이 Null 인 경우 viewName 을 현재 요청 URI 기준으로 한다.
		if (viewName == null) {
			viewName = RequestToViewNameTranslator.getViewName(req);
		}

		if (viewName.equals("jsonView")) {
			view = new JsonView();
		} else if (viewName.startsWith(StudyViewResolver.REDIRECT_URL_PREFIX)) {
			view = new RedirectView(viewName.substring(StudyViewResolver.REDIRECT_URL_PREFIX.length()));
		} else {
			view = new JstlView(viewName, this.prefix, this.suffix);
		}
		logger.debug("요청=[{}], viewName=[{}] 의 뷰결정 [{}]" 
				           , req.getRequestURI(), viewName , view.getClass().getName());
		return view;
	}

  //  맴버변수 get/set 생성 (단, setter 는 Method Chaining 으로 구성 )
	
	public String getPrefix() {
		return prefix;
	}

	public StudyViewResolver setPrefix(String prefix) {
		this.prefix = prefix;
		return this;
	}

	public String getSuffix() {
		return suffix;
	}

	public StudyViewResolver setSuffix(String suffix) {
		this.suffix = suffix;
		return this;
	}
	
  
	
	
	
}
