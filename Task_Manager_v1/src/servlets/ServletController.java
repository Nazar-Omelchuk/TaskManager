package servlets;

import app.model.Task;
import app.services.TaskService;
import app.services.TaskSortCriteria;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "ServletController", urlPatterns = {"/main/*"})
public class ServletController extends HttpServlet {

    TaskService taskService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        taskService = (TaskService) config.getServletContext().getAttribute("taskService");
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            pathInfo = "/";
        }
        try {
            switch (pathInfo) {
                case "/task":
                    task(request, response);
                    break;
                case "/add":
                    add(request, response);
                    break;
                case "/edit":
                    edit(request, response);
                    break;
                case "/delete":
                    delete(request, response);
                    break;
                case "/completed":
                    completed(request, response);
                    break;
                case "/search":
                case "/":
                default:
                    tasks(request, response);
                    break;
            }
        } catch (RuntimeException ex) {
            error(request, response, "Упс, " + ex.getMessage());
        }
    }



    protected void tasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sort = request.getParameter("sort");
        TaskSortCriteria taskSortCriteria;
        if (sort == null || sort.equals("")) {
            taskSortCriteria = TaskSortCriteria.BY_DATE;
        } else {
            taskSortCriteria = TaskSortCriteria.valueOf(sort);
        }
        Collection<Task> tasks = taskService.getSortAllTasks(taskSortCriteria);
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);

    }

    protected void task(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));

        Task task = taskService.getTask(taskId);

        request.setAttribute("task", task);

        request.getRequestDispatcher("/WEB-INF/view/task.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer priority = Integer.valueOf(request.getParameter("priority"));
        String text = request.getParameter("text");

        if (priority >= 1 && !(text.equals(""))) {
            taskService.addTask(text, priority);
            response.sendRedirect(".");
        } else {
            if (priority == 0 && text.equals("0")){
                request.getRequestDispatcher("/WEB-INF/view/add.jsp").forward(request, response);
            } else {
                error(request, response, "Ви неправильно ввели дані! Поверніться назад, та спробуйте ще раз!");
            }
        }
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        Integer newPriority = Integer.valueOf(request.getParameter("newPriority"));
        String text = request.getParameter("text");

        Task task = taskService.getTask(taskId);

        if(task.getPriority().equals(newPriority) && text.equals(task.getText())) {
            request.setAttribute("task", task);
            request.getRequestDispatcher("/WEB-INF/view/edit.jsp").forward(request, response);
        } else {
            taskService.editTask(taskId, text, newPriority);
            request.setAttribute("task", task);
            task(request, response);
        }

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        taskService.deleteTask(taskId);
        response.sendRedirect(".");

    }

    protected void completed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        taskService.completedTask(taskId);
        response.sendRedirect(".");

    }

    protected void error(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}