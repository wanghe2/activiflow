package flow.controller;

import flow.service.ContractService;
import flow.util.ServiceUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FlowController {

    @Resource
    private ContractService contractService;

    @RequestMapping("flowInit")
    public String flowInit(){
        contractService.initFlow();
        return "good";
    }

}
