package bean;

public class Store {
	/**
	 * ����ʵ���࣬��Ӧ���ݿ��еĵ��̱�tb_Store��
	 */
	private int storeId;// ���̱��
	private String storeName;// ��������
	private String userName;// ��������
	private int storeSaleNum;// ����ͼ��������
	private int storeSale;// ���������۶�
	private int storeScore;// ����������
	private int storeComment;// ��������������
	private int storeEvaluate;// ����ƽ������
	private String storeDescript;// ��������
	private String storeLicense;// ����Ӫҵִ��
	private String storeState;// ����״̬��Ӫҵ�С���Ϣ�С������У�

	public Store() {
	}

	public Store(int storeId, String storeName, String userName, int storeSaleNum, int storeSale, int storeScore,
			int storeComment, int storeEvaluate, String storeDescript, String storeLicense, String storeState) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.userName = userName;
		this.storeSaleNum = storeSaleNum;
		this.storeSale = storeSale;
		this.storeScore = storeScore;
		this.storeComment = storeComment;
		this.storeEvaluate = storeEvaluate;
		this.storeDescript = storeDescript;
		this.storeLicense = storeLicense;
		this.storeState = storeState;
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

	public int getStoreSaleNum() {
		return storeSaleNum;
	}

	public void setStoreSaleNum(int storeSaleNum) {
		this.storeSaleNum = storeSaleNum;
	}

	public int getStoreSale() {
		return storeSale;
	}

	public void setStoreSale(int storeSale) {
		this.storeSale = storeSale;
	}

	public int getStoreScore() {
		return storeScore;
	}

	public void setStoreScore(int storeScore) {
		this.storeScore = storeScore;
	}

	public int getStoreComment() {
		return storeComment;
	}

	public void setStoreComment(int storeComment) {
		this.storeComment = storeComment;
	}

	public int getStoreEvaluate() {
		return storeEvaluate;
	}

	public void setStoreEvaluate(int storeEvaluate) {
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

	public String getStoreState() {
		return storeState;
	}

	public void setStoreState(String storeState) {
		this.storeState = storeState;
	}

}
