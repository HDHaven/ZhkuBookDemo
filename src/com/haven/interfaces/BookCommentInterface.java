package com.haven.interfaces;

import java.util.List;

import com.haven.model.BookComment;

/**
 *  ��BookComment.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
public interface BookCommentInterface {

	/**
	 * ����һ������
	 */
	public int insert(BookComment comment);
	
	/**
	 * ���ݱ��ɾ��һ������
	 */
	public int deleteOne(int commentId);
	
	/**
	 * �����û�����ɾ������
	 */
	public int deleteBatch(List<Integer> ids);
	
	/**
	 * �û���ȡ�Լ�������
	 */
	public List<BookComment> getComment(String userName);
	
}
