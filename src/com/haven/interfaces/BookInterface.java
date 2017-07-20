package com.haven.interfaces;

import java.util.List;

import com.haven.model.Book;

/**
 *  ��Book.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
public interface BookInterface {

	/**
	 * ����һ����
	 */
	public int insertOne(Book book);
	
	/**
	 * ��������ͼ��
	 */
	public int insertBatch(List<Book> bookList);
	
	/**
	 * ɾ��һ����
	 */
	public int deleteOne(int bookId);
	
	/**
	 * ����ɾ��ͼ��
	 */
	public int deleteBatch(List<Integer> ids);
	
	/**
	 * �޸�ͼ����Ϣ
	 */
	public int update(Book book);
	
	/**
	 * �µ��ɹ����޸�ͼ��������Լ������
	 * ������������Ϳ����Ӧ������ȵģ���������ͼ��Ĺ�����
	 */
	public int updateFromOrder(Book book);
	
	/**
	 * ��ȡ�������ڣ�������õ�4����
	 */
	public List<Book> getBookWithHotSale(String storeName);
	
	/**
	 * ��ȡ�������ڣ������ϴ���4����
	 */
	public List<Book> getBookWithNew(String storeName);
	
	/**
	 * ���ݣ������ڣ�ͼ�����ƻ�������ѯͼ��
	 */
	public List<Book> getBook(Book book);
	
	/**
	 * ����ͼ���Ż�ȡͼ����ϸ��Ϣ
	 */
	public Book getBookInfo(int bookId);
	
	/**
	 * ����ͼ��ǰ�ж�ͼ���Ƿ��Ѿ�����
	 * ����ͼ�����͵�����ͬʱȷ��
	 */
	public Book isExisted(Book book);
	
}
