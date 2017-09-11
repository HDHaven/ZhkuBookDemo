package com.haven.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.haven.model.BookComment;

/**
 *  ��BookComment.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
@Repository("commentDao")
@Scope("prototype")
public interface BookCommentDAO {

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
	public int deleteBatch(int[] ids);
	
	/**
	 * �����û�������ͼ���Ż�ȡͼ������
	 */
	public List<BookComment> getComment(BookComment comment);
	
}
