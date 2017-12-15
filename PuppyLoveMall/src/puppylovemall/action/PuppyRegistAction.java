package puppylovemall.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.Action;
import common.ActionForward;
import puppylovemall.svc.PuppyRegistService;
import puppylovemall.vo.Puppy;


public class PuppyRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PuppyRegistService puppyRegistService = new PuppyRegistService();
		String realFolder = "";
		
		String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request,
					realFolder, maxSize, encType,
					new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("image");
		Puppy puppy = new Puppy(
				0, 
				multi.getParameter("kind"), 
				Integer.parseInt(multi.getParameter("price")), 
				image, 
				multi.getParameter("country"), 
				Integer.parseInt(multi.getParameter("height")), 
				Integer.parseInt(multi.getParameter("weight")), 
				multi.getParameter("content"), 
				0);
		boolean isRegistSuccess = puppyRegistService.registPuppy(puppy);
		ActionForward forward = null;
		
		if(isRegistSuccess){
			forward = new ActionForward("puppyList.pu", true);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록 실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
