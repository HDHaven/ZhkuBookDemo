package bean;

public class TempStore {
	/**
	 * ��ʱ����ʵ���࣬��Ӧ���ݿ�ĵ�����ʱ��tb_TempStore��
	 */
	private String userName;// ���뿪�������
	private String tempStoreName;// ���뿪��ĵ���
	private String tempStoreDescript;// ��������
	private String tempStoreLicense;// ����Ӫҵִ��
	
	public TempStore() {
	}

	public TempStore(String userName, String tempStoreName, String tempStoreDescript, String tempStoreLicense) {
		super();
		this.userName = userName;
		this.tempStoreName = tempStoreName;
		this.tempStoreDescript = tempStoreDescript;
		this.tempStoreLicense = tempStoreLicense;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTempStoreName() {
		return tempStoreName;
	}

	public void setTempStoreName(String tempStoreName) {
		this.tempStoreName = tempStoreName;
	}

	public String getTempStoreDescript() {
		return tempStoreDescript;
	}

	public void setTempStoreDescript(String tempStoreDescript) {
		this.tempStoreDescript = tempStoreDescript;
	}

	public String getTempStoreLicense() {
		return tempStoreLicense;
	}

	public void setTempStoreLicense(String tempStoreLicense) {
		this.tempStoreLicense = tempStoreLicense;
	}
	
}
