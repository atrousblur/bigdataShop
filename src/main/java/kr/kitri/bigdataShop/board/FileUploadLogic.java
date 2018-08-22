/*package kr.kitri.bigdataShop.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

@Service
public class FileUploadLogic {

	
	@RequestMapping(value="/advanced/upload.do", method=RequestMethod.POST)
	public String upload(FileUploadDTO fileInfo, HttpSession session) throws Exception {
		// spring mvc(spring mvc 아키텍쳐로 동작하기 위해 필요한, 모든 컴포넌트들의 작업)에서 자동으로
		// 생성해서 넘겨준 업로드된 파일객체인 MultipartFile을 꺼내서 내가 원하는 위치에 저장하기
		
		System.out.println("fileinfo: "+fileInfo);
		// 1. dto에서 MultipartFile객체 꺼내기
		MultipartFile file = fileInfo.getUpFile();
		
		// 2. 저장될 위치
		String path = WebUtils.getRealPath(session.getServletContext(), 
				"/WEB-INF/upload"); // 두번째 매개변수는 실제 저장될 폴더의 위치를 지정
		
		// 3. 파일명
		String fileName = file.getOriginalFilename();
		System.out.println("파일명 : "+fileName+"경로: "+path);
		
		// 4. FileUploadService의 upload메소드를 호출해서 실제 파일을 저장하기
		service.upload(file, path, fileName);
		
		return "advanced/upload";
	}
}
*/