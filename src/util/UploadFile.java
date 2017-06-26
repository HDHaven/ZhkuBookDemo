package util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * �ϴ��ļ�������
 * @author �ƻ���
 *
 */
public class UploadFile {

	/**
	 * ���ܣ��������·�������ļ�����
	 * @param request
	 * @param response
	 * @param uploadPath
	 * @return �ɹ��򷵻��ļ��������򷵻�null��
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws ServletException
	 */
	public static String uploadFile(HttpServletRequest request, HttpServletResponse response, String uploadPath) throws IllegalStateException, IOException, ServletException {
		String recFileName = null;
		Part part = request.getPart("file");
		String header = part.getHeader("content-disposition");
		String fileName = ((header.split(";")[2]).split("=")[1]).replaceAll("\"", "");
		recFileName = System.currentTimeMillis() + fileName;
		String path = request.getServletContext().getRealPath("/images/"+ uploadPath);
		File f = new File(path);
		if(! f.exists()) {
			f.mkdirs();
		}
		try{
			part.write(path + File.separator + recFileName);
		} catch(Exception e) {
			recFileName = null;
			System.out.println(e.getMessage());
		}
		return recFileName;
	}
	
}
