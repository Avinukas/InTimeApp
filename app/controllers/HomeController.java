package controllers;

import java.io.File;
import play.mvc.Http.*;
import play.api.mvc.MultipartFormData.FilePart;
import play.mvc.*;
import java.io.File;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }
    public Result getCompany() {
        return ok(views.html.company.render());
    }
    public Result getKontakt() {
        return ok(views.html.kontakt.render());
    }
    public Result getImpressum() {
        return ok(views.html.impressum.render());
    }
   /* public Result upload() {
    	MultipartFormData<Object> body = request().body().asMultipartFormData();
    	FilePart picture = body.getFile("picture");
    	if (picture != null) {
    		String fileName = picture.getFilename();
    		String email = session("email");
    		String contentType = picture.getContentType();
    		File file = picture.getFile();
    		File newFile = new File(".//public//images//" + 1);
    		file.renameTo(newFile);
    		return redirect("/company");
    	} else {
    		flash("error", "Missing File");
    		return redirect("/company");
    	}
    }*/
    public Result upload() {
        Http.MultipartFormData<File> body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart<File> picture = body.getFile("picture");
        if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File file = picture.getFile();
            File newFile = new File(".//public//images//" + 1);
    		file.renameTo(newFile);
            return ok("/company");
        } else {
            flash("error", "Missing file");
            return ok("/company");
        }
    }

}
