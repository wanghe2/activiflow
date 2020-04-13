package flow.util;

import flow.bean.InitBean;
import org.activiti.engine.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ServiceUtil {

    @Resource
    private InitBean initBean;

    /**
     * 管理流程定义，仓库服务类
     * @return
     */
    public RepositoryService getRepositoryService(){
        return initBean.getProcessEngine().getRepositoryService();
    }

    /**
     * 执行管理，包括启动、推进、删除流程实例等
     * @return
     */
    public RuntimeService getRuntimeService(){
        return  initBean.getProcessEngine().getRuntimeService();
    }

    /**
     * 任务管理
     * @return
     */
    public TaskService getTaskService(){
        return  initBean.getProcessEngine().getTaskService();
    }

    /**
     * 历史管理（执行完的数据的管理)
     * @return
     */
    public HistoryService getHistoryService(){
        return  initBean.getProcessEngine().getHistoryService();
    }

    /**
     * 组织机构管理
     * @return
     */
    public IdentityService getIdentityService(){
        return initBean.getProcessEngine().getIdentityService();
    }
    /**
     * 可选服务，任务表单管理
     * @return
     */
    public FormService getFormService(){
        return  initBean.getProcessEngine().getFormService();
    }

    /**
     * 管理
     * @return
     */
    public ManagementService getManagementService(){
        return  initBean.getProcessEngine().getManagementService();
    }

}
