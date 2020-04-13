package flow.service.impl;

import flow.util.FlowTemplate;
import flow.service.ContractService;
import flow.util.ServiceUtil;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("contractService")
public class ContractServiceImpl extends FlowTemplate implements ContractService {

    @Resource
    private ServiceUtil serviceUtil;

    @Override
    public void deploymentProcessDefinition() {
        //获取流程定义与部署相关Service
        Deployment deployment = serviceUtil.getRepositoryService()
                .createDeployment()     //创建一个部署对象
                .name("合同流程")
                .addClasspathResource("diagrams/contractflow.bpmn")//加载资源文件
                .deploy();//完成部署
        System.out.println(deployment.getId());
        System.out.println(deployment.getName());
    }

    @Override
    public void startProcessInstance() {
        //获取与正在执行的流程示例和执行对象相关的Service
        ProcessInstance processInstance = serviceUtil.getRuntimeService()
                //使用流程定义的key启动实例，key对应bpmn文件中id的属性值，默认按照最新版本流程启动
                .startProcessInstanceByKey("contractflow");
        System.out.println(processInstance.getId());
        System.out.println(processInstance.getProcessDefinitionId());
    }

    @Override
    public void findPersonalTask() {
        //与正在执行的任务相关的Service
        List<Task> list = serviceUtil.getTaskService()
                .createTaskQuery()  //创建查询任务对象
                .taskAssignee("wanghe")     //指定个人任务查询，指定办理人
                .list();
        if(list != null && list.size() > 0){
            for(Task task : list){
                System.out.println(task.getId());
                System.out.println(task.getName());
                System.out.println(task.getCreateTime());
                System.out.println(task.getAssignee());
                System.out.println(task.getProcessInstanceId());
                System.out.println(task.getExecutionId());
                System.out.println(task.getProcessDefinitionId());
            }
        }
    }

    @Override
    public void completePersonalTask() {
        String taskId="10009";
        serviceUtil.getTaskService().complete(taskId);
    }

    /**
     * 设置流程变量
     */
    private void setTaskValue(){
        String processInstanceId="10006";
        String taskId="12502";
        serviceUtil.getRuntimeService().setVariable(processInstanceId,"流程合同名称","学生校园卡合同");
        serviceUtil.getRuntimeService().setVariable(processInstanceId,"合同申请人","张三");
        serviceUtil.getTaskService().setVariable(taskId,"当前任务执行人","李四");
    }

    @Override
    public void initFlow() {
//        deploymentProcessDefinition();
//        startProcessInstance();
//        findPersonalTask();
//         completePersonalTask();
        setTaskValue();
    }
}
