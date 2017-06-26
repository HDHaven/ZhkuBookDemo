package bean;

/**
 * 临时店铺实体类
 * 
 * @author 黄华冬
 *
 */
public class TempStore {

	private int tempStoreId;
	private String userName;
	private String tempStoreName;
	private String tempStoreDescript;
	private String tempStoreLicense;

	public TempStore() {

	}

	public TempStore(int tempStoreId, String userName, String tempStoreName, String tempStoreDescript,
			String tempStoreLicense) {
		super();
		this.tempStoreId = tempStoreId;
		this.userName = userName;
		this.tempStoreName = tempStoreName;
		this.tempStoreDescript = tempStoreDescript;
		this.tempStoreLicense = tempStoreLicense;
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

}
