package bean;

public class TempStore {
	/**
	 * 临时店铺实体类，对应数据库的店铺临时表（tb_TempStore）
	 */
	private String userName;// 申请开店的主人
	private String tempStoreName;// 申请开店的店名
	private String tempStoreDescript;// 店铺描述
	private String tempStoreLicense;// 店铺营业执照
	
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
