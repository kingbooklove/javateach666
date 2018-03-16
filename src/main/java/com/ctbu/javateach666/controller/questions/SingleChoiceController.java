package com.ctbu.javateach666.controller.questions;

import java.awt.Choice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// @RequestMapping("/single")
public class SingleChoiceController {
	
	
	@RequestMapping("/choice")
	public String Choice() {
		return "questions/choice";
	}
	
	@ResponseBody
	@RequestMapping("/listc")
	public String listSingleChoice() {
		String json = "{\"total\":136,\"rows\":[{\"answer\":\"C\",\"answera\":\"通过网络盗取他人密码只是思想意识问题\",\"answerb\":\"色情、暴力网站不会对青少年产生负面影响\",\"answerc\":\"恶意制造网络病毒属于计算机犯罪\",\"answerd\":\"沉迷于网络游戏不会影响青少年的身心健康\",\"available\":\"1\",\"choiceId\":1,\"choiceTitle\":\"下列说法正确的是（  ）。\",\"choiceType\":0,\"courseId\":1,\"daytime\":\"2017-11-15\"},{\"answer\":\"C\",\"answera\":\"共享性\",\"answerb\":\"时效性 \",\"answerc\":\"真伪性\",\"answerd\":\"价值相对性\",\"available\":\"1\",\"choiceId\":2,\"choiceTitle\":\"“华南虎”事件是人为制造的假新闻，这说明信息具有（  ）。\",\"choiceType\":0,\"courseId\":1,\"daytime\":\"2017-11-15\"},{\"answer\":\"A\",\"answera\":\"ABC①.def \",\"answerb\":\"ABC？.exe\",\"answerc\":\"ABC*.com\",\"answerd\":\"ABC/.pdf\",\"available\":\"1\",\"choiceId\":3,\"choiceTitle\":\"如果作为Windows中的文件名，合法的是（  ）。\",\"choiceType\":0,\"courseId\":1,\"daytime\":\"2017-11-15\"},{\"answer\":\"B\",\"answera\":\"位 \",\"answerb\":\"字节\",\"answerc\":\"机器字\",\"answerd\":\"字长\",\"available\":\"1\",\"choiceId\":4,\"choiceTitle\":\"计算机存储器单位Byte称为\",\"choiceType\":0,\"courseId\":1,\"daytime\":\"2017-11-15\"},{\"answer\":\"B\",\"answera\":\"英文的编码\",\"answerb\":\"英文的编码\",\"answerc\":\"通用字符的编码\",\"answerd\":\"通用字符的编码\",\"available\":\"1\",\"choiceId\":5,\"choiceTitle\":\"计算机系统中使用的GB2312-80编码是一种\",\"choiceType\":0,\"courseId\":1,\"daytime\":\"2017-11-15\"},{\"answer\":\"A\",\"answera\":\"Windows\",\"answerb\":\"Office\",\"answerc\":\"Internet Explorer\",\"answerd\":\"PhotoShop\",\"available\":\"1\",\"choiceId\":6,\"choiceTitle\":\"下面属于操作系统软件的是\",\"choiceType\":0,\"courseId\":1,\"daytime\":\"2017-11-15\"},{\"answer\":\"A\",\"answera\":\"协议\",\"answerb\":\"拓扑结构　\",\"answerc\":\"模型\",\"answerd\":\"体系结构\",\"available\":\"1\",\"choiceId\":7,\"choiceTitle\":\"为网络信息交换而制定的规则称为\",\"choiceType\":0,\"courseId\":1,\"daytime\":\"2017-11-15\"},{\"answer\":\"B\",\"answera\":\"工作站\",\"answerb\":\"服务器\",\"answerc\":\"外围设备\",\"answerd\":\"通信协议\",\"available\":\"1\",\"choiceId\":8,\"choiceTitle\":\"（　）是为网络中各用户提供服务并管理整个网络的，是整个网络的核心。\",\"choiceType\":0,\"courseId\":1,\"daytime\":\"2017-11-15\"},{\"answer\":\"D\",\"answera\":\"主机和外部设备\",\"answerb\":\"主机、显示器、键盘、鼠标\",\"answerc\":\"运控器、存储器、外部设备\",\"answerd\":\"硬件系统和软件系统\",\"available\":\"1\",\"choiceId\":9,\"choiceTitle\":\"计算机系统是指\",\"choiceType\":0,\"courseId\":2,\"daytime\":\"2017-11-15\"},{\"answer\":\"D\",\"answera\":\"主机、键盘和显示器\",\"answerb\":\"系统软件与应用软件\",\"answerc\":\"运算器、控制器和存储器\",\"answerd\":\"硬件系统与软件系统\",\"available\":\"1\",\"choiceId\":10,\"choiceTitle\":\"一个完整的计算机系统包括（  ）。\",\"choiceType\":0,\"courseId\":2,\"daytime\":\"2017-11-15\"}]}";
		return json;
	}
	
	
}
