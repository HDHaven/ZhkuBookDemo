package bean;

public class Store {
	/**
	 * ����ʵ���࣬��Ӧ���ݿ��еĵ��̱�tb_Store��
	 */
	private int storeId;// ���̱��
	private String storeName;// ��������
	private String userName;// ��������
	private String storeSaleNum;// ����ͼ��������
	private String storeSale;// ���������۶�
	private String storeEvaluate;// ��������
	private String storeDescript;// ��������
	private String storeLicense;// ����Ӫҵִ��
	
	public Store() {
	}

	public Store(String storeName, String userName, String storeSaleNum, String storeSale, String storeEvaluate,
			String storeDescript, String storeLicense) {
		super();
		this.storeName = storeName;
		this.userName = userName;
		this.storeSaleNum = storeSaleNum;
		this.storeSale = storeSale;
		this.storeEvaluate = storeEvaluate;
		this.storeDescript = storeDescript;
		this.storeLicense = storeLicense;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStoreSaleNum() {
		return storeSaleNum;
	}

	public void setStoreSaleNum(String storeSaleNum) {
		this.storeSaleNum = storeSaleNum;
	}

	public String getStoreSale() {
		return storeSale;
	}

	public void setStoreSale(String storeSale) {
		this.storeSale = storeSale;
	}

	public String getStoreEvaluate() {
		return storeEvaluate;
	}

	public void setStoreEvaluate(String storeEvaluate) {
		this.storeEvaluate = storeEvaluate;
	}

	public String getStoreDescript() {
		return storeDescript;
	}

	public void setStoreDescript(String storeDescript) {
		this.storeDescript = storeDescript;
	}

	public String getStoreLicense() {
		return storeLicense;
	}

	public void setStoreLicense(String storeLicense) {
		this.storeLicense = storeLicense;
	}
	
}
