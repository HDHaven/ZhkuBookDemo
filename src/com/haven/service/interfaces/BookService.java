package com.haven.service.interfaces;

import java.util.List;
import java.util.Map;

import com.haven.model.Book;
import com.haven.model.BookComment;

/**
 * ͼ��ҵ���Ľӿ�
 */
public interface BookService {

	/**
	 * ���ͼ�飬����������Ӻ�������ӣ�����ǰ�ж�ͼ���Ƿ���ڣ���������ֵ�޸�ͼ������
	 * @param bookList	��ͼ���б�
	 * @return			���ɹ��򷵻�true�����򷵻�false��
	 */
	boolean addBook(List<Book> bookList);
	
	/**
	 * ����ͼ����ɾ��ͼ�飬��������ɾ��������ɾ��
	 * @param ids	��ͼ����
	 * @return		���ɹ��򷵻�true�����򷵻�false��
	 */
	boolean deleteBook(String[] ids);
	
	/**
	 * ����ͼ�����޸�ͼ����Ϣ
	 * @param book	��ͼ�����
	 * @return		���ɹ��򷵻�true�����򷵻�false��
	 */
	boolean updateBook(Book book);
	
	/**
	 * �û�������ҳ��ȡ����ʱ����ȡ������º�������õ�ͼ��
	 * @param storeName	��������
	 * @return			���ɹ��򷵻�ͼ����Ϣ���ϣ����򷵻�null��
	 */
	Map<String, List<Book>> getInitBook(String storeName);
	
	/**
	 * ���������������ߵ�������ѯͼ�飬��ҳ��ʾ
	 * @param storeName		��ͼ����������
	 * @param bookName		��ͼ������
	 * @param bookClass		��ͼ�����
	 * @param currentPage	����ʾ�ĵ�ǰҳ��
	 * @return				���ɹ��򷵻�ͼ����Ϣ�����򷵻�null��
	 */
	List<Book> searchBookByPage(String storeName, String bookName, String bookClass, String currentPage);
	
	/**
	 * ����ͼ���Ų鿴ͼ����ϸ��Ϣ
	 * @param bookId	��ͼ����
	 * @return			���ɹ��򷵻�ͼ����Ϣ�����򷵻�null��
	 */
	Book getBookInfo(String bookId);
	
	/**
	 * ����ͼ���Ż����û�����ȡ������Ϣ
	 * @param userName	���û���
	 * @param bookId	��ͼ����
	 * @return			���ɹ��򷵻�������Ϣ�����򷵻�null��
	 */
	List<BookComment> getComment(String userName, String bookId);
	
	/**
	 * ���ͼ�����ۣ����˴��鷽������
	 * @param comment	�����۶���
	 * @return			���ɹ��򷵻�true�����򷵻�false��
	 */
	boolean addComment(BookComment comment);
	
	/**
	 * �������۱��ɾ��������Ϣ
	 * @param ids	�����۱��
	 * @return		���ɹ��򷵻�true�����򷵻�false��
	 */
	boolean deleteComment(String[] ids);
	
}
