package cn.edu.xiyou.controller;

import cn.edu.xiyou.pojo.Classmate;
import cn.edu.xiyou.service.mateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mate")
public class mateController {
    @Autowired
    @Qualifier("mateServiceImpl")
    private mateService mateService;
    @RequestMapping("allMates")
    public String selectAll(Model model){
        List<Classmate> mates = mateService.selectAll();
        model.addAttribute("mates",mates);
        return "selectAll";
    }
    @RequestMapping("fuzzyQuery")
    public String fuzzyQuery(String queryMates,Model model){
        queryMates="%"+queryMates+"%";
        List<Classmate> mates = mateService.fuzzySelect(queryMates);
        model.addAttribute("mates",mates);
        return "selectAll";
    }
    @RequestMapping("del")
    public String delMate(Integer id){
        mateService.delMate(id);
        return "redirect:/mate/allMates";
    }
    @RequestMapping("toAddPaper")
    public String toAddPaper(){
        return "addMate";
    }
    @RequestMapping("addMate")
    public String addMate(Classmate classmate,Model model){
        mateService.addMate(classmate);
        return "redirect:/mate/allMates";
    }
    @RequestMapping("toUpdatePaper")
    public String toUpdatePaper(Integer id,Model model){
        Classmate classmate = mateService.selectById(id);
        model.addAttribute("mate",classmate);
        return "updateMate";
    }
    @RequestMapping("updateMate")
    public String updateMate(Classmate classmate){
        mateService.updateMate(classmate);
        return "redirect:/mate/allMates";
    }
}
