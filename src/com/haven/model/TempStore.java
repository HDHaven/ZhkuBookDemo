package com.haven.model;

/**
 * ��ʱ����ʵ���࣬��Ӧ���ݿ��е���ʱ���̱�
 */
public class TempStore {

	private int tempStoreId; // ��ʱ���̱��
	private String userName; // ���뿪����û���
	private String tempStoreName; // ��ʱ��������
	private String tempStoreDescript; // ��������
	private String tempStoreLicense; // ����Ӫҵִ��
	private String tempStoreState; // ���״̬������
	
	public TempStore() {
	}

	public TempStore(String userName, String tempStoreName, String tempStoreDescript, 
			String tempStoreLicense, String tempStoreState) {
//		super();
		this.userName = userName;
		this.tempStoreName = tempStoreName;
		this.tempStoreDescript = tempStoreDescript;
		this.tempStoreLicense = tempStoreLicense;
		this.tempStoreState = tempStoreState;
	}

	public int getTempStoreId() {
		return tempStoreId;
	}

	public void setTempStoreId(int tempStoreId) {
		this.tempStoreId = tempStoreId;
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

	public String getTempStoreState() {
		return tempStoreState;
	}

	public void setTempStoreState(String tempStoreState) {
		this.tempStoreState = tempStoreState;
	}
	
}
