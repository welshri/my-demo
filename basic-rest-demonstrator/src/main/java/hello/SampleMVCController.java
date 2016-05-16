package hello;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleMVCController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        //This would be a service call in a real solution
        model.addAttribute("rating", this.getRating(name));
        return "greeting";
    }

    /** 
     * Mimic some complex logic. Pretend to be a service call.
     * @param name
     * @return
     */
	private String getRating(String name) {
		if (StringUtils.isEmpty(name)) {
			return "HOLD";
		} else if (name.length() > 3 ) {
			return "BUY";
		} else {
			return "SELL";
		}
	}
	


}