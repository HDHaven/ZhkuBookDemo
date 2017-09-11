package com.haven.dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.haven.model.Book;

/**
 *  ��Book.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
@Repository("bookDao")
@Scope("prototype")
public interface BookDAO {

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
	public int deleteBatch(int[] ids);
	
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
	 * ���ݣ������ڣ�ͼ�����ƻ�������ѯͼ�飬��ҳ��ʾ
	 */
	public List<Book> getBookByPage(Map<String, Object> parameter);
	
	/**
	 * ����ͼ���Ż�ȡͼ����ϸ��Ϣ
	 */
	public Book getBookInfo(int bookId);
	
	/**
	 * ����ͼ��ǰ�ж�ͼ���Ƿ��Ѿ�����
	 * ����ͼ�����������Լ�������ͬʱȷ��
	 */
	public Book isExisted(Book book);
	
}
