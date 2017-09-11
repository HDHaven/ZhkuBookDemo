package com.haven.daotest;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.haven.dao.BookCommentDAO;
import com.haven.model.BookComment;
import com.haven.util.MyBatisUtil;

public class BookCommentTest {

	private SqlSession sqlSession = null;
	private BookCommentDAO ci = null;
	
	@Test
	public void testComment_insert() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ci = sqlSession.getMapper(BookCommentDAO.class);
			BookComment comment = new BookComment(1, 3, "Jayin", 4, "���Ż��У�������׷����");
			int count = ci.insert(comment);
			System.out.println("�����������"+ count);
			System.out.println("��������۱�ţ�"+ comment.getCommentId());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testComment_deleteOne() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ci = sqlSession.getMapper(BookCommentDAO.class);
			int count = ci.deleteOne(1);
			System.out.println("ɾ��������"+ count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testComment_deleteBatch() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ci = sqlSession.getMapper(BookCommentDAO.class);
			int[] ids = {2, 3, 4};
			int count = ci.deleteBatch(ids);
			System.out.println("ɾ��������"+ count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testComment_getComment() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ci = sqlSession.getMapper(BookCommentDAO.class);
			BookComment comment = new BookComment();
			comment.setUserName("Haven");
//			comment.setBookId(1);
			List<BookComment> commentList = ci.getComment(comment);
			if(commentList != null && !commentList.isEmpty()) {
				for (BookComment c : commentList) {
					System.out.println("���۱�ţ�"+ c.getCommentId());
					System.out.println("�����ţ�"+ c.getOrderId());
					System.out.println("ͼ���ţ�"+ c.getBookId());
					System.out.println("���۷�����"+ c.getCommentScore());
					System.out.println("�������ݣ�"+ c.getCommentContent());
					System.out.println("============================");
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
}
