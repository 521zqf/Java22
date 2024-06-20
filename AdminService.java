import java.util.List;

public class AdminService {
    private AdminDAO adminDAO = new AdminDAO();

    public List<Admin> getAllAdmins() {
        return adminDAO.getAllAdmins();
    }

    public void saveAdmin(Admin admin) {
        adminDAO.saveAdmin(admin);
    }

    public void deleteAdmin(Long id) {
        adminDAO.deleteAdmin(id);
    }
}

