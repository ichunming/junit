package mock;

public class LogicEx implements LogicI{
	private ServiceI service = new ServiceEx();

	@Override
	public String getDate() throws Exception{
		return service.selDate();
	}
	
	public ServiceI getService() {
		return service;
	}

	public void setService(ServiceI service) {
		this.service = service;
	}
}
