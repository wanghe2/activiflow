package flow.bean;


import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component
public class InitBean implements InitializingBean {

    @Resource
    private StandaloneProcessEngineConfiguration flowEngineConfiguration;

    private ProcessEngine processEngine=null;

    @Override
    public void afterPropertiesSet() throws Exception {
        //创建工作流核心对象
        processEngine = flowEngineConfiguration.buildProcessEngine();
        System.out.println(processEngine);
    }

    public ProcessEngine getProcessEngine() {
        return processEngine;
    }
}
