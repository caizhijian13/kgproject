package com.dhu.kgproject.controller;

import com.dhu.kgproject.domain.Node;
import com.dhu.kgproject.services.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class NodeController {
    @Autowired
    private NodeService nodeService;

    @GetMapping("/node")
    @ResponseBody
    public Node findByName(@RequestParam(value = "id",required = false) Long id){
        return nodeService.selectNodeById(id);
    }

    @RequestMapping("/nodes")
    @ResponseBody
    public Collection<Node> findNodesByNameLike(@RequestParam String name){
        return nodeService.findNodesByNameLike(name);
    }

    @GetMapping("/graph")
    @ResponseBody
    public Map<String,Object> graph(@RequestParam(value = "id",required = false) Long id){
        return nodeService.graph(id);
    }

    @GetMapping("/selectgraph")
    @ResponseBody
    public Map<String,Object> selectgraph(@RequestParam(value = "name",required = false) String name){
        return nodeService.selectgraph(name);
    }

    @GetMapping("/selectgraphById")
    @ResponseBody
    public Map<String,Object> selectgraphById(@RequestParam(value = "id",required = false)Long id){
        return nodeService.selectgraphById(id);
    }

    @RequestMapping("/searchById")
    public ModelAndView showspecificResult(@RequestParam( value = "detailId")  Long detailId, Model model){
        System.out.println(detailId);
        Node node = nodeService.selectNodeById(detailId);
        model.addAttribute("name",node.getName());
        model.addAttribute("node",node);
        model.addAttribute("id",node.getId());
        return new ModelAndView("show_result", "model", model);
    }

    @RequestMapping("/search")
    public ModelAndView showResult(@RequestParam( value = "search_name") String search_name, Model model){
//        String namelike = "%"+search_name+"%";
        Collection<Node> nodes= nodeService.findNodesByNameLike(search_name);
        //Collection<Node> nodelist = nodeService.findByName(search_name);
        if (!nodes.isEmpty()){
            model.addAttribute("name",search_name);
            model.addAttribute("infolist",nodes);
            if(nodes.size() == 1) {
                Node node = nodes.iterator().next();
                model.addAttribute("node",node );
                model.addAttribute("id",node.getId());
                return new ModelAndView("show_result", "model", model);
            }
            else{
                model.addAttribute("nodelist", nodes);
                return new ModelAndView("index2","model",model);
            }
        }
        else{
            return new ModelAndView("error","model",model);
        }

    }
    @RequestMapping("/search_detail")
    public ModelAndView showDetail(@RequestParam(value = "detailId") Long detailId,Model model){
        Node node = nodeService.selectNodeById(detailId);
        String name = node.getName();
        model.addAttribute("name",name);
        Map<String, String> labelList = new HashMap<>();
        Collection<Node> nodeList = nodeService.selectRelatedNodes(detailId);
        model.addAttribute("node",node);
        model.addAttribute("nodeList",nodeList);
        return new ModelAndView("show_detail","model",model);
    }
//    @RequestParam(value = "search_name") String search_name, Model model){
//        Node node = nodeService.findByName(search_name);
//        String nodeName = node.getName();
//        model.addAttribute("node",node);
//        model.addAttribute("name",nodeName);
//        model.addAttribute("searchName",search_name);
//        return  new ModelAndView("show_result","model",model);
//    }

    @GetMapping("/findKidsById")
    @ResponseBody
    public Integer findKidsById(@RequestParam(value = "id",required = false)Long id){
        return nodeService.numOfKids(id);
    }

    @RequestMapping(value = "/show_result")
    public String toBackshowall(){
        return "show_result";
    }

    @RequestMapping(value = "/show_detail")
    public String toBackshowDetail(){
        return "show_detail";
    }

    @RequestMapping(value = "/error_result")
    public String toError(){
        return "error";
    }

    @RequestMapping(value = "/standards")
    public String toStandards(){
        return "standards";
    }

    @RequestMapping(value = "/iec62264-0")
    public String toIec62264_0(){
        return "iec62264";
    }

    @RequestMapping(value = "/iec62264-1")
    public String toIec62264_1(){
        return "iec62264_1";
    }

    @RequestMapping(value = "/iec62264-2")
    public String toIec62264_2(){
        return "iec62264_2";
    }

    @RequestMapping(value = "/iec62264-3")
    public String toIec62264_3(){
        return "iec62264_3";
    }

    @RequestMapping(value = "/iec62264-4")
    public String toIec62264_4(){
        return "iec62264_4";
    }

    @RequestMapping(value = "/iec62264-5")
    public String toIec62264_5(){
        return "iec62264_5";
    }

    @RequestMapping(value = "/iec62453-0")
    public String toIec62453_0(){
        return "iec62453_0";
    }

    @RequestMapping(value = "iec61158-0")
    public String toIec61158_0(){
        return "iec61158_0";
    }

    @RequestMapping(value = "iec62443-0")
    public String toIec62443_0(){
        return "iec62443_0";
    }

    @RequestMapping(value = "/back_addnode1")
    public String toBackAddnode1(){
        return "back_addnode1";
    }

    @RequestMapping(value = "/index")
    public String toIndex(){
        return "index";
    }
}
