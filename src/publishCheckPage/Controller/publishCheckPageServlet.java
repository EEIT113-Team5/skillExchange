package publishCheckPage.Controller;

import java.sql.SQLException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import publishCheckPage.Model.PublishBean;
import publishCheckPage.Service.iPublishService;


@Controller
public class publishCheckPageServlet {
	
	@Autowired
	iPublishService ips;
	
	@PostMapping(value = "/publishCheckPage")
	public String publishCheckPage(
			@SessionAttribute("publishbean") PublishBean pb,
			Model model
			) throws SQLException, ParseException {
		
		ips.insertPublish(pb);
		
		return "publish/PublishFinishPage";
	}
	
}

