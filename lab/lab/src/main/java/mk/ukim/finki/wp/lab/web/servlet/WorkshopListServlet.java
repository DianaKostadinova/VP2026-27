package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Workshop;
import mk.ukim.finki.wp.lab.service.WorkshopService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebApplication;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOError;
import java.io.IOException;

@WebServlet(name = "WorkshopListServlet", urlPatterns = "")
public class WorkshopListServlet extends HttpServlet {
    private final WorkshopService workshopService;
    private final SpringTemplateEngine springTemplateEngine;

    public WorkshopListServlet(WorkshopService workshopService, SpringTemplateEngine springTemplateEngine) {
        this.workshopService = workshopService;
        this.springTemplateEngine = springTemplateEngine;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        String text = req.getParameter("text");
        String maxPriceParam = req.getParameter("maxPrice");

        if (text != null && text.isBlank()) {
            text = null;
        }
        Double maxPrice = (maxPriceParam == null || maxPriceParam.isBlank())
                ? null
                : Double.parseDouble(maxPriceParam);

        if (text != null || maxPrice != null) {
            context.setVariable("workshops", workshopService.search(text, maxPrice));
        } else {
            context.setVariable("workshops", workshopService.listAll());
        }

        resp.setContentType("text/html; charset=UTF-8");
        springTemplateEngine.process("listWorkshops.html", context, resp.getWriter());
    }
}