package taskManager.info;

import taskManager.util.logger;



/**
 *  This class contains getter and setter methods for all values
 *  of all three observers 
 *  
 * @author Bhavin Desai,  Sudeep Abhyankar
 *
 */
public class tabInfo {
	private String currMem, currCPU, physical, cached;
	private String username, status;	
	private String procname, p_username, CPU, memory, description;
	
	
	public tabInfo(){
		if(logger.getDebugVal()==2){
			logger.dump(logger.getDebugVal(), "Inside tabInfo constructor");
		}
	}
	
	public String getCurrMem(){
		return currMem;
	}
	public void setCurrMem(String cm){
		this.currMem =cm;
	}
	public String getCurrCPU(){
		return currCPU;
	}
	public void setCurrCPU(String cpu){
		this.currCPU =cpu;
	}
	public String getPhysical(){
		return physical;
	}
	public String getCached(){
		return cached;
	}
	public void setCached(String cac){
		this.cached =cac;
	}

	public void setPhysical(String phy){
		this.physical =phy;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String uname){
		this.username = uname;
	}
	public String getStatus(){
		return status;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getProcessName(){
		return procname;
	}
	public void setProcessName(String pname){
		this.procname=pname;
	}
	public String getP_username(){
		return p_username;
	}
	public void setP_username(String puname){
		this.p_username=puname;
	}
	public String getCPU(){
		return CPU;
	}
	public void setCPU(String inCPU){
		this.CPU=inCPU;
	}
	public String getMemory(){
		return memory;
	}
	public void setMemory(String inMemory){
		this.memory=inMemory;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String desc){
		this.description=desc;
	}

}
