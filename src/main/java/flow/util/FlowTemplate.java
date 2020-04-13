package flow.util;

public abstract class FlowTemplate {

    /**
     * 1.部署流程定义
     */
    public abstract void deploymentProcessDefinition();

    /**
     * 2.启动流程实例
     */
    public abstract void startProcessInstance();

    /**
     * 3.查询当前的个人任务
     */
    public abstract void findPersonalTask();

    /**
     * 4.完成个人任务
     */
    public abstract void completePersonalTask();

    public void doFLow(){
        deploymentProcessDefinition();
        startProcessInstance();
        findPersonalTask();
        completePersonalTask();
    }
}
