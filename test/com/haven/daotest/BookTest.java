package com.haven.daotest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.haven.bean.PageBean;
import com.haven.dao.BookCommentDAO;
import com.haven.dao.BookDAO;
import com.haven.model.Book;
import com.haven.model.BookComment;
import com.haven.util.MyBatisUtil;

public class BookTest {

	private SqlSession sqlSession = null;
	private BookDAO bi = null;
	
	@Test
	public void testBook_insertOne() {
		try {
			sqlSession = MyBatisUtil.openSession();
			bi = sqlSession.getMapper(BookDAO.class);
			Book b = new Book(1, "�������", "978-456456-123", "���������", "�ǵ�˹��", "������������", 39.99, 0, 100, 
					"��ѧ", 437, "����������Ƽ��Ķ�", "/daodeqingcaolun.jpg");
			int count = bi.insertOne(b);
			System.out.println("����������"+ count);
			System.out.println("ͼ���ţ�"+ b.getBookId());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testBook_insertBatch() {
		try {
			sqlSession = MyBatisUtil.openSession();
			bi = sqlSession.getMapper(BookDAO.class);
			List<Book> bookList = new ArrayList<Book>();
			bookList.add(new Book(3, "��������", "978-456456-123", "���������", "�ǵ�˹��", "������������", 39.99, 0, 100, 
					"��ѧ", 437, "����������Ƽ��Ķ�", "/daodeqingcaolun.jpg"));
			bookList.add(new Book(3, "��������", "978-456456-123", "���������", "�ǵ�˹��", "������������", 39.99, 0, 100, 
					"��ѧ", 437, "����������Ƽ��Ķ�", "/daodeqingcaolun.jpg"));
			bookList.add(new Book(3, "��������", "978-456456-123", "���������", "�ǵ�˹��", "������������", 39.99, 0, 100, 
					"��ѧ", 437, "����������Ƽ��Ķ�", "/daodeqingcaolun.jpg"));
			int count = bi.insertBatch(bookList);
			System.out.println("�����������"+ count);
			for (Book b : bookList) {
				System.out.println("�����ͼ���ţ�"+ b.getBookId());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testBook_deleteOne() {
		try {
			sqlSession = MyBatisUtil.openSession();
			bi = sqlSession.getMapper(BookDAO.class);
			int count = bi.deleteOne(4);
			System.out.println("ɾ����������"+ count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testBook_deleteBatch() {
		try {
			sqlSession = MyBatisUtil.openSession();
			bi = sqlSession.getMapper(BookDAO.class);
			int[] ids = {2, 5, 8};
			int count = bi.deleteBatch(ids);
			System.out.println("ɾ����������"+ count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testBook_update() {
		try {
			sqlSession = MyBatisUtil.openSession();
			bi = sqlSession.getMapper(BookDAO.class);
			Book b = new Book();
			b.setBookId(9);
			b.setBookName("���������");
			b.setBookPrice(49.99);
			b.setBookDescript("�¼ұ���������Ƽ��Ķ�...");
			int count = bi.update(b);
			System.out.println("�޸ĵ�����Ϊ��"+ count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testBook_udpateFromOrder() {
		try {
			sqlSession = MyBatisUtil.openSession();
			bi = sqlSession.getMapper(BookDAO.class);
			Book b = new Book();
			b.setBookId(1);
			b.setBookSaleNum(2);
			b.setBookSumNum(2);
			int count = bi.updateFromOrder(b);
			System.out.println("�޸ĵ�����Ϊ��"+ count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testBook_getBookWithHotSale() {
		try {
			sqlSession = MyBatisUtil.openSession();
			bi = sqlSession.getMapper(BookDAO.class);
//			List<Book> bookList = bi.getBookWithHotSale(null);
			List<Book> bookList = bi.getBookWithHotSale("��������");
			if(bookList != null && !bookList.isEmpty()) {
				for (Book b : bookList) {
					System.out.println("ͼ���ţ�"+ b.getBookId());
					System.out.println("ͼ�����ƣ�"+ b.getBookName());
					System.out.println("���̱�ţ�"+ b.getStoreId());
					System.out.println("ͼ����̣�"+ b.getStoreName());
					System.out.println("ͼ�鵥�ۣ�"+ b.getBookPrice());
					System.out.println("==========================");
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
	
	@Test
	public void testBook_getBookWithNew() {
		try {
			sqlSession = MyBatisUtil.openSession();
			bi = sqlSession.getMapper(BookDAO.class);
//			List<Book> bookList = bi.getBookWithNew(null);
			List<Book> bookList = bi.getBookWithNew("��������");
			if(bookList != null && !bookList.isEmpty()) {
				for (Book b : bookList) {
					System.out.println("ͼ���ţ�"+ b.getBookId());
					System.out.println("ͼ�����ƣ�"+ b.getBookName());
					System.out.println("���̱�ţ�"+ b.getStoreId());
					System.out.println("ͼ����̣�"+ b.getStoreName());
					System.out.println("ͼ�鵥�ۣ�"+ b.getBookPrice());
					System.out.println("==========================");
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
	
	@Test
	public void testBook_getBookByPage() {
		try {
			sqlSession = MyBatisUtil.openSession();
			bi = sqlSession.getMapper(BookDAO.class);
			Map<String, Object> parameter = new HashMap<String, Object>();
			PageBean pb = new PageBean();
			pb.setCurrentPage(1);
			Book book = new Book();
//			book.setStoreName("��������");
			book.setBookName("���");
//			book.setBookClass("��");
			parameter.put("page", pb);
			parameter.put("book", book);
			List<Book> bookList = bi.getBookByPage(parameter);
			if(bookList != null && !bookList.isEmpty()) {
				for (Book b : bookList) {
					System.out.println("ͼ���ţ�"+ b.getBookId());
					System.out.println("ͼ�����ƣ�"+ b.getBookName());
					System.out.println("���̱�ţ�"+ b.getStoreId());
					System.out.println("ͼ����̣�"+ b.getStoreName());
					System.out.println("ͼ�鵥�ۣ�"+ b.getBookPrice());
					System.out.println("==========================");
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
	
	@Test
	public void testBook_getBookInfo() {
		try {
			sqlSession = MyBatisUtil.openSession();
			bi = sqlSession.getMapper(BookDAO.class);
			BookCommentDAO ci = sqlSession.getMapper(BookCommentDAO.class);
			Book book = bi.getBookInfo(1);
			if(book != null) {
				System.out.println("ͼ���ţ�"+ book.getBookId());
				System.out.println("ͼ�����ƣ�"+ book.getBookName());
				System.out.println("ͼ��ҳ����"+ book.getBookPage());
				BookComment comment = new BookComment();
				comment.setBookId(book.getBookId());
				List<BookComment> commentList = ci.getComment(comment);
				if(commentList != null && commentList.size() > 0) {
					System.out.println("ͼ���������£�");
					for (BookComment c : commentList) {
						System.out.println("�����û���"+ c.getUserName());
						System.out.println("���۷�����"+ c.getCommentScore());
						System.out.println("�������ݣ�"+ c.getCommentContent());
						System.out.println("------------------------");
					}
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
	
	@Test
	public void testBook_isExisted() {
		try {
			sqlSession = MyBatisUtil.openSession();
			bi = sqlSession.getMapper(BookDAO.class);
			Book b = new Book(1, "�������", "978-456456-123", "�����", "�ǵ�˹��", "������������", 39.99, 0, 100, 
					"��ѧ", 437, "����������Ƽ��Ķ�", "/daodeqingcaolun.jpg");
			if(bi.isExisted(b) != null) {
				System.out.println("��ͼ���Ѵ��ڣ�");
			} else {
				int count = bi.insertOne(b);
				System.out.println("����������"+ count);
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
